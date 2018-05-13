package com.xin.webUI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefendUIServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		if("".equals(method)||method==null){
			System.out.println("valid request");
		}else if("defendUI".equals(method)){
			defendUI(req,resp);
		}
	}

	private void defendUI(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/DefendJsp/defend.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
