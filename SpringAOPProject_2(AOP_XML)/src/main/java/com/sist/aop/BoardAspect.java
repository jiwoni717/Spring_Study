/*
		언제 어디서 호출할지 여부 확인
		1. 시점 → pointcut → 메소드
		2. 호출위치 → joinpoint
		  1) @Before : try 시작 전
		  2) @After : finally
		  3) @Around : 핵심 코딩 위 아래 → 로그파일(시작, 끝 시간에 체크) / 트랜잭션 처리로 많이 씀
		  4) @After-Throwing : catch(오류발생)
		  5) @After-Returning : 정상 수행
		
			@Transactional
			public void display()
			{
				try {
					@Before
					---------------------------- ┐ → conn.setAutoCommit(false)
					-- 핵심코딩					 │@Around
					---------------------------- ┘ → conn.commit()
				}catch(Exception ex){
					@After-Throwing → conn.rollback()
				}finally {
					@After → conn.setAutoCommit(true)
				}
				
				return ""; @After-Returning
			}
 */
package com.sist.aop;

public class BoardAspect {
	
	public void before() // 문장 수행하기 전에 호출
	{
		System.out.println("오라클 연결");
	}
	
	public void after() // 문장 수행 종료
	{
		System.out.println("오라클 해제");
	}
}
