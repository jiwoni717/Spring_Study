package com.sist.main2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//String[] xml = {"member.xml", "sawon.xml", "student.xml"};
		
		ApplicationContext app = new ClassPathXmlApplicationContext("app-*.xml");
		
/*
		1. 메모리 할당 → 생성자 호출
		2. setterDI → setXxx() 값을 채운다
		3. init-method에 등록된 메소드 호출
		4. 개발자에 의해 필요한 메소드 호출
		5. destroy-method 메모리 해제
 */
		
		Sawon s = (Sawon)app.getBean("sa");
		s.init();
		s.print();
		Member m = (Member)app.getBean("mem");
		m.init();
		m.print();
		Student std = (Student)app.getBean("std");
		std.init();
		std.print();
		
	}

}
