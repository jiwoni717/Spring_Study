package com.sist.main2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;

public class MainClass {

	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		MyDAO dao = (MyDAO)app.getBean("dao");
		dao.aopInsert();
		dao.aopSelect();
		dao.aopUpdate();
		dao.aopDelete();
		
	}

}
