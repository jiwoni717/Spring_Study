package com.sist.main4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
/*
		ClassPathXmlApplicationContext → XML을 파싱(XML에 등록된 클래스를 읽어감)
		ClassPath : src/main/java
		
		Container(스프링이 주로 하는 역할)
		  개발자가 만드는 클래스 → 한개의 기능 수행(컴포넌트) → 컴포넌트 여러개를 관리하는게 컨테이너
		  1. 역할
		    1) 객체(컴포넌트) 생성	┐
		    2) 객체의 변수 초기화		┼객체의 생명주기 관리
		    3) 객체 소멸			┘
		
			스프링에서 지원하는 Container
				BeanFactory -----------> core(DI)
					 |
			 ApplicationContext(Application) -----------> core(DI), AOP
			 		 |→ AnnotaionConfigApplicationContext
		   WebApplicationContext(MVC) -----------> core(DI), AOP, MVC
		
 */
		A a = (A)app.getBean("a");
		a.display();
	}

}
