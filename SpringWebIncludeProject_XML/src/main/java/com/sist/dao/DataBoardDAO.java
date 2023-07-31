package com.sist.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class DataBoardDAO {

	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> databoardListData(Map map){
		return mapper.databoardListData(map);
	}
	
	public int databardTotalPage(){
		return mapper.databardTotalPage();
	}
	
	public void databoardInsert(DataBoardVO vo){
		mapper.databoardInsert(vo);
	}
}
