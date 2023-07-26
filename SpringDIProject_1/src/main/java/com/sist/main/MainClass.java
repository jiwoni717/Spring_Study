package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		Sawon s1 = (Sawon)app.getBean("sa1");
		System.out.println("사번 : "+s1.getSabun());
		System.out.println("이름 : "+s1.getName());
		System.out.println("부서 : "+s1.getDept());
		System.out.println("직위 : "+s1.getJob());
		System.out.println("급여 : "+s1.getPay());
		
		// 자동 형변환
		Sawon s2 = app.getBean("sa2",Sawon.class);
		
		Sawon s3 = (Sawon)app.getBean("sa3");
	}

}
