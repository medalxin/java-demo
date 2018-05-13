package com.xin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xin.domain.ParkingpotRecord;
import com.xin.service.ParkingpotService;
import com.xin.service.impl.ParkingpotServiceImpl;

public class ParkingpotServlet extends HttpServlet {

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
		} else if ("parkingpotUI".equals(method)) {
			parkingpotUI(req, resp);
		} else if ("add".equals(method)) {
			add(req, resp);
		} else if ("parkingpotToAdd".equals(method)) {
			parkingpotToAdd(req, resp);
		} else if ("parkingpotToQuery".equals(method)) {
			parkingpotToQuery(req, resp);
		} else if ("parkingpotToDelete".equals(method)) {
			parkingpotToDelete(req, resp);
		}
	}

	private void parkingpotToDelete(HttpServletRequest req, HttpServletResponse resp) {
		String parkingpotid = req.getParameter("parkingpotid");
		ParkingpotService parkingpotService = new ParkingpotServiceImpl();
		boolean isSuccess = parkingpotService.delete(Integer.parseInt(parkingpotid));
		if(isSuccess){
			parkingpotToQuery(req, resp);
		}
	}

	private void parkingpotToQuery(HttpServletRequest req, HttpServletResponse resp) {
		ParkingpotService parkingpotService = new ParkingpotServiceImpl();
		List<ParkingpotRecord> parkingpotRecordList = parkingpotService.query();
		req.setAttribute("parkingpotRecordList", parkingpotRecordList);
		try {
			req.getRequestDispatcher("/WEB-INF/parkingpotjsp/parkingpotManage.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void parkingpotToAdd(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/parkingpotjsp/parkingpot.jsp").forward(
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
		
		String customerid = req.getParameter("customerid");
		
		String parkingpotpositionJ= req.getParameter("parkingpotposition");
		
		String parkingpotposition=null;
		try {
			parkingpotposition = new String(parkingpotpositionJ.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		
		ParkingpotRecord parkingpotRecord = new ParkingpotRecord();
		parkingpotRecord.setCustomerid(customerid);
		parkingpotRecord.setParkingpotposition(parkingpotposition);

		ParkingpotService parkingpotService = new ParkingpotServiceImpl();
		boolean isSuccess = parkingpotService.add(parkingpotRecord);

		try {
			if (isSuccess) {
				req.getRequestDispatcher("/WEB-INF/parkingpotjsp/parkingpotManage.jsp").forward(req, resp);
				
			} else {
				req.getRequestDispatcher("/WEB-INF/parkingpotjsp/parkingpot.jsp").forward(req, resp);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void parkingpotUI(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/parkingpotjsp/parkingpotManage.jsp").forward(
					req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
