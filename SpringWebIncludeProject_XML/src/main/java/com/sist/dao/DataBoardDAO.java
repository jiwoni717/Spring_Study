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
	
	public List<DataBoardVO> databoardListData(Map map) {
		return mapper.databoardListData(map);
	}
	
	public int databardTotalPage() {
		return mapper.databardTotalPage();
	}
	
	public void databoardInsert(DataBoardVO vo) {
		mapper.databoardInsert(vo);
	}
	
	public DataBoardVO boardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}
	
	public List<DataBoardVO> boardSearchData(Map map) {
		return mapper.boardSearchData(map);
	}
	
	public DataBoardVO boardUpdateData(int no) {
		return mapper.boardDetailData(no);
	}
	
	public boolean databoardUpdate(DataBoardVO vo) {
		boolean bCheck = false;
		String db_pwd = mapper.databoardGetPassword(vo.getNo());
		
		if(db_pwd.equals(vo.getPwd()))
		{
			bCheck = true;
			mapper.databoardUpdate(vo);
		}
		
		return bCheck;
	}
	
	public boolean databoardDelete(int no, String pwd)
	{
		boolean bCheck = false;
		String db_pwd = mapper.databoardGetPassword(no);
		
		if(db_pwd.equals(pwd))
		{
			bCheck = true;
			mapper.databoardDelete(no);
		}
		
		return bCheck;
	}
}
