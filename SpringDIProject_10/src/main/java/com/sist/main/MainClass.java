package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;

@Component("mc")
public class MainClass {

	@Autowired //→스프링에서 자동으로 객체 주소값을 찾아서 주입
	@Qualifier("bdao") //→ fdao / bdao 중에 선택
	private Board board;
	
	@Autowired
	private FreeBoardDAO f;
	
	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");

	}

}
