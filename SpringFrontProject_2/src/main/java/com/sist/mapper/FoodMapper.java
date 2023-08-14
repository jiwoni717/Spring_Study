package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodLocationVO;

public interface FoodMapper {

	// 목록
	@Select("SELECT fno,name,poster,score,num "
			+ "FROM (SELECT fno,name,poster,score,rownum as num "
			+ "FROM (SELECT fno,name,poster,score "
			+ "FROM food_location ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodLocationVO> foodListData(Map map);
	
	// 상세보기 한 페이지 안에서 출력
	@Select("SELECT fno,name,poster,score,parking,time,type,address,pbone,"
			+ "price,menu "
			+ "FROM food_location "
			+ "WHERE fno=#{fno}")
	public FoodLocationVO foodDetailData(int fno);
	
	// 검색
	@Select("SELECT fno,name,poster,score,num "
			+ "FROM (SELECT fno,name,poster,score,rownum as num "
			+ "FROM (SELECT fno,name,poster,score "
			+ "FROM food_location WHERE address LIKE '%'||#{address}||'%' ORDER BY fno ASC))  "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodLocationVO> foodFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food_location")
	public int foodTotalPage();	
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food_location "
			+ "WHERE address LIKE '%'||#{address}||'%'")
	public int foodFindTotalPage(String address);
}
