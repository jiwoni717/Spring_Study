package com.sist.service;

import java.util.*;
import com.sist.vo.*;

public interface GoodsService {
	public List<GoodsVO> goodsListData(Map map);
	
	public GoodsVO goodsDetailData(int no);
	
	public int goodsTotalPage();
}
