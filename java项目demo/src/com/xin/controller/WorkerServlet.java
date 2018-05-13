package com.xin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xin.domain.Worker;
import com.xin.service.WorkerService;
import com.xin.service.impl.WorkerServiceImpl;

public class WorkerServlet extends HttpServlet {

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
		} else if ("workerUI".equals(method)) {
			workerUI(req, resp);
		} else if ("add".equals(method)) {
			add(req, resp);
		} else if ("ToAdd".equals(method)) {
			ToAdd(req, resp);
		} else if ("ToQuery".equals(method)) {
			ToQuery(req, resp);
		}else if ("ToDelete".equals(method)) {
			ToDelete(req, resp);
		}
	}

	private void ToDelete(HttpServletRequest req, HttpServletResponse resp) {
		String worker_id = req.getParameter("worker_id");
		WorkerService workerService = new WorkerServiceImpl();
		boolean isSuccess = workerService.delete(worker_id);
		if(isSuccess){
			ToQuery(req, resp);
			
		}
	}

	private void ToQuery(HttpServletRequest req, HttpServletResponse resp) {
		WorkerService workerService=new WorkerServiceImpl();
		List<Worker> workerList = workerService.query();
        req.setAttribute("workerList", workerList);
		try {
			req.getRequestDispatcher("/WEB-INF/workerjsp/query.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}

	private void ToAdd(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/workerjsp/workeradd.jsp")
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

		String worker_id = req.getParameter("worker_id");
		String worker_nameJ = req.getParameter("worker_name");
		String worker_sexJ = req.getParameter("worker_sex");
		String worker_age = req.getParameter("worker_age");
		String worker_tel = req.getParameter("worker_tel");
		String office_tel = req.getParameter("office_tel");
		String worker_memoJ = req.getParameter("worker_memo");
		String id = req.getParameter("id");
		String positionJ = req.getParameter("position");
		String worker_passwordJ = req.getParameter("worker_password");

		String worker_name = null;
		try {
			worker_name = new String(worker_nameJ.getBytes("ISO-8859-1"),
					"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		String worker_password = null;
		try {
			worker_password = new String(
					worker_passwordJ.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		String position = null;
		try {
			position = new String(positionJ.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		String worker_memo = null;
		try {
			worker_memo = new String(worker_memoJ.getBytes("ISO-8859-1"),
					"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		String worker_sex = null;
		try {
			worker_sex = new String(worker_sexJ.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		Worker worker = new Worker();
		worker.setWorker_id(worker_id);
		worker.setWorker_name(worker_name);
		worker.setWorker_sex(worker_sex);
		worker.setWorker_age(worker_age);
		worker.setWorker_tel(worker_tel);
		worker.setOffice_tel(office_tel);
		worker.setWorker_memo(worker_memo);
		worker.setId(id);
		worker.setPosition(position);
		worker.setWorker_password(worker_password);

		WorkerService workerService = new WorkerServiceImpl();
		boolean isSuccess = workerService.add(worker);
		try {
			if (isSuccess) {
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/WEB-INF/workerjsp/workeradd.jsp")
						.forward(req, resp);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void workerUI(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/workerjsp/login.jsp").forward(
					req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
