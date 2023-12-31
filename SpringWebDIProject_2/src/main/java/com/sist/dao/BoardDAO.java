package com.sist.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	
	public BoardVO boardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}
	
	public BoardVO boradUpdateData(int no)
	{
		return mapper.boardDetailData(no);
	}
	
	public boolean boardUpdate(BoardVO vo)
	{
		boolean bCheck = false;
		String db_pwd = mapper.boardGetPassword(vo.getNo());
		
		if(db_pwd.equals(vo.getPwd()))
		{
			bCheck = true;
			mapper.boardUpdate(vo);
		}
		return bCheck;
	}
	
	public boolean boardDelete(int no, String pwd)
	{
		boolean bCheck = false;
		String db_pwd = mapper.boardGetPassword(no);
		
		if(db_pwd.equals(pwd))
		{
			bCheck = true;
			mapper.boardDelete(no);
		}
		
		return bCheck;
	}
	
}
