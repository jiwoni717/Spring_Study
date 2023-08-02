/*
		aspect : OOP의 단점인 콜백함수(시스템에 의해 자동 호출되는 함수) 존재X를 보완
		스프링에서는 반복적인 코딩을 모아서 관리 → 필요시에 의해 자동 호출
		사용자 정의는 많이 사용하지 않는다
		
		AOP
		 ┌어떤 메소드에 적용시킬건지? : PointCut(메소드명 지정)
		 │                      pointcut="execution(* com.sist.main.*.*(..))" → com.sist.main 패키지 안에 있는 모든 class 모든 메소드
		 │										   --- 리턴형        --------- 클래스명.메소드명(..)
		 │						pointcut="within("com.sist.main.*")" → 패키지 단위로 등록
		 └호출되는 위치가 어디인지? : JoinPoint
		 						┌@Before : try 시작 - 핵심 코딩 전
		 						├@Around : 핵심 코딩 시작, 끝
		 						├@After-Throwing : 오류처리
		 						├@After : finally
		 						└@After-Returning : 정상 수행 했을 때(리턴값 처리될 때)
		  PointCut + JoinPoint = Advice → Aspect
		  Weaving : 통합 → Proxy패턴(대리자)
 */
package com.sist.aop;

import java.util.*;
import com.sist.dao.*;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmpAespect {
	@Autowired
	private EmpDAO dao;
	
	@Before("execution(* com.sist.dao.EmpDAO.emp*(..))") //try 시작과 동시에 호출
	public void getConnection()
	{
		System.out.println("오라클 연결");
		dao.getConnection();
	}
	
	@After("execution(* com.sist.dao.EmpDAO.emp*(..))") //finally에서 호출
	public void disConnection()
	{
		System.out.println("오라클 연결 해제");
		dao.disConnection();
	}
	
	@AfterReturning(value = "execution(* com.sist.dao.EmpDAO.emp*(..))", returning="obj")
	public void print(Object obj)
	{
		List<EmpVO> list = (List<EmpVO>)obj;
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getDbday()+" "+vo.getSal());
		}
	}
	
	@AfterThrowing(value = "execution(* com.sist.dao.EmpDAO.emp*(..))", throwing = "ex")
	public void exception(Throwable ex)
	{
		System.out.println("에러 발생...");
		ex.printStackTrace();
	}
}
