package com.xin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xin.domain.PatrolRecord;
import com.xin.service.PatrolService;
import com.xin.service.impl.PatrolServiceImpl;

public class PatrolServlet extends HttpServlet {

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
		} else if ("patrolUI".equals(method)) {
			patrolUI(req, resp);
		} else if ("add".equals(method)) {
			add(req, resp);
		} else if ("patrolToAdd".equals(method)) {
			patrolToAdd(req, resp);
		} else if ("patrolToQuery".equals(method)) {
			patrolToQuery(req, resp);
		} else if ("patrolToDelete".equals(method)) {
			patrolToDelete(req, resp);
		}
	}

	private void patrolToDelete(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		PatrolService patrolService = new PatrolServiceImpl();
		boolean isSuccess = patrolService.delete(Integer.parseInt(id));
		if(isSuccess){
			patrolToQuery(req, resp);
		}
	}

	private void patrolToQuery(HttpServletRequest req, HttpServletResponse resp) {
		PatrolService patrolService = new PatrolServiceImpl();
		List<PatrolRecord> patrolRecordList = patrolService.query();
		req.setAttribute("patrolRecordList", patrolRecordList);
		try {
			req.getRequestDispatcher("/WEB-INF/DefendJsp/patrolManage.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void patrolToAdd(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/DefendJsp/patrol.jsp").forward(
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
		
		String workId= req.getParameter("workId");
		String patrolAreaJ = req.getParameter("patrolArea");
		String  patrolPersonJ= req.getParameter("patrolPerson");
		String patrolResultJ= req.getParameter("patrolResult");
		
		String patrolArea=null;
		try {
			patrolArea = new String(patrolAreaJ.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		String patrolPerson=null;
		try {
			patrolPerson = new String(patrolPersonJ.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		String  patrolResult=null;
		try {
			 patrolResult = new String( patrolResultJ.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		PatrolRecord patrolRecord = new PatrolRecord();
		patrolRecord.setWorkId(workId);
		patrolRecord.setPatrolArea(patrolArea);
		patrolRecord.setPatrolPerson(patrolPerson);
		patrolRecord.setPatrolResult(patrolResult);
		
		System.out.println(patrolRecord.toString());
		

		PatrolService patrolService = new PatrolServiceImpl();
		boolean isSuccess = patrolService.add(patrolRecord);

		try {
			if (isSuccess) {
				req.getRequestDispatcher("/WEB-INF/DefendJsp/patrolManage.jsp").forward(req, resp);
				
			} else {
				req.getRequestDispatcher("/WEB-INF/DefendJsp/patrol.jsp").forward(req, resp);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void patrolUI(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/DefendJsp/patrolManage.jsp").forward(
					req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
