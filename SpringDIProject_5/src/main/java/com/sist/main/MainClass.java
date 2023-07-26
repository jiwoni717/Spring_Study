package com.sist.main;

import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;

public class MainClass {

	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		FoodDAO fdao = (FoodDAO)app.getBean("fdao");
		
		//SeoulDAO dao = (SeoulDAO)app.getBean("dao");
		
		Map map = new HashedMap();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("페이지를 입력하세요 : ");
		int curpage = scan.nextInt();
		
		int rowSize = 10;
		int start = (rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
				
		map.put("start", start);
		map.put("end", end);
		
		List<FoodVO> fList = fdao.foodCategoryListData(map);
		for(FoodVO fvo:fList)
		{
			
		}
/*		
		List<SeoulLocationVO> list = dao.seoulListData(map);
		
		System.out.println("=========== 서울 명소 ===========");
		for(SeoulLocationVO vo:list)
		{
			System.out.println(vo.getNo()+"."+vo.getTitle());
		}
		System.out.println("===============================");
		
		int totalpage = dao.seoulTotalPage();
		
		System.out.println("      "+curpage+" page / "+totalpage+" pages      ");
		System.out.println("===============================");
		
		System.out.print("검색어 입력 : ");
		String title = scan.next();
		
		List<SeoulLocationVO> fList = dao.seoulFindData(title);
		
		System.out.println("=========== 검색 결과 ===========");
		for(SeoulLocationVO vo:fList)
		{
			System.out.println(vo.getNo()+"."+vo.getTitle());
		}
		System.out.println("===============================");
*/
		
	}

}
