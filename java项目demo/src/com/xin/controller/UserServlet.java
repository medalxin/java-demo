package com.xin.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xin.domain.User;
import com.xin.service.UserService;
import com.xin.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		if("".equals(method)||method==null){
			System.out.println("valid request");
		}else if("login".equals(method)){
			login(req,resp);
		}else if("register".equals(method)){
			register(req,resp);
		}else if("modify".equals(method)){
			modify(req,resp);
		}else if("logout".equals(method)){
			logout(req,resp);
		}
	}
	
	private void logout(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession(false);
		if(session!=null){
			session.removeAttribute("user");
		}
		//注销成功，跳到全局消息显示页面，显示注销成功消息，并控制消息显示几秒后跳转到首页
		req.setAttribute("message", "注销成功，浏览器将在3秒后跳转，如果没有跳转，请点击<a href='"+req.getContextPath()+"/index.jsp'>这里</a>......！！！<meta http-equiv='refresh' content='3; url="+req.getContextPath()+"/index.jsp'>");
		try {
			req.getRequestDispatcher("/message.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	private void modify(HttpServletRequest req, HttpServletResponse resp) {

		String userid = req.getParameter("id");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String birthday = req.getParameter("birthday");
		String status = req.getParameter("status");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date birthday1 = null;
		try {
			birthday1 = sdf.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		User user = new User();
		user.setId(Integer.parseInt(userid));
		user.setUsername(username);
		user.setPassword(password);
		user.setBirthday(birthday1);
		
		UserService userService = new UserServiceImpl();
		boolean isSuccess = userService.modifyUserInf(user);
		if(isSuccess){
			req.getSession().setAttribute("user", user);
			try {
				resp.sendRedirect(req.getContextPath()+"/index.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}

	private void register(HttpServletRequest req, HttpServletResponse resp) {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String passwordCon = req.getParameter("passwordCon");
		String status = req.getParameter("status");
		String birthday = req.getParameter("birthday");

		
		if(!password.equals(passwordCon)){
			return;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date birthday1 = null;
		try {
			birthday1 = sdf.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setBirthday(birthday1);
		user.setStatus(status);
		
		UserService userService = new UserServiceImpl();
		boolean isSuccess = userService.register(user);
		
		if(isSuccess){
			try {
				resp.sendRedirect(req.getContextPath() + "/index.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void login(HttpServletRequest req, HttpServletResponse resp){

		//获取前台输入的数据
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String status = req.getParameter("status");
		
		UserService userService = new UserServiceImpl();
		User user = userService.login(username, password,status);
		
		if(user!=null){
			req.getSession().setAttribute("user", user);
			//req.setAttribute("Hello", "RequestTest");
			//用户登录成功后，返回欢迎界面
			//resp.sendRedirect("/HelloWorld/welcome.jsp");
			try {
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
	}

}
