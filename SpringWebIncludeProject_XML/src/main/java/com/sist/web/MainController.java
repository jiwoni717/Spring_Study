package com.sist.web;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 *		Spring? > Java 라이브러리
 *			* 요소
 *			1. DI : Spring을 통해서 객체 생성~소멸
 *								  -------
 *									필요한 데이터가 있는 경우에 데이터를 전송 (멤버 변수의 초기화 담당)
 *									= 변수의 초기화
 *										1) 명시적 초기화 : 클래스를 제작 시에 변수에 값을 직접 채운다 (Spring 이용 x)
 *											public class A {
 *												private String name="홍길동";
 *											}
 *										2) 생성자 : 생성자 DI
 *										3) setter 이용 : setter DI	=> xml 이용 or java 이용
 *			2. AOP : 프로그램 (핵심 코드, 공통 코드)
 *									 --------
 *										ex) getConnection();
 *					=> 클래스마다 공통으로 사용되는 메소드 모았다가 필요한 시기에 자동 호출이 가능
 *					=> 트랜잭션, LOG, 보안, ...
 *			3. MVC : 웹 제작 (View/Model)
 *					Model : 데이터 관리 (java)
 *					View : 데이터 출력 전용
 *					Controller : 요청을 받고, 데이터를 전송하는 역할		=> 이미 라이브러리로 제작되어 있다
 *								DispatcherServlet :  톰캣에 의해 구동 (web.xml)		
 *									1) DispatcherServlet 등록
 *									2) DispatcherServlet 찾는 방법
 *										<url-pattern>*.do</url-patter>
 *				** 요청을 받는 경우 (요청 데이터 전송)
 *					=> request 안에 담겨서 들어온다 => requset.getParameter();
 *					=> request는 사용자 정보 (IP, PORT) 가지고 있다 (보안상 문제)
 *						= 가급적이면 사용하지 않는다
 *						= 사용자 정의 메소드를 만들 때 매개변수 설정하면 DispatcherServlet에 의해 매개변수가 채워진다
 *						= jsp 결과 값은 전송 (model)
 *				** Model 작성
 *					1) @Controller 설정해야 메모리 할당이 가능하다 (메소드 찾는 경우)
 *					2) 메소드
 *						= 리턴형 : Spring, void
 *								 ------- 화면 이동에 관련횐 jsp 정보 / redirect 정보
 *						= 매개변수 : jsp에서 제공하는 내장 객체 설정
 *									=> HttpServletRequest, HttpServletResponse, HttpSession
 *									@GetMapping()
 *									public String displat(HttpSession session)
 *										=> VO 단위, String[], 기본형, List 단위
 *					3) 찾기 (메소드)
 *						@GetMapping : get 방식으로 요청(default) => <a> ajax, axios ...
 *						@PostMapping : <form>, ajax, axious
 *						@RequestMapping : get post 동시에 처리가 가능
 *					4) return : 반드시 jsp명 (확장자는 사용하지 않는다)
 *								재호출 : redirect:.do
 *				** MVC 구동 방식
 *					1) 사용자 요청 => .do
 *					2) DispatcherServlet이 요청 받는다
 *					3) DispatcherServlet => HandlerMapping	: 클래스 찾아서 메소드 호출하라고 전송
 *															  --------------------------- Annotation (GetMapping,PostMapping)
 *					4) Model에서 처리 => 사용자 정의 (개발자)
 *					5) Model에서 처리된 결과를 DisptcherServlet이 받는다
 *					6) ViewReslver : jsp를 찾아서 request를 전송하는 역할
 *					7) jsp에서 request에 담긴 데이터를 출력
 *					8) DispatcherServlet에 의해 브라우저 화면 전송
 *		
 */

@Controller
public class MainController {

	// 1. 객체 주소를 받을 게 있는지 확인
	
	@Autowired
	private FoodDAO dao;
	
	// 사용자 요청시 처리
	// 첫 화면
	@GetMapping("main/main.do")
	public String main_main(String cno,Model model) {
						//			   ------------ 내가 사용자에게 보낼 값
						//  ---------- 사용자가 보내준 값
		// default 값 설정 : cno int로 안 받는 이유 => int는 null값이 없어서 String으로 받아야 함
		if(cno==null) 
			cno="1";
		
		Map map=new HashMap();
		map.put("cno", Integer.parseInt(cno));
		List<CategoryVO> list=dao.foodCategoryData(map);
		
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../main/home.jsp");
		return "main/main";
	}
	
}
