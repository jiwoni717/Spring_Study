package com.sist.web.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import com.sist.web.entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.web.dao.*;

@RestController
public class CampRestController {
	
	@Autowired
	private CampDAO dao;
	
	@GetMapping(value = "camp/camp_cookie.do", produces = "text/plain;charset=UTF-8")
	public String camp_cookie(HttpServletRequest request) throws Exception
	{
		Cookie[] cookies = request.getCookies();
		
		List<CampEntity> list = new ArrayList<CampEntity>();
		if(cookies!=null)
		{
			for(int i=cookies.length-1;i>=0;i--)
			{
				String key = cookies[i].getName();
				if(key.startsWith("camp_"))
				{
					String data = cookies[i].getValue();
					CampEntity vo = new CampEntity();
					vo = dao.findByCno(Integer.parseInt(data));
					String name = vo.getName();
					if(name.length()>7)
					{
						vo.setName(name.substring(0,7)+"...");
					}
					
					list.add(vo);
				}
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		
		return json;
		
	}
}
