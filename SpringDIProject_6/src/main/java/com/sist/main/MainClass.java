package com.sist.main;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sist.dao.*;
import com.sist.vo.*;
import com.sun.tools.jdeprscan.scan.Scan;

public class MainClass {

	public static void main(String[] args) {

	}
/*	
	@Test // static은 Test안됨
	public void locationMain()
	{
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		LocationDAO dao = (LocationDAO)app.getBean("ldao");
		List<SeoulLocationVO> list = dao.locationListData();
		
		for(SeoulLocationVO vo:list)
		{
			System.out.println(vo.getNo()+"."+vo.getTitle());
		}
	}
	
	@Test
	public void locationDetail()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("명소 번호를 입력하세요 : ");
		int no = scan.nextInt();
		
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		LocationDAO dao = (LocationDAO)app.getBean("ldao");
		SeoulLocationVO vo = dao.locationDetailData(no);
		
		System.out.println("Title : "+vo.getTitle());
		System.out.println("Address : "+vo.getAddress());
		System.out.println("Message : "+vo.getMsg());
	}
*/
	@Test
	public void shopMain()
	{
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		ShopDAO dao = (ShopDAO)app.getBean("sdao");
		List<SeoulShopVO> list = dao.shopListData();
		
		System.out.println("==============================================");
		for(SeoulShopVO vo:list)
		{
			System.out.println(vo.getNo()+"."+vo.getTitle());
		}
		System.out.println("==============================================");
	}
	
	@Test
	public void shopDetail()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("상점 번호 : ");
		int no = scan.nextInt();
		
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		ShopDAO dao = (ShopDAO)app.getBean("sdao");
		SeoulShopVO vo = dao.shopDetailData(no);
		
		System.out.println("==============================================");
		System.out.println("Title : "+vo.getTitle());
		System.out.println("Address : "+vo.getAddress());
		System.out.println("==============================================");
	}

}
