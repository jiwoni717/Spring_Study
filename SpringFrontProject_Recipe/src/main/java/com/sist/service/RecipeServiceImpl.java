package com.sist.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sist.dao.*;
import com.sist.vo.*;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	private RecipeDAO dao;

	@Override
	public List<RecipeVO> recipeListData(Map map) {
		return dao.recipeListData(map);
	}

	@Override
	public int recipeTotalPage() {
		return dao.recipeTotalPage();
	}
}
