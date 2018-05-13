package com.xin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xin.domain.ComplaintRecord;
import com.xin.service.ComplaintService;
import com.xin.service.impl.ComplaintServiceImpl;

public class ComplaintServlet extends HttpServlet {

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
		} else if ("complaintUI".equals(method)) {
			complaintUI(req, resp);
		} else if ("add".equals(method)) {
			add(req, resp);
		} else if ("complaintToAdd".equals(method)) {
			complaintToAdd(req, resp);
		} else if ("complaintToQuery".equals(method)) {  
			complaintToQuery(req, resp);
		} else if ("complaintToDelete".equals(method)) {
			complaintToDelete(req, resp);
		}
	}

	private void complaintToDelete(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		ComplaintService complaintService = new ComplaintServiceImpl();
		boolean isSuccess = complaintService.delete(Integer.parseInt(id));
		if(isSuccess){
			complaintToQuery(req, resp);
		}
	}

	private void complaintToQuery(HttpServletRequest req, HttpServletResponse resp) {
		ComplaintService complaintService = new ComplaintServiceImpl();
		List<ComplaintRecord> complaintRecordList = complaintService.query();
		req.setAttribute("complaintRecordList", complaintRecordList);
		try {
			req.getRequestDispatcher("/WEB-INF/complaintjsp/complaintManage.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void complaintToAdd(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/complaintjsp/complaint.jsp").forward(
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
		
		
		String userNo = req.getParameter("userNo");
		String contentJ = req.getParameter("content");
		
		String content=null;
		try {
			content = new String(contentJ.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		ComplaintRecord complaintRecord = new ComplaintRecord();
		complaintRecord.setComplaintPerson(userNo);
		complaintRecord.setContent(content);

		ComplaintService complaintService = new ComplaintServiceImpl();
		boolean isSuccess = complaintService.add(complaintRecord);

		try {
			if (isSuccess) {
				req.getRequestDispatcher("/WEB-INF/complaintjsp/complaintManage.jsp").forward(req, resp);
				
			} else {
				req.getRequestDispatcher("/WEB-INF/complaintjsp/complaint.jsp").forward(req, resp);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void complaintUI(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/complaintjsp/complaintManage.jsp").forward(
					req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
