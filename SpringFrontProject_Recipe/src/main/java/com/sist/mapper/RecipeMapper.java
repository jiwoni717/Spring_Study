package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface RecipeMapper {

	@Select("SELECT no, title, poster, chef, hit, num "
			+ "FROM (SELECT no, title, poster, chef, hit, rownum as num "
			+ "FROM (SELECT no, title, poster, chef, hit "
			+ "FROM recipe ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe")
	public int recipeTotalPage();
}
