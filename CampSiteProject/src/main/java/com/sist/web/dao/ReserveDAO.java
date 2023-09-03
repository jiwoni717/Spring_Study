package com.sist.web.dao;

import com.sist.web.entity.*;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveDAO extends JpaRepository<ReserveEntity, Integer> {
	
	@Query(value = "SELECT * FROM reservation WHERE email=:email AND password=:password", nativeQuery = true)
	public List<ReserveEntity> reserveListData(@Param("email") String email, @Param("password") String password);
	
	public ReserveEntity findByRno(int rno);
	
}
