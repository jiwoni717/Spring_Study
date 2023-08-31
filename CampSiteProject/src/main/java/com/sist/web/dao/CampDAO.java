package com.sist.web.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sist.web.entity.*;

@Repository

public interface CampDAO extends JpaRepository<CampEntity, Integer>{
	
	@Query(value = "SELECT * FROM camp2 ORDER BY hit DESC LIMIT 0, 8", nativeQuery = true)
	public List<CampEntity> mainCampList();
	
	@Query(value = "SELECT * FROM camp2 ORDER BY cno ASC LIMIT :start, 6", nativeQuery = true)
	public List<CampEntity> campList(@Param("start") Integer start);
	
	@Query(value = "SELECT CEIL(COUNT(*)/6.0) FROM camp2", nativeQuery = true)
	public int campTotalPage(@Param("start") Integer start);
}
