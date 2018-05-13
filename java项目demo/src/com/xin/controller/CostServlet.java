package com.xin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xin.domain.CostRecord;
import com.xin.service.CostService;
import com.xin.service.impl.CostServiceImpl;

public class CostServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		if ("".equals(method) || method == null) {
			System.out.println("valid request!!!!");
		} else if ("costUI".equals(method)) {
			costUI(req,resp);
		} else if ("add".equals(method)) {
			add(req,resp);
		}else if ("costToAdd".equals(method)) {
			costToAdd(req,resp);
		}else if ("costToQuery".equals(method)) {
			costToQuery(req, resp);
		}else if ("costToDelete".equals(method)) {
			costToDelete(req,resp);
		}
	}

	private void costToDelete(HttpServletRequest req, HttpServletResponse resp) {
		String costid = req.getParameter("costid");
		CostService costService = new CostServiceImpl();
		boolean isSuccess = costService.delete(Integer.parseInt(costid));
		if(isSuccess){
			costToQuery(req, resp);
		}
		
	}

	private void costToQuery(HttpServletRequest req, HttpServletResponse resp) {
		CostService CostService = new CostServiceImpl();
		List<CostRecord> costRecordList = CostService.query();
		req.setAttribute("costRecordList", costRecordList);
		try {
			req.getRequestDispatcher("/WEB-INF/jsp/costManage.jsp").forward(req, resp);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	private void costToAdd(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			req.getRequestDispatcher("/WEB-INF/jsp/cost.jsp")
					.forward(req, resp);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			
			e1.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("UTF-8");
		
		String customerid = req.getParameter("customerid");
		String cost = req.getParameter("cost");
		String money = req.getParameter("money");
		String costmemoJ = req.getParameter("costmemo");
		
		String costmemo=null;
		try {
			 costmemo = new String(costmemoJ.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			
			e1.printStackTrace();
		}
		
		CostRecord costRecord = new CostRecord();
		costRecord.setCustomerid(customerid);
		costRecord.setCost(cost);
		costRecord.setMoney(money);
		costRecord.setCostmemo(costmemo);
		
		CostService costService = new CostServiceImpl();
		boolean isSuccess = costService.add(costRecord);
		if(isSuccess){
    	try {
			req.getRequestDispatcher("/WEB-INF/jsp/costManage.jsp").forward(req,resp);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}else{
		try {
			req.getRequestDispatcher("/WEB-INF/jsp/cost.jsp").forward(req,resp);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}



	private void costUI(HttpServletRequest req, HttpServletResponse resp) {

		try {
			req.getRequestDispatcher("/WEB-INF/jsp/costManage.jsp")
					.forward(req, resp);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
