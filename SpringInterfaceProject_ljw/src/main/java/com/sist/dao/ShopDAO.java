package com.sist.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class ShopDAO {
	@Autowired
	private ShopMapper mapper;
	
	public List<ShopVO> goodsListData(Map map)
	{
		return mapper.goodsListData(map);
	}
	
	public int goodsTotalPage()
	{
		return mapper.goodsTotalPage();
	}
	
	public List<ShopVO> goodsFindData(Map map)
	{
		return mapper.goodsFindData(map);
	}
}
