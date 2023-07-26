package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.CategoryMapper;

@Repository //DAO 위에 Repository
public class CategoryDAO {
	@Autowired
	private CategoryMapper mapper;
	
	public List<CategoryVO> categoryListData()
	{
		return mapper.categoryListData();
	}
	
}
