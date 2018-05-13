package com.xin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xin.domain.RepairRecord;
import com.xin.service.RepairService;
import com.xin.service.impl.RepairServiceImpl;

public class RepairServlet extends HttpServlet {

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
		} else if ("repairUI".equals(method)) {
			repairUI(req, resp);
		} else if ("add".equals(method)) {
			add(req, resp);
		} else if ("repairToAdd".equals(method)) {
			repairToAdd(req, resp);
		} else if ("repairToQuery".equals(method)) {
			repairToQuery(req, resp);
		} else if ("repairToDelete".equals(method)) {
			repairToDelete(req, resp);
		}
	}

	private void repairToDelete(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		RepairService repairService = new RepairServiceImpl();
		boolean isSuccess = repairService.delete(Integer.parseInt(id));
		if(isSuccess){
			repairToQuery(req, resp);
		}
	}

	private void repairToQuery(HttpServletRequest req, HttpServletResponse resp) {
		RepairService repairService = new RepairServiceImpl();
		List<RepairRecord> repairRecordList = repairService.query();
		req.setAttribute("repairRecordList", repairRecordList);
		try {
			req.getRequestDispatcher("/WEB-INF/repairjsp/repairManage.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void repairToAdd(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/repairjsp/repair.jsp").forward(
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
		
		String hallNo = req.getParameter("hallNo");
		String houseNo = req.getParameter("houseNo");
		String contentJ = req.getParameter("content");
		
		String content=null;
		try {
			content = new String(contentJ.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		RepairRecord repairRecord = new RepairRecord();
		repairRecord.setHouse(hallNo + "Â¥" + houseNo + "·¿¼äºÅ");
		repairRecord.setContent(content);

		RepairService repairService = new RepairServiceImpl();
		boolean isSuccess = repairService.add(repairRecord);

		try {
			if (isSuccess) {
				req.getRequestDispatcher("/WEB-INF/repairjsp/repairManage.jsp").forward(req, resp);
				
			} else {
				req.getRequestDispatcher("/WEB-INF/repairjsp/repair.jsp").forward(req, resp);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void repairUI(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/repairjsp/repairManage.jsp").forward(
					req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
