package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.awt.desktop.FilesEvent;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.sist.dao.*;

@Controller
public class DataBoardController {
	@Autowired
	private DataBoardDAO dao;
	
	// 목록 출력
	@GetMapping("databoard/list.do")
	public String databoard_list(String page, Model model)
	{
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int rowSize = 10;
		int start = (rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<DataBoardVO> list = dao.databoardListData(map);
		int totalpage = dao.databardTotalPage();
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("main_jsp", "../databoard/list.jsp");
		return "main/main";
	}
	
	// 데이터 추가
	@GetMapping("databoard/insert.do")
	public String databoard_insert(Model model)
	{
		model.addAttribute("main_jsp", "../databoard/insert.jsp");
		return "main/main";
	}
	
	@PostMapping("databoard/insert_ok.do")
	public String databoard_insert_ok(DataBoardVO vo)
	{
		List<MultipartFile> list = vo.getFiles();
		if(list==null)
		{
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
		}
		else {
			
			String filenames="";
			String filesizes="";
			
			for(MultipartFile mf:list)
			{
				File file = new File("c:\\download\\"+mf.getOriginalFilename());
				try {
					mf.transferTo(file); // 파일 업로드
				}catch(Exception ex) {}
				
				filenames += file.getName()+",";
				long len = file.length();
				filesizes += len+",";
				
			}
			filenames = filenames.substring(0, filenames.lastIndexOf(","));
			filesizes = filesizes.substring(0, filesizes.lastIndexOf(","));
			vo.setFilename(filenames);
			vo.setFilesize(filesizes);
			
			vo.setFilecount(list.size());
		}
		
		dao.databoardInsert(vo);
		return "redirect:../databoard/list.do";
	}
	
/*
		Model 매개변수
		  1. 일반 데이터(int, String...)
		  2. 데이터를 모아서 처리 → ~VO
		  3. checkbox → String[]
		  
		화면 이동
		  1. forward : 화면 변경 → request
		  2. sendRedirect : 화면 변경 → request 초기화 → 기존에 설정된 위치로 변경(재사용)
		
		DAO : 데이터베이스 연동
		Controller : 조립기(DAO 연동 → 데이터 추출 → 브라우저 전송)
		VO : 데이터 모아서 관리
		Manager : Open API
		RestController : JavaScript로 JSON을 전송할 목적
						 다른언어와 연결 → 데이터를 전송
		Service : BI → DAO 여러개 통합, 다른 서비스 통합 → 의존성이 낮은 프로그램
 */
	@GetMapping("databoard/detail.do")
	public String databoard_detail(int no, Model model)
	{
		DataBoardVO vo = dao.boardDetailData(no);
		
		if(vo.getFilecount()>0)
		{
			String filenames = vo.getFilename();
			StringTokenizer st = new StringTokenizer(filenames, ",");
			List<String> nList = new ArrayList<String>();
			
			while(st.hasMoreTokens()) {
				nList.add(st.nextToken());
			}
			
			String filesizes = vo.getFilesize();
			st = new StringTokenizer(filesizes, ",");
			List<String> sList = new ArrayList<String>();
			
			while(st.hasMoreTokens()) {
				sList.add(st.nextToken());
			}
			
			model.addAttribute("nList", nList);
			model.addAttribute("sList", sList);
		}
		
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp", "../databoard/detail.jsp");
		return "main/main";
	}
	
	@GetMapping("databoard/download.do")
	public void databoard_download(String fn, HttpServletResponse response)
	{
		try {
			File file = new File("c:\\download\\"+fn);
			response.setHeader("Content-Disposition", "attachement;filename="+URLEncoder.encode(fn, "UTF-8"));
			
			// DOWNLOAD
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			// 서버에서 파일 읽기
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			// 사용자에게 전송
			int i = 0; // 읽은 바이트 수
			byte[] buffer = new byte[1024]; // TCP(1024), UDP(512)
			
			while((i=bis.read(buffer, 0, 1024))!=-1)
			{
				bos.write(buffer, 0, i);
			}
			bis.close();
			bos.close();
			
		}catch(Exception ex) {}
	}
	
	@PostMapping("databoard/search.do")
	public String databoard_search(String fs, String ss, Model model)
	{
		Map map = new HashMap();
		map.put("fs", fs);
		map.put("ss", ss);
		List<DataBoardVO> list = dao.boardSearchData(map);
		
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("main_jsp", "../databoard/find.jsp");
		return "main/main";
	}
	
	@GetMapping("databoard/update.do")
	public String databoard_update(int no, Model model)
	{
		 // DAO 연동
		DataBoardVO vo = dao.boardUpdateData(no);
		
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp", "../databoard/update.jsp");
		return "main/main";
	}
	
	@PostMapping("databoard/update_ok.do")
	@ResponseBody // 승격 → @RestController
	public String databoard_update_ok(DataBoardVO vo)
	{
		String result = "";
		
		boolean bCheck = dao.databoardUpdate(vo);
		
		if(bCheck==true)
		{
			result = "<script>"
					+ "location.href=\"../databoard/detail.do?no="+vo.getNo()+"\";"
					+ "</script>";
		}
		else {
			result = "<script>"
					+ "alert(\"비밀번호가 틀렸습니다.\");"
					+ "history.back();"
					+ "</script>";
		}
		
		return result;
	}
	
	// 삭제
	// 삭제하는 창으로 이동
	@GetMapping("databoard/delete.do")
	public String databoard_delete(int no, Model model)
	{
		model.addAttribute("no", no);
		model.addAttribute("main_jsp", "../databoard/delete.jsp");
		return "main/main";
	}
	
	// 실제 삭제
	@PostMapping("databoard/delete_ok.do")
	@ResponseBody
	public String databoard_delete_ok(int no, String pwd)
	{
		String result = "";
		
		boolean bCheck = dao.databoardDelete(no, pwd);
		
		if(bCheck==true)
		{
			result = "<script>"
					+ "location.href=\"../databoard/list.do\";"
					+ "</script>";
		}
		else {
			result = "<script>"
					+ "alert(\"비밀번호가 틀렸습니다.\");"
					+ "history.back();"
					+ "</script>";
		}
		
		return result;
	}
}
