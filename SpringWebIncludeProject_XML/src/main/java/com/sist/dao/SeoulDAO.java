package com.sist.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.SeoulMapper;
import com.sist.vo.SeoulVO;

@Repository
public class SeoulDAO {

	@Autowired
	private SeoulMapper mapper;
	
	/*
	 * 	@Select("SELECT no,title,poster,num "
			+ "FROM (SELECT no,title,poster,rownum as num "
			+ "FROM (SELECT no,title,poster "
			+ "FROM seoul_location "
			+ "ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")*/
		public List<SeoulVO> seoulLocationListData(Map map) {
			return mapper.seoulLocationListData(map);
		}
		
	
	/*	@Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_location") */
		public int seoulLocationTotalPage() {
			return mapper.seoulLocationTotalPage();
		}
		
		public List<SeoulVO> seoulNatureListData(Map map)
		{
			return mapper.seoulNatureListData(map);
		}
		
		public int seoulNatureTotalPage()
		{
			return mapper.seoulNatureTotalPage();
		}
		
		public List<SeoulVO> seoulShopListData(Map map)
		{
			return mapper.seoulShopListData(map);
		}
		
		public int seoulShopTotalPage()
		{
			return mapper.seoulShopTotalPage();
		}

}
