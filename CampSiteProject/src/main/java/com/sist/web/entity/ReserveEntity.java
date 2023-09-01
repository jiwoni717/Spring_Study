/*
	create table reservation (
	rno int primary key auto_increment,
    cno int not null,
    image varchar(260) not null,
    cname varchar(1000) not null,
    name varchar(51) not null,
    rdate varchar(500) not null,
    phone varchar(200) not null,
    email varchar(200) not null,
    password varchar(100) not null,
    msg text
);
 */

package com.sist.web.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@Getter @Setter
public class ReserveEntity {
	
	@Id
	private int rno;
	private int cno;
	private String image, cname, name, rdate, phone, email, password, msg;
	
}
