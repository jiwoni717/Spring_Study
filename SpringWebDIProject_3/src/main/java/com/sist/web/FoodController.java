package com.sist.web;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@RequestMapping("food/category.do")
	//                             ┌> 실행하자마자 보여줘야하는데 int로 가져오면 null값 String으로 받아서 값을 지정해준다
	public String food_category(String cno, Model model)
	{
		if(cno==null)
			cno="1";
		
		Map map = new HashMap();
		map.put("cno", Integer.parseInt(cno));
		
		List<CategoryVO> list = dao.categoryListData(map);
		
		model.addAttribute("list", list);
		return "food/category";
	}
}
