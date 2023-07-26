package com.sist.main;

/*
 * Spring : 이미 제작되어 있는 라이브러리
 * 
 * 	1. container : 사용자가 등록한 클래스를 관리한다 
 * 		POJO ? 일반 클래스, 인터페이스, 상속이 없는 기본적인 getter setter만 있는 자바 객체
 * 	2. DI :	Spring을 통해서 프로그램 동작을 위한 필요한 데이터를 전송
 * 			결합성을 낮게 만든다 => 클래스에 영향
 * 			클래스에 설정되 변수에 대한 값을 주입
 * 				1) 명시적 초기화 (x)
 * 				2) 생성자 (constructor DI) => 매개변수에 값을 지정
 * 				3) setter (setter DI) => setXxx()에 값을 지정
 * 					(properties)
 * 			클래스와 클래스 간의 의존관계를 설정한다
 * 			------------------------------ 변수의 초기화, 필요한 메소드 호출
 * 
 * 		=> 클래스가 많다면 xml이 커진다 (속도 느려짐)
 * 		   ----------------------
 * 					ㅣ
 * 				패키지 단위로 등록 => Spring에 등록 / 등록이 안 되는 클래스 구분 >> annotation ***
 * 			class의 구분
 * 				1) 사용자 정의 클래스 : package 단위로 등록
 * 				2) 라이브러리 클래스 <bean>
 * 
 * 			xml : 파일이 한 개 (공통)
 * 			annotation :  클래스마다 .. (개발자)
 * 				==> MyBatis 
 * 						XML
 * 						Annotation
 * 						XML + Annotation
 * 
 * 		
 * 		=> xml로 등록해줘야 사용 가능 (메뉴얼) => Spring에 넘겨줌
 * 		=> xml, annotation >> container >> 프로그램 동작이 가능
 * 		=> 동작
 * 			xml을 제공 >> container (클래스 관리 영역)
 * 						----------
 * 						1) BeanFactory : core (DI)
 * 						2) ApplicationContext (XML) : core + AOP
 * 							=> 순수한 자바로 되어있음
 * 								AnnotationConfigApplicationContext
 * 						3) WebApplicationContext : core + AOP + MVC
 * 
 * 		** 동작 순서
 * 			- Bean 생성( = Class 메모리 할당)
 * 			  <bean id="a" class="A"> => Class.forName("A") => 찾는 조건은 ID (ID는 중복 불가)
 * 			- 의존성 주입 (DI)
 * 			  class가 동작하기 위한 멤버변수의 초기화 담당
 * 								------- 일반변수 (값) , 클래스 객체 (주소값)
 * 										------		 --------
 * 										기본 데이터 타입		A,B, ...
 * 				<bean id="" class=""
 * 					p:name=""
 * 					p:age=""
 * 					----------- 일반 변수
 * 					p:dao-ref=""
 * 					----------- 클래스 객체 (생성된 객체의 주소값)
 * 				/>
 * 			- init-method : 생성과 동시에 자동으로 메소드 호출
 * 				=> ex) 크롤링, 트위터 읽기, 자동 로그인, 드라이버 등록 등...
 * 			- 개발자가 등록된 클래스 객체를 활용 (스프링이 관리하는 부분이 아님)
 * 			- destroy-method : 객체 소멸시 호출
 * 			  --------------- db.close()
 * 			- 소멸
 * 
 * 		** 일반 멤버 변수는 데이터베이스 정보 외에는 거의 사용 빈도가 없다
 * 
 *  3. AOP : 간결한 프로그램을 만들기 위함 => 공동 모듈을 모아서 적용 (중복 제거)
 *  4. MVC : 웹 관련 (데이터 관리 + 화면 출력)
 *  5. Front + Back => Restful
 *  6. 보안 (권한, 암호화, 복호화)
 *  -------------------------------------------------------------------- 프레임 워크
 *  
 *  기타 : 데이터베이스 (ORM) => MyBatis, 트랜잭션
 * 
 */

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;

public class MainClass {

	public static void main(String[] args) {
		
		// Spring에 등록
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");	// bean의 id 명칭을 주고 class 객체 받아 옴
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getSal()+" "+vo.getHiredate());
		}
		System.out.println("===================================================");
		Scanner scan = new Scanner(System.in);
		System.out.print("사번 입력 : ");
		int empno = scan.nextInt();
		EmpVO vo = dao.empDetailData(empno);
		System.out.println("======= 사원 정보 =======");
		System.out.println("사번 : "+vo.getEmpno());
		System.out.println("이름 : "+vo.getEname());
		System.out.println("부서 : "+vo.getDeptno());
		System.out.println("직위 : "+vo.getJob());
		System.out.println("사수명 : "+vo.getMgr());
		System.out.println("입사일 : "+vo.getDbday());
		System.out.println("급여 : "+vo.getSal());
		System.out.println("성과급 : "+vo.getComm());
		
	}

}






