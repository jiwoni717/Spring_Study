package com.sist.web.service;

import com.sist.web.dao.*;
import com.sist.web.vo.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodMapper mapper;
	
	@Override
	public List<CategoryVO> categoryListData() {
		// TODO Auto-generated method stub
		return mapper.categoryListData();
	}

}
