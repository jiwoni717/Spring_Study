package com.sist.main2;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Getter;
import lombok.Setter;

public class Sawon implements BeanNameAware, InitializingBean, DisposableBean {
	private int sabun;
	private String name, dept;
	
	public Sawon() {
		System.out.println("Sawon() Call...");
		// <bean id="sa"..../> 읽자마자 생성자 호출
	}
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		System.out.println("setSabun() Call... : "+sabun);
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("setName() Call... : "+name);
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		System.out.println("setDept() Call... : "+dept);
		this.dept = dept;
	}
	
	public void init()
	{
		System.out.println("init() Call...");
		System.out.println("================ 사원 정보 ================");
	}
	public void print()
	{
		System.out.println("사용자 정의 호출...");
		System.out.println("사번 : "+sabun);
		System.out.println("이름 : "+name);
		System.out.println("부서 : "+dept);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Setter 처리 종료");
	}
	
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("setBeanName() : "+name);
	}
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("객체 소멸");
		
	}
}
