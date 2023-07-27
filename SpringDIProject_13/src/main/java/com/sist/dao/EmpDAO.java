package com.sist.dao;

import java.util.*;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sist.vo.EmpVO;

public class EmpDAO extends SqlSessionDaoSupport{
	public List<EmpVO> empdeptListData()
	{
		return getSqlSession().selectList("empdeptListData");
	}
	
	public EmpVO empdeptDetailData(int empno)
	{
		return getSqlSession().selectOne("empdeptDetailData", empno);
	}
}
