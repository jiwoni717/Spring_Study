package com.sist.dao;

import java.util.*;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SeoulDAO extends SqlSessionDaoSupport {
	public List<SeoulLocationVO> seoulListData(Map map)
	{
		return getSqlSession().selectList("seoulListData",map);
	}
	
	public int seoulTotalPage()
	{
		return getSqlSession().selectOne("seoulTotalPage");
	}
	
	public List<SeoulLocationVO> seoulFindData(String title)
	{
		return getSqlSession().selectList("seoulFindData",title);
	}
}
