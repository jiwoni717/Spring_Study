package com.sist.dao;

import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class FoodDAO extends SqlSessionDaoSupport{
	
	public List<FoodVO> foodCategoryListData(Map map)
	{
		return getSqlSession().selectList("foodCategoryListData", map);
	}
	
	public int foodCategoryTotalPage()
	{
		return getSqlSession().selectOne("foodCategoryTotalPage");
	}
}
