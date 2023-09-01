package com.sist.web.controller;

import java.util.*;
import java.lang.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.web.entity.*;

import groovyjarjarantlr4.v4.parse.ANTLRParser.prequelConstruct_return;

import com.sist.web.dao.*;

@Controller
@RequestMapping("reserve/")
public class ReserveController {
	
	@Autowired
	private ReserveDAO dao;
	
	@GetMapping("reserve_main")
	public String reserve_main(Model model)
	{
		model.addAttribute("main_html", "reserve/reserve_main");
		return "main";
	}
	
	@PostMapping("reserve_ok")
	public String reserve_ok(ReserveEntity vo, Model model)
	{
		dao.save(vo);
		
		try {
            Thread.sleep(3000);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
		
		model.addAttribute("main_html", "main/home");
		return "main";
	}
	
	@PostMapping("reserve_list")
	public String reserve_list(String email, String password, Model model)
	{
		List<ReserveEntity> list = dao.reserveListData(email, password);
		
		model.addAttribute("list", list);
		model.addAttribute("main_html", "reserve/reserve_list");
		return "main";
	}
	
}
