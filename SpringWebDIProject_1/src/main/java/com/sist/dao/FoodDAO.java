/*
		client
		   |
	 DispatcherServlet : 사용자의 모든 요청을 받는다(Front Controller)
	 	   |			 이미 스프링에서 라이브러리 제작 → 등록(web.xml)
	 해당 모델(Controller)				 	┌───────────────────────────────────────────────────────────────┐
	 └>개발자가 직접 제작						│  HandlerAdapter : 모델 찾는 역할 									│
		   | request에 요청 처리값을 담는다	│  HandlerMapping : 찾은 모델에서 @RequestMapping() 찾음				│
		   | JSP 파일명 전송				│   └> DispatcherServlet 설정과 동시에 설정(자바로 환경 설정시에는 직접 설정)	│
	DispatcherServlet					└───────────────────────────────────────────────────────────────┘
		   | JSP찾기
		   | request 전송
		View(JSP)
		   | request에 담긴 데이터 출력
		Client
 */
package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<CategoryVO> foodCategoryListData()
	{
		return mapper.foodCategoryListData();
	}
	
	public List<FoodVO> foodListData(int cno)
	{
		return mapper.foodListData(cno);
	}
}
