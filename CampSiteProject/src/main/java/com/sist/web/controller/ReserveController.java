package com.sist.web.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.web.entity.*;
import com.sist.web.dao.*;

@Controller
public class ReserveController {
	
	@Autowired
	private ReserveDAO dao;
	
	@GetMapping("reserve/reserve_main")
	public String reserve_main(Model model)
	{
		model.addAttribute("main_html", "reserve/reserve_main");
		return "main";
	}
	
	@PostMapping("reserve/reserve_ok")
	public void reserve_ok(ReserveEntity vo)
	{
		dao.save(vo);
	}
	
	@PostMapping("reserve/reserve_list")
	public String reserve_list(String email, String password, Model model)
	{
		List<ReserveEntity> list = dao.reserveListData(email, password);
		
		model.addAttribute("list", list);
		model.addAttribute("main_html", "reserve/reserve_list");
		return "main";
	}
	
}
