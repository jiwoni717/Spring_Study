package com.sist.web.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sist.web.dao.*;
import com.sist.web.entity.*;

@Controller
@RequestMapping("camp/")
public class CampController {

	@Autowired
	private CampDAO dao;
	
	@GetMapping("camp_main")
	public String camp_main(String page, Model model)
	{
		if(page==null)
			page="1";
		
		int curpage = Integer.parseInt(page);
		int rowSize = 6;
		int start = (rowSize*curpage)-rowSize;
		
		List<CampEntity> list = dao.campList(start);
		
		for(CampEntity vo : list)
		{
			if(vo.getImage().contains("^"))
			{
				String image = vo.getImage();
				image = image.substring(0, image.indexOf("^"));
				vo.setImage(image);
			}
		}
		
		int totalpage = dao.campTotalPage(start);
		
		final int BLOCK = 5;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage = totalpage;
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		model.addAttribute("main_html", "camp/camp_main");
		return "main";
	}
}
