/*
										인터셉트(preHandle)					 인터셉트(postHandle)				   인터셉트(afterCompletion)
		요청(.do) => DispatcherServlet =====================> HandelrMapping =====================> ViewResolver =====================> JSP
									   		      @Controller / @RestController 찾아줌		  	  return 값을 받아
									   				=> @GetMapping, @PostMapping			  		 화면 변경
		
		Spring
		  = setting : AOP / DI => 클래스 등록
		  = ORM
		  	1) XML
		  	2) Annotation
		  	3) XML+Annotation
		  = Transaction
		  -----------------------------------
		  = WebSocket
		  = Security
		  = Task
		  -----------------------------------
		  = MVC
 */
package com.sist.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutoInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
}
