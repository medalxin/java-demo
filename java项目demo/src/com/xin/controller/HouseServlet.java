package com.xin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xin.domain.HouseRecord;
import com.xin.service.HouseService;
import com.xin.service.impl.HouseServiceImpl;

public class HouseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method=req.getParameter("method");
		if("".equals(method)||method==null){
			System.out.println("valid request!!");
		}else if("houseUI".equals(method)){
			houseUI(req,resp);
		}else if("add".equals(method)){
			add(req,resp);
		}else if("houseToAdd".equals(method)){
			houseToAdd(req,resp);
		}else if("houseToQuery".equals(method)){
			houseToQuery(req,resp);
		}else if("houseToDelete".equals(method)){
			houseToDelete(req,resp);
		}
	}

	
	private void houseToDelete(HttpServletRequest req, HttpServletResponse resp) {
		String homeid=req.getParameter("homeid");
		HouseService houseService=new HouseServiceImpl();
		boolean isSuccess=houseService.delete(Integer.parseInt(homeid));
		if(isSuccess){
			houseToQuery(req, resp);
			
		}
		
	}

	private void houseToQuery(HttpServletRequest req, HttpServletResponse resp) {
		HouseService houseService=new HouseServiceImpl();
		List<HouseRecord> houseRecordList=houseService.query();
		req.setAttribute("houseRecordList", houseRecordList);
		try {
			req.getRequestDispatcher("/WEB-INF/jsp/houseManage.jsp").forward(req, resp);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	private void houseToAdd(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/jsp/house.jsp").forward(req,resp);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			
			e1.printStackTrace();
		}
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("utf-8");
		String customerid=req.getParameter("customerid");
		String homezoneJ=req.getParameter("homezone");
		String homebuilding=req.getParameter("homebuilding");
		String homeunit=req.getParameter("homeunit");
		String hallNo=req.getParameter("hallNo");
		String houseNo=req.getParameter("houseNo");
		
		
		String homeareaJ=req.getParameter("homearea");
		String hometypeJ=req.getParameter("hometype");
		String homememeoJ=req.getParameter("homememeo");
		String homezone=null;
		try {
			homezone=new String(homezoneJ.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
		
			e1.printStackTrace();
		}
		String homearea=null;
		try {
			homearea=new String(homeareaJ.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
		
			e1.printStackTrace();
		}
		String homememeo=null;
		try {
			homememeo=new String(homememeoJ.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
		
			e1.printStackTrace();
		}
		String hometype=null;
		try {
			hometype=new String(hometypeJ.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
		
			e1.printStackTrace();
		}
		
		HouseRecord houseRecord=new HouseRecord();
		houseRecord.setCustomerid(customerid);
		houseRecord.setHomezone(homezone);
		houseRecord.setHomebuilding(homebuilding);
		houseRecord.setHomeunit(homeunit);
		houseRecord.setHomenumber(hallNo+"Â¥"+houseNo+"·¿¼äºÅ");
	
		houseRecord.setHomearea(homearea);
		houseRecord.setHometype(hometype);
		houseRecord.setHomememeo(homememeo);
		HouseService houseService=new HouseServiceImpl();
		boolean isSuccess=houseService.add(houseRecord);
		
		try {
			if(isSuccess){
				req.getRequestDispatcher("/WEB-INF/jsp/houseManage.jsp").forward(req, resp);
				
			}else{
				req.getRequestDispatcher("/WEB-INF/jsp/house.jsp").forward(req, resp);
				
			}
		
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
private void houseUI(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			req.getRequestDispatcher("/WEB-INF/jsp/houseManage.jsp").forward(req,resp);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
}	
}
