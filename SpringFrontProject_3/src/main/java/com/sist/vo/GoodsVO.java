/*
		VueJS
		- watch
		- computed
		- component
		- filter
		
		회원가입 → 유효성 검사
 */
package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsVO {
	private int no, discount, hit, account;
	private String name, sub, price, first_price, delivery, poster;
}
