package com.xin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.xin.domain.NotifyRecord;
import com.xin.service.NotifyService;
import com.xin.service.impl.NotifyServiceImpl;

public class NotifyServlet extends HttpServlet {

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
			System.out.print("valid request!!!");
		} else if ("notifyUI".equals(method)) { // 菜单
			notifyUI(req, resp);
		} else if ("add".equals(method)) { // 增加
			add(req, resp);
		} else if ("notifyToAdd".equals(method)) {
			notifyToAdd(req, resp);
		}else if ("notifyToQuery".equals(method)) {
			notifyToQuery(req, resp);
		}else if ("notifyToDelete".equals(method)) {
			notifyToDelete(req, resp);
		
		}
	}

	private void notifyToDelete(HttpServletRequest req, HttpServletResponse resp) {
     String notify_id = req.getParameter("notify_id");
     NotifyService notifyService = new NotifyServiceImpl();
	 boolean isSuccess =  notifyService.delete(notify_id);
	 if(isSuccess){
		 notifyToQuery(req,resp);
		 
	 }
		
	}

	private void notifyToQuery(HttpServletRequest req, HttpServletResponse resp) {
		NotifyService notifyService = new NotifyServiceImpl();
		List<NotifyRecord> notifyRecordList = notifyService.query();
		req.setAttribute("notifyRecordList", notifyRecordList);
		try {
			req.getRequestDispatcher("/WEB-INF/Notifymanage/notifymanage.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void notifyToAdd(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/Notifymanage/notifyadd.jsp").forward(
					req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) {
     
		try {
			req.setCharacterEncoding("UTF-8");          //人为设置UTF-8格式
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");            //告诉浏览器以什么格式打开
		resp.setContentType("UTF-8"); 
		
		String notify_id = req.getParameter("notify_id");
		String worker_id = req.getParameter("worker_id");
		String notify_conj = req.getParameter("notify_con");
		String notify_date = req.getParameter("notify_date");
		String notify_titlej = req.getParameter("notify_title");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date notify_date1 = null;
		try {
			notify_date1 = sdf.parse(notify_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String notify_con=null;
		try {
			notify_con = new String(notify_conj.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		String notify_title=null;
		try {
			notify_title = new String(notify_titlej.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		
		NotifyRecord notifyRecord = new NotifyRecord();
		notifyRecord.setNotify_id(notify_id);
		notifyRecord.setWorker_id(worker_id);
		notifyRecord.setNotify_con(notify_con);
		notifyRecord.setNotify_date(notify_date1);
		notifyRecord.setNotify_title(notify_title);
				
		NotifyService notifyService = new NotifyServiceImpl();
		
		boolean isSuccess = notifyService.add(notifyRecord);
		try {
			if (isSuccess) {
				req.getRequestDispatcher("/WEB-INF/Notifymanage/notifymanage.jsp")
						.forward(req, resp);

			} else {
				req.getRequestDispatcher("/WEB-INF/Notifymanage/notifyadd.jsp")
						.forward(req, resp);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

	private void notifyUI(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/Notifymanage/notifymanage.jsp")
					.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

}
