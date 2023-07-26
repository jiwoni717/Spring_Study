package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
import com.sist.vo.*;

public class NatureDAO extends SqlSessionDaoSupport {
	
	public List<SeoulNatureVO> natureListData() {
		
		return getSqlSession().selectList("natureListData");
	}
	
	public SeoulNatureVO natureDetailData(int no)
	{
		return getSqlSession().selectOne("natureDetailData", no);
	}
	
	
}
