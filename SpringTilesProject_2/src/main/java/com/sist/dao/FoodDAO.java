package com.sist.dao;

import com.sist.mapper.*;
import com.sist.vo.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<CategoryVO> foodCategoryData() {
		return mapper.foodCategoryData();
	}
	
	public List<FoodVO> foodListData(int cno) {
		return mapper.foodListData(cno);
	}
	
	public CategoryVO foodCategoryInfoData(int cno) {
		return mapper.foodCategoryInfoData(cno);
	}
	
	public List<FoodVO> foodFindData(Map map) {
		return mapper.foodFindData(map);
	}
	
	public int foodFindTotalPage(String fd) {
		return mapper.foodFindTotalPage(fd);
	}
	
}
