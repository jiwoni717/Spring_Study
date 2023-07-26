/*
		┌라이브러리 : 완제품
		└프레임워크 : 레고(개발에서 기본이 되는 틀 제공 → 기능을 추가해서 사용)
		
		1. 프레임워크
		  - 스프링의 목표
		    클래스와 클래스간의 느슨한 결합, 낮은 결합도 유지 → 변경/추가시 다른 클래스에 영향이 없게 개발 → POJO(독립적인 클래스 제작)
		    메소드마다 반복해서 사용하는 소스코드를 공통 모듈로 분리(응집력이 높은 프로그램 제작) → AOP(OOP를 보완)
		  - 클래스를 모아서 관리(=컨테이너)
		    생성에 필요한 데이터나 객체 주소가 필요할 때도 있다 → DI
			1)컨테이너의 종류
			  - BeanFactory : 가장 단순한 컨테이너, 사용자가 만든 클래스만 관리 → CORE
			  	└ApplicationContext : AOP, 메세지 지원 → 구현된 클래스 : ClassPathApplicationContext
			  													  FileSystemXmlApplicationContext
			  	  └WebApplicationContext : MVC(웹)
			  ┌─────────────────────────────────────────────┐	  
			  │	컨테이너의 역할									│
			  │	  1) DL : 클래스를 찾아주는 역할					│
			  │	  		  getBean()							│
			  │	  2) DI : 필요한 데이터를 받아서 초기화				│
			  │	  		  setter DI							│
			  │	  		  constructor DI(생성자의 매개변수를 이용)	│
			  └─────────────────────────────────────────────┘
			2) DI
			  - 변수값 주입하는 과정, 객체 주소 설정
			  - 변수가 private → 변수에 접근이 어려움 → setter DI / constructor DI
			3) AOP의 개념
			4) MVC구조 파악
			5) 보안
			
		스프링에서 지원하는 라이브러리
		  Spring CORE : DI(객체 생성~소멸)
		  Spring AOP : 공통모듈
		    Before
		    After
		    After-Returning
		    After-Throwing
		    Around
		    JointPoint, PointCut, 위빙
		    Advice
		  Spring ORM : 데이터베이스 연동(MyBatis, Hibernate, JPA)
		  Spring WEB : JSP 연동
		  Spring MVC
		  
		XML 사용법
		  - 스프링에서 객체를 생성하기 위해서는 클래스명을 전송 → 메모리 할당 가능
		  - 클래스 한개 설정
		    <bean id="a" class="A">
		    <bean id="b" class="B">
		  - 패키지 단위 설정
		    <context:component-scan base=package="com.sist.*">
		
		Annotation
		  - 메모리 할당
		    @Component : 일반 클래스
		    @Repository : DAO(저장소)
		    @Service : DAO 여러개를 합쳐서 한번에 처리할 때(BI)
		    @Controller : MVC구조의 Model(페이지 지정)
		    @RestController : MVC구조의 Model → JSON
		    @ControllerAdvice : 공통 예외처리
		    @RestControllerAdvice : 공통 예외처리
		    
		Bean(객체)의 생명주기
		  빈 생성 → 주입(DI) → init-method → 빈 사용 → destroy-method(소멸)
 */
package com.sist.main;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "C:\\springDev\\springStudy\\SpringDIProject_8\\src\\main\\java\\com\\sist\\main\\app.xml";
		ApplicatonContext app = new ClassPathApplicationContext(path);
		Sawon sa = (Sawon)app.getBean("sa");
		System.out.println("사번 : "+sa.getSabun());
		System.out.println("이름 : "+sa.getName());
		System.out.println("부서 : "+sa.getDept());
		System.out.println("직위 : "+sa.getJob());
	}

}
