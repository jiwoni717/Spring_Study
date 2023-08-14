/*
		자바
		  - 데이터형 / 변수 / 연산자 / 제어문 / 배열(1차)
		  - 객체지향 프로그램(클래스/객체) 객체지향 3대 요소 (캡슐화, 상속, 포함, 다양성)
		  - 추상클래스 / 인터페이스
		  - 예외처리
		  - 라이브러리
		    - Collection, 제네릭스
		    - IO
		  → 캡슐화 vs 은닉화 / 상속 vs 포함 / 오버라이딩 vs 오버로딩
		  → 추상클래스 vs 인터페이스 / 인터페이스의 장점
		  → 예외처리의 목적
		  → 컬렉션, 제네릭스
		오라클
		  - DQL(SELECT)
		  - DML(INSERT, UPDATE, DELETE)
		  - DDL(CREATE, ALTER, DROP, TRUNCATE) + 제약조건
		  - TCL(COMMIT, ROLLBACK)
		  - PL/SQL(프로시저)
		  - JDBC (DBCP/ORM(MyBatis,JPA))
		  → 조인의 종류 / 서브쿼리의 종류
		  → 제약조건
		  → 프로시저와 트리거 차이점
		  → DAO vs Service
		HTML5 / CSS
		  → GET vs POST
		JavaScript
		  - 변수, 제어문 / 연산자
		  - 함수
		  - 이벤트
		  - 태그 제어(DOM)
		  - 라이브러리(Jquery, VueJS, React)
		  → var / let / const
		  → 클로저
		  → prototype
		  → VueJS vs React
		JSP
		  - 지시자(page, taglib), 내장객체(request, response, session, application)
		  - 액션태그(<jsp:include>)
		  - TagLib(<c:~~>), EL(${})
		  - MVC
		  → MVC구조(동작)
		Spring
		  - DI, AOP, MVC
		  - option(websocket, tast, security, spring-boot)
		  → DI
		  → AOP
		AWS
		  - 호스팅
 */
package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsController {
	@GetMapping("goods/list.do")
	public String goods_list()
	{
		return "goods/list";
	}
	
	@GetMapping("goods/detail.do")
	public String goods_detail(int no, Model model)
	{	
		model.addAttribute("no", no);
		return "goods/detail";
	}
}
