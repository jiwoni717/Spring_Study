package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface BoardMapper {
	@Select("SELECT no, subject, name, TO_CHAR(regdate,'yyyy-MM-dd') as dbday, hit, num "
			+ "FROM (SELECT /*+ INDEX_DESC(springBoard sb_no_pk)*/no, subject, name, regdate, hit, rownum as num "
			+ "FROM (SELECT no, subject, name, regdate, hit FROM springBoard)) WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	
	// 총 페이지
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springBoard")
	public int boardTotalPage();

	@Update("UPDATE springBoard SET hit=hit+1 WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no, subject, name, TO_CHAR(regdate,'yyyy-MM-dd') as dbday, hit, content FROM springBoard WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	
	@Insert("INSERT INTO springBoard(no, name, subject, content, pwd) "
			+ "VALUES(sb_no_seq.nextval, #{name}, #{subject}, #{content}, #{pwd})")
	public void boardInsert(BoardVO vo);
	
	// 수정
	@Select("SELECT no, name, subject, content FROM springBoard WHERE no=#{no}")
	public BoardVO boardUpdateData(int no);
	
	@Select("SELECT pwd FROM springBoard WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	@Update("UPDATE springBoard SET name=#{name}, subject=#{subject}, content=#{content} WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
	
	// 삭제
	@Delete("DELETE FROM springBoard WHERE no=#{no}")
	public void boardDelete(int no);
	
	
}
