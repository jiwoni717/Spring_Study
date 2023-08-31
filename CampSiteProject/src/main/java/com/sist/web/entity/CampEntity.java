package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "camp2")
@Getter @Setter
public class CampEntity {
	
	@Id
	private int cno;
	private String name, address, phone, msg, image;
	private int hit;
}
