package com.sist.main4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Sawon {
	private int sabun, pay;
	private String name, dept, job;
	public Sawon() {}
	
	public void print()
	{
		System.out.println("사번 : "+sabun);
		System.out.println("이름 : "+name);
		System.out.println("부서 : "+dept);
		System.out.println("직위 : "+job);
		System.out.println("연봉 : "+pay);
	}
	
	public void init()
	{
		System.out.println("=================== 사원 정보 ===================");
	}
	
	public void destroy()
	{
		System.out.println("객체 메모리 해제...");
	}
}
