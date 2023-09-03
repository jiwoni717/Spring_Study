package com.sist.web.controller;

import java.util.*;
import java.lang.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
		for(ReserveEntity vo:list)
		{
			if(vo.getImage().contains("^"))
			{
				String img = vo.getImage();
				
				img = img.substring(0, img.indexOf("^"));
				vo.setImage(img);
			}
		}
		
		model.addAttribute("list", list);
		model.addAttribute("main_html", "reserve/reserve_list");
		return "main";
	}
	
	@GetMapping("reserve_update")
	public String reserve_update(int rno, Model model)
	{
		ReserveEntity vo = dao.findByRno(rno);
		
		model.addAttribute("vo", vo);
		model.addAttribute("rno", rno);
		model.addAttribute("main_html", "reserve/reserve_update");
		return "main";
	}
	
	@PostMapping("reserve_update_ok")
	public String reserve_update_ok(ReserveEntity vo)
	{
		ReserveEntity rvo = dao.findByRno(vo.getRno());
		vo.setCno(rvo.getCno());
		vo.setImage(rvo.getImage());
		vo.setCname(rvo.getCname());
		vo.setEmail(rvo.getEmail());
		vo.setPassword(rvo.getPassword());
		
		dao.save(vo);
		
		try {
            Thread.sleep(3000);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
		
		return "redirect:/";
	}
	
	@GetMapping("reserve_delete")
	public String reserve_delete(int rno, Model model)
	{
		model.addAttribute("rno", rno);
		model.addAttribute("main_html", "reserve/reserve_delete");
		return "main";
	}
	
	@PostMapping("reserve_delete_ok")
	public String reserve_delete_ok(int rno, String password)
	{
		ReserveEntity vo = dao.findByRno(rno);
		
		if(vo.getPassword().equals(password))
		{
			dao.delete(vo);
		}
		
		try {
            Thread.sleep(3000);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
		
		return "redirect:/";
	}
	
}
