package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.FoodDAO;
import java.util.*;
import com.sist.vo.*;

@RestController
public class FoodRestController {

	@Autowired
	private FoodDAO dao;
	
	@GetMapping(value="food/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_list_vue(String page) {
		
		String result="";
		
		try {
			if(page==null)
				page="1";
			int curpage=Integer.parseInt(page);
			Map map=new HashMap();
			map.put("start", (curpage*12)-11);
			map.put("end", curpage*12);
			List<FoodLocationVO> list=dao.foodListData(map);
			int totalpage=dao.foodTotalPage();
			
			// List => [] 변환 : JSONArray
			// FoodLocationVO => {} 변환 : JSONObject
			// [{},{},{},...]
			
			// javascript로 보내려면 json으로 변환해야 함(vuejs가 javasciprt)
			JSONArray arr=new JSONArray();
			int i=0;
			for(FoodLocationVO vo:list) {
				JSONObject obj=new JSONObject();
				// fno,name,poster,score sql문장으로 가져오는 데이터
				// {fno:1,name:"",poster:"",score:5.0}
				obj.put("fno", vo.getFno());
				obj.put("name", vo.getName());
				obj.put("score", vo.getScore());
				String poster=vo.getPoster();
				poster=poster.substring(0,poster.indexOf("^"));
				poster=poster.replace("#", "&");
				obj.put("poster", poster);
				
				
				// 0일 때만 curapge,totalpage 첨부했다 => json 데이터가 양은 상관없다 
				if(i==0) {
					obj.put("curpage", curpage);
					obj.put("totalpage", totalpage);
				}
				
				arr.add(obj);
				i++;
			}
			result=arr.toJSONString();
			
		} catch(Exception ex) {}
		
		return result;
	}
	
	/*
	 * 보내는 방법
	 * 	1. 일반 문자열 =>NOID NOPWD OK=> text/html
	 * 	2. 데이터 블록 (JSON) => text/plain
	 * 		List = [] => JSONArray
	 * 		vo = {} => JSONObject
	 * 	3. XML => text/xml
	 */
	@GetMapping(value="food/find_vue.do",produces = "test/plain; charset=UTF-8")
	public String food_find(int page,String fd) {
					// 시작 초기값을 이미 1로 받아둬서 int로 받는다
		String result="";
		try {
			int curpage=page;
			
			Map map=new HashMap ();
			map.put("start", (curpage*12)-11);
			map.put("end", curpage*12);
			map.put("address", fd);
			//	address로 받았음(mapper)
			
			List<FoodLocationVO> list=dao.foodFindData(map);
			int totalpage=dao.foodFindTotalPage(fd);
			final int BLOCK=5;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;

			
			// curpage 1~5 => startPage :1
			// curpage 6~10 => EndPage :6
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
			if(endPage>totalpage)
				endPage=totalpage;
			
			// JSON 변경
			int i=0;
			JSONArray arr=new JSONArray();
			
			for(FoodLocationVO vo:list) {
				
				JSONObject obj=new JSONObject();
				
				obj.put("fno", vo.getFno());
				obj.put("name", vo.getName());
				obj.put("score", vo.getScore());
				String poster=vo.getPoster();
				poster=poster.substring(0,poster.indexOf("^"));
				poster=poster.replace("#", "&");
				obj.put("poster", poster);
				
				if(i==0) {
					
					obj.put("curpage", curpage);
					obj.put("totalpage", totalpage);
					obj.put("startPage", startPage);
					obj.put("endPage", endPage);
				}
				
				i++;
				arr.add(obj);
			}
			
			result=arr.toJSONString();
			
			// [{curpage},{totalpage},{startPage},..]	=> 배열로 값을 넘김
			//   -------- object
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
}
