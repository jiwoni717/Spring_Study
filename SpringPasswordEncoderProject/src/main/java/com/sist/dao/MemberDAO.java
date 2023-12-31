package com.sist.dao;

import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private MemberMapper mapper;
	
	public void memberInsert(MemberVO vo)
	{
		mapper.memberInsert(vo);
	}
	
	public int memberIdCheck(String id)
	{
		return mapper.memberIdCheck(id);
	}
	
	public MemberVO memberLogin(String id)
	{
		return mapper.memberLogin(id);
	}
}
