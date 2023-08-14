package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {
	
	@GetMapping("recipe/list.do")
	public String recile_list()
	{
		return "recipe/list";
	}
}
