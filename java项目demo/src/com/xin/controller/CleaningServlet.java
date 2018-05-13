package com.xin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xin.domain.CleaningRecord;
import com.xin.service.CleaningService;
import com.xin.service.impl.CleaningServiceImpl;



public class CleaningServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		if ("".equals(method) || method == null) {
			System.out.println("valid request!!!");
		} else if ("cleaningUI".equals(method)) {
			cleaningUI(req, resp);
		} else if ("guardUI".equals(method)) {
			guardUI(req, resp);
		} else if ("add".equals(method)) {
			add(req, resp);
		} else if ("cleaningToAdd".equals(method)) {
			cleaningToAdd(req, resp);
		} else if ("cleaningToQuery".equals(method)) {
			cleaningToQuery(req, resp);
		} else if ("cleaningToDelete".equals(method)) {
			cleaningToDelete(req, resp);
		}
	}

	private void guardUI(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/DefendJsp/guardManage.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void cleaningUI(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/DefendJsp/cleaningManage.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void cleaningToDelete(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		CleaningService cleaningService = new CleaningServiceImpl();
		boolean isSuccess = cleaningService.delete(Integer.parseInt(id));
		if(isSuccess){
			cleaningToQuery(req, resp);
		}
	}

	private void cleaningToQuery(HttpServletRequest req, HttpServletResponse resp) {
		CleaningService cleaningService = new CleaningServiceImpl();
		List<CleaningRecord> cleaningRecordList = cleaningService.query();
		req.setAttribute("cleaningRecordList", cleaningRecordList);
		try {
			req.getRequestDispatcher("/WEB-INF/DefendJsp/cleaningManage.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void cleaningToAdd(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/DefendJsp/cleaning.jsp").forward(req, resp);
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
		
		String cleaningSiteJ = req.getParameter("CleaningSite");
		String cleaningTimeJ = req.getParameter("CleaningTime");
		String cleaningJ = req.getParameter("Cleaning");
		String cleaningTel = req.getParameter("CleaningTel");
		String cleaningRemarksJ = req.getParameter("CleaningRemarks");
		
		String cleaningSite=null;
		try {
			cleaningSite = new String(cleaningSiteJ.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String cleaningTime=null;
		try {
			cleaningTime = new String(cleaningTimeJ.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String cleaning=null;
		try {
			cleaning = new String(cleaningJ.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String cleaningRemarks=null;
		try {
			cleaningRemarks = new String(cleaningRemarksJ.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		CleaningRecord cleaningRecord = new CleaningRecord();
		cleaningRecord.setCleaningSite(cleaningSite);
		cleaningRecord.setCleaningTime(cleaningTime);
		cleaningRecord.setCleaning(cleaning);
		cleaningRecord.setCleaningTel(cleaningTel);
		cleaningRecord.setCleaningRemarks(cleaningRemarks);
		
		CleaningService cleaningService = new CleaningServiceImpl();
		boolean isSuccess = cleaningService.add(cleaningRecord);
		
		try {
			if (isSuccess) {
				req.getRequestDispatcher("/WEB-INF/DefendJsp/cleaningManage.jsp").forward(req, resp);
				
			} else {
				req.getRequestDispatcher("/WEB-INF/DefendJsp/cleaning.jsp").forward(req, resp);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
