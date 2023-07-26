package com.sist.main;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;
import com.sist.config.*;

@Component("mc")
public class MainClass {

	@Autowired
	private EmpDAO dao;
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(EmpConfig.class);
		MainClass mc = (MainClass)app.getBean("mc");
		Scanner scan = new Scanner(System.in);
		
		List<EmpVO> list = mc.dao.empListData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}
		
		System.out.print("사번 입력 : ");
		int empno = scan.nextInt();
		
		EmpVO vo = mc.dao.empDetailData(empno);
		
		System.out.println("=======================================");
		System.out.println("사번 : "+vo.getEmpno());
		System.out.println("이름 : "+vo.getEname());
		System.out.println("입사일 : "+vo.getHiredate());
		System.out.println("직위 : "+vo.getJob());
		System.out.println("급여 : "+vo.getSal());
		System.out.println("성과급 : "+vo.getComm());
		System.out.println("=======================================");
		
	}

}
