package com.sist.commons;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // @Controller의 예외처리를 한번에(=전역예외처리) → RestController는 적용 안됨
public class CommonException {
	@ExceptionHandler(RuntimeException.class)
	public void runtimeException(RuntimeException ex)
	{
		System.out.println("========= RuntimeException =========");
		ex.printStackTrace();
		System.out.println("====================================");
	}
	
	@ExceptionHandler(SQLException.class)
	public void sqlException(SQLException ex)
	{
		System.out.println("=========== SQLException ===========");
		ex.printStackTrace();
		System.out.println("====================================");
	}
	
	@ExceptionHandler(IOException.class)
	public void ioException(IOException ex)
	{
		System.out.println("=========== IOException ===========");
		ex.printStackTrace();
		System.out.println("====================================");
	}
	
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex)
	{
		System.out.println("============ Exception ============");
		ex.printStackTrace();
		System.out.println("====================================");
	}
}
