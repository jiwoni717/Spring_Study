package com.sist.web;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import com.sist.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private MemberDAO dao;
	
	@PostMapping(value = "member/join_ok.do", produces = "text/plain;charset=UTF-8")
	public String member_join(MemberVO vo)
	{
		
		String result="";
		
		try {
			
			String en = encoder.encode(vo.getPwd()); // → 암호화
			vo.setPwd(en);
			dao.memberInsert(vo);
			
			result="YES";
		}catch(Exception ex) {
			result="NO";
			ex.printStackTrace();
		}
		
		return result;
	}
	
	@PostMapping(value = "member/login_ok.do", produces = "text/plain;charset=UTF-8")
	public String member_login(String id, String pwd, HttpSession session)
	/*
		매개변수로 session 선언 → DispatcherServlet에 의해 값 주입
		필요한 객체는 매개변수를 이용해서 받는다
		사용자 전송(요청) → request.getParameter()
		받을 수 있는 클래스 : 내장 객체는 가능, Model(전송 객체) → forward에서만 사용
		sendRedirect → RedirectAttributes
		@RestController → 다른 언어와 연결할 때 사용
		JSON, <script>, 일반 문자열... → @ResponseBody
	*/
	{
		String result = "";
		
		int count = dao.memberIdCheck(id);
		
		if(count==0)
		{
			result="NOID";
		}
		else
		{
			MemberVO vo = dao.memberLogin(id);
			if(encoder.matches(pwd, vo.getPwd())) //→ 실제 값과 암호화된 비밀번호 비교
			{
				result="OK";
				
				// 세션에 저장
				session.setAttribute("id", id);
				session.setAttribute("name", vo.getName());
				session.setAttribute("sex", vo.getSex());
			}
			else
			{
				// 비밀번호가 틀린 상태 → 같은 값이어도 암호화는 다르다
				result="NOPWD";
			}
		}
		
		return result;
	}
	
}
