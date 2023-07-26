package com.sist.main;

public class MainClass {

	public static void main(String[] args) {
		
		Hello hello = new Hello();
		String msg = hello.sayHello("홍길동");
		/*			------------------------> MainClass는 Hello 클래스에 의존 한다 → 결합성(의존성)이 강한 프로그램
												장점 : 연결하기 쉽다
												단점 : 변경시 다른 클래스에 영향을 끼친다 → 유지보수하기 어려움
												스프링에서는 가급적이면 new를 사용하지 않는다
		*/
		System.out.println(msg);

	}

}
