package com.sist.service;

import java.util.*;
import com.sist.vo.*;

public interface RecipeService {

	public List<RecipeVO> recipeListData(Map map);
	
	public int recipeTotalPage();
}
