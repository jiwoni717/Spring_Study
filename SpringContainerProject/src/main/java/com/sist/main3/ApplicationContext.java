/*
		Spring → 클래스 관리(Container)
		  1. 객체의 생명 주기 관리
		  2. 객체 찾기(getBean())
		  3. DL / DI
		    D Lookup : 객체 찾기
		    D Injection : 주입
		      ┌setter DI
		      ├constructor
		      └method
 */
package com.sist.main3;

import java.util.*;
import org.apache.commons.collections.map.HashedMap;

public class ApplicationContext {
	private Map map = new HashedMap();
	public ApplicationContext() {
		map.put("a", new A());
		map.put("b", new B());
		map.put("c", new C());
		map.put("d", new D());
	}
	
	public Object getBean(String key)
	{
		return map.get(key);
	}
}
