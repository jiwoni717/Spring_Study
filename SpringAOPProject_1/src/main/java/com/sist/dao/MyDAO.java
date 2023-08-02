package com.sist.dao;

public class MyDAO {
	public void getConnection()
	{
		System.out.println("오라클 연결");
	}
	public void disConnection()
	{
		System.out.println("오라클 해제");
	}
	
	public void aopSelect()
	{
		getConnection();
		System.out.println("SELECT문 실행...");
		disConnection();
	}
	
	public void aopInsert()
	{
		getConnection();
		System.out.println("INSERT문 실행...");
		disConnection();
	}
	
	public void aopUpdate()
	{
		getConnection();
		System.out.println("UPDATE문 실행...");
		disConnection();
	}
	
	public void aopDelete()
	{
		getConnection();
		System.out.println("DELETE문 실행...");
		disConnection();
	}
}
