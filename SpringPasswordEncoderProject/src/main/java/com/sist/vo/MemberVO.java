package com.sist.vo;

import java.util.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {

	private String id, pwd, name, sex, msg;
	private Date regdate;
}
