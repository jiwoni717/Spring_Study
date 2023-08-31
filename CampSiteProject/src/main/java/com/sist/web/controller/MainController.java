package com.sist.web.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.sist.web.dao.*;
import com.sist.web.entity.*;

@Controller
public class MainController {
	
	@Autowired
	private CampDAO dao;
	
	@GetMapping("/")
	public String main(Model model)
	{	
		List<CampEntity> list = dao.mainCampList();
		
		for(CampEntity vo : list)
		{
			if(vo.getImage().contains("^"))
			{
				String image = vo.getImage();
				image = image.substring(0, image.indexOf("^"));
				vo.setImage(image);
			}
		}
		
		model.addAttribute("list", list);
		model.addAttribute("main_html", "main/home");
		return "main";
	}
}
