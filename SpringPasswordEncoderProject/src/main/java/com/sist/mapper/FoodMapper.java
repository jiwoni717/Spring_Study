package com.sist.mapper;

import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

public interface FoodMapper {
	
/*
	<select id="foodCategoryListData" resultType="CategoryVO" parameterType="hashmap">
				      메소드명							리턴형					  매개변수
				      => 3개 다 동일해야함
				      동적쿼리 나올 때만 xml로 SQL문 적는게 편함
 */
	public List<CategoryVO> foodCategoryListData(Map map);
	
	public CategoryVO foodCategoryInfoData(int cno);
	
	public List<FoodVO> foodListData(int cno);
	
	public FoodVO foodDetailData(int fno);
}
