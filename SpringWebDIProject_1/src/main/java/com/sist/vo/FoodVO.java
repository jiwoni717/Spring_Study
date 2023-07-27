package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodVO {
	private int fno, cno;
	private String name, address, phone, type, price, parking, time, menu;
	private double score;
}
