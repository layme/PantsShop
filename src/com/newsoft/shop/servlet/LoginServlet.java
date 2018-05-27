package com.newsoft.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.newsoft.shop.constant.SysProperties;
import com.newsoft.shop.entity.ResultInfo;
import com.newsoft.shop.entity.User;
import com.newsoft.shop.service.SysService;
import com.newsoft.shop.util.SysUtil;


@WebServlet(name="loginServlet", urlPatterns={"/loginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SysService sysService;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String address = request.getParameter("address");

		User user = new User();
		user.setId(SysUtil.getUUID(SysProperties.USER_PREFIX));
		user.setName(name);
		user.setSex(sex);
		user.setPhone(phone);
		user.setPassword(password);
		user.setAddress(address);
		this.sysService = new SysService();
		ResultInfo<User> ri = this.sysService.registory(user);
		System.out.println(JSON.toJSONString(ri));
		
		response.setContentType("text/html;charset=utf-8");  
		PrintWriter out = response.getWriter();  
		out.println(JSON.toJSONString(ri));  
		out.flush();  
		out.close();  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public static void main(String[] args) {
		User user = new User();
		user.setId(SysUtil.getUUID(SysProperties.USER_PREFIX));
		user.setName("Tom");
		user.setSex("1");
		user.setPhone("13212123232");
		user.setPassword("123456");
		user.setAddress("beijing");
		ResultInfo<User> ri = new SysService().registory(user);
		System.out.println(JSON.toJSONString(ri));
	}
}
