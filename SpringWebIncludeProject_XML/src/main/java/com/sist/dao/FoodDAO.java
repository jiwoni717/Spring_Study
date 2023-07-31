package com.sist.dao;

import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDAO {
	
	// Spring으로부터 구현된 클래스의 주소값을 받는다 (자동 주입)
	@Autowired
	private FoodMapper mapper;

	public List<CategoryVO> foodCategoryData(Map map) {
		return mapper.foodCategoryData(map);
	}
	
	/*
	 * 	@Select("SELECT title,subject "
			+ "FROM food_category "
			+ "WHERE cno=#{cno}")*/
		public CategoryVO foodCategoryInfoData(int cno) {
			return mapper.foodCategoryInfoData(cno);
		}
		

		/*@Select("SELECT fno,cno,name,poster,address,score,type,phone "
				+ "FROM food_house "
				+ "WHERE cno=#{cno}")*/
		public List<FoodVO> foodListData(int cno) {
			return mapper.foodListData(cno);
		}
	
	/*
	 * 	@Select("SELECT fno,cno,name,score,poster,phone,address,type,time,parking,price,manu "
			+ "FROM food_house "
			+ "WHERE fno=#{fno}")*/
		public FoodVO foodDetailData(int fno) {
			return mapper.foodDetailData(fno);
		}
}
