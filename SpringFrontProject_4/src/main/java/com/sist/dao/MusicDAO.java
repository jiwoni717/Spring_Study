package com.sist.dao;

import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MusicDAO {
	
	@Autowired
	private MusicMapper mapper;
	
	public List<MusicVO> musicListData(int cno)
	{
		return mapper.musicListData(cno);
	}
	
	public MusicVO musicDetailData(int mno)
	{
		return mapper.musicDetailData(mno);
	}
}
