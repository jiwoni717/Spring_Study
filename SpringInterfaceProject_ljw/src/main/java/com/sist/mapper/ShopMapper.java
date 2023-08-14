package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface ShopMapper {
	
	@Select("SELECT gno, goods_name, goods_image, TO_CHAR(cprice, '999,999') as dbcprice, TO_CHAR(price, '999,999') as dbprice, num "
			+ "FROM (SELECT gno, goods_name, goods_image, cprice, price, rownum AS num "
			+ "FROM (SELECT gno, goods_name, goods_image, cprice, price " 
			+ "FROM goods ORDER BY gno ASC)) WHERE num BETWEEN #{start} AND #{end}")
	public List<ShopVO> goodsListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods")
	public int goodsTotalPage();
	
	@Select("SELECT gno, goods_name, goods_image, TO_CHAR(cprice, '999,999') as dbcprice, TO_CHAR(price, '999,999') as dbprice, num "
			+ "FROM (SELECT gno, goods_name, goods_image, cprice, price, rownum AS num "
			+ "FROM (SELECT /*+ INDEX_ASC(gs_gno_pk)*/gno, goods_name, goods_image, cprice, price " 
			+ "FROM goods WHERE goods_name LIKE '%'||#{fd}||'%')) WHERE num BETWEEN #{start} AND #{end}")
	public List<ShopVO> goodsFindData(Map map);
}
