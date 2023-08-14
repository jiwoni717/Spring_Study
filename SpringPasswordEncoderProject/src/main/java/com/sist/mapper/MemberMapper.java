package com.sist.mapper;

import java.util.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.sist.vo.*;

public interface MemberMapper {
	@Insert("INSERT INTO springTestMember VALUES(#{id}, #{pwd}, #{name}, #{sex}, SYSDATE)")
	public void memberInsert(MemberVO vo);
	
	@Select("SELECT COUNT(*) FROM springTestMember WHERE id=#{id}")
	public int memberIdCheck(String id);
	
	@Select("SELECT pwd, name, sex FROM springTestMember WHERE id=#{id}")
	public MemberVO memberLogin(String id);
}
