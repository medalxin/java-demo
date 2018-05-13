package com.xin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xin.domain.GuardRecord;
import com.xin.service.GuardService;
import com.xin.service.impl.GuardServiceImpl;

public class GuardServlet extends HttpServlet {

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
		} else if ("guardUI".equals(method)) {
			guardUI(req, resp);
		} else if ("add".equals(method)) {
			add(req, resp);
		} else if ("guardToAdd".equals(method)) {
			guardToAdd(req, resp);
		} else if ("guardToQuery".equals(method)) {
			guardToQuery(req, resp);
		} else if ("guardToDelete".equals(method)) {
			guardToDelete(req, resp);
		}
	}

	private void guardToDelete(HttpServletRequest req, HttpServletResponse resp) {
		String guardid = req.getParameter("guardid");
		GuardService guardService = new GuardServiceImpl();
		boolean isSuccess = guardService.delete(Integer.parseInt(guardid));
		if(isSuccess){
			guardToQuery(req, resp);
		}
	}

	private void guardToQuery(HttpServletRequest req, HttpServletResponse resp) {
		GuardService guardService = new GuardServiceImpl();
		List<GuardRecord> guardRecordList = guardService.query();
		req.setAttribute("guardRecordList", guardRecordList);
		try {
			req.getRequestDispatcher("/WEB-INF/DefendJsp/guardManage.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void guardToAdd(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/DefendJsp/guard.jsp").forward(
					req, resp);
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
		
		String workerid= req.getParameter("workerid");
		String guardconJ = req.getParameter("guardcon");
		String personnameJ = req.getParameter("personname");
		
		String guardcon=null;
		try {
			guardcon = new String(guardconJ.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String personname=null;
		try {
			personname = new String(personnameJ.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		GuardRecord guardRecord = new GuardRecord();
		
		guardRecord.setWorkerid(workerid);
		guardRecord.setGuardcon(guardcon);
		guardRecord.setPersonname(personname);

		GuardService guardService = new GuardServiceImpl();
		boolean isSuccess = guardService.add(guardRecord);

		try {
			if (isSuccess) {
				req.getRequestDispatcher("/WEB-INF/DefendJsp/guardManage.jsp").forward(req, resp);
				
			} else {
				req.getRequestDispatcher("/WEB-INF/DefendJsp/guard.jsp").forward(req, resp);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void guardUI(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/DefendJsp/guardManage.jsp").forward(
					req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
