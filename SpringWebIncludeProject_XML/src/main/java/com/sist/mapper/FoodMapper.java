package com.sist.mapper;

import java.util.*;
import org.apache.ibatis.annotations.Select;
import com.sist.vo.*;

public interface FoodMapper {

	// 어노테이션으로 동적쿼리 만들기
	@Select("<script>"
			+ "SELECT cno,poster,title "
			+ "FROM food_category "
			+ "WHERE "
			+ "<if test=\"cno==1\">"
			+ "cno BETWEEN 1 AND 10 "
			+ "</if>"
			+ "<if test=\"cno==2\">"
			+ "cno BETWEEN 11 AND 20 "
			+ "</if>"
			+ "<if test=\"cno==3\">"
			+ "cno BETWEEN 21 AND 30 "
			+ "</if>"
			+ "ORDER BY cno ASC"
			+ "</script>")
	public List<CategoryVO> foodCategoryData(Map map);
	
	// 카테고리 정보 읽기
	@Select("SELECT title,subject "
			+ "FROM food_category "
			+ "WHERE cno=#{cno}")
	public CategoryVO foodCategoryInfoData(int cno);
	
	// 카테고리별 맛집 정보 읽기
	@Select("SELECT fno,cno,name,poster,address,score,type,phone "
			+ "FROM food_house "
			+ "WHERE cno=#{cno}")
	public List<FoodVO> foodListData(int cno);
	
	// 맛집별 상세 보기
	@Select("SELECT fno,cno,name,score,poster,phone,address,type,time,parking,price,menu "
			+ "FROM food_house "
			+ "WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	
	/* 
	 *  mapper에서는 반드시 매개변수가 1개이다
	 *  dao는 상관없음
	 *  	=> 데이터가 vo에 있는 데이터면 vo
	 *  	=> vo에 없는 변수 첨부시에는 map
	 *  	=> 동적쿼리를 이용할 때는 map
	 *  
	 */
}
