package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;


@RestController
public class ShopRestController {

	@Autowired
	private ShopDAO dao;
	
	@GetMapping(value = "shop/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String goods_list_vue(String page)
	{
		String result="";
		
		try {
			if(page==null)
				page="1";
			
			int curpage = Integer.parseInt(page);
			
			Map map = new HashMap();
			map.put("start", (curpage*12)-11);
			map.put("end", curpage*12);
			
			List<ShopVO> list = dao.goodsListData(map);
			
			int totalpage = dao.goodsTotalPage();
			
			JSONArray arr = new JSONArray();
			int i=0;
			for(ShopVO vo:list)
			{
				JSONObject obj = new JSONObject();
				
				obj.put("gno", vo.getGno());
				
				String gname = vo.getGoods_name();
				if(gname.length()>=18)
				{
					gname = gname.substring(0, 18)+"...";
				}
				obj.put("goods_name", gname);
				
				
				
				obj.put("goods_image", vo.getGoods_image());
				obj.put("cprice", vo.getDbcprice());
				obj.put("price", vo.getDbprice());
				
				if(i==0)
				{
					obj.put("curpage", curpage);
					obj.put("totalpage", totalpage);
				}
				arr.add(obj);
				i++;
			}
			result = arr.toJSONString();
			
		} catch(Exception ex) {}
		
		return result;
	}
}
