package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名和密码
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//验证用户名和密码
		 ICustomerService customerService = new CustomerServiceImpl();
		 String url="";
		 try {
			 Customer customer = 
					 customerService.login(name, password);
				ShopCar car = new ShopCar();
				HttpSession session = request.getSession();
				session.setAttribute("car", car);
				session.setAttribute("customer", customer);
				url = "/toIndexServlet";
		} catch (Exception e) {
			e.printStackTrace();
			url="/WEB-INF/jsp/login.jsp";
		}
		 //跳转页面
		 request.getRequestDispatcher(url).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
