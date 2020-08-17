package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String zipCode = request.getParameter("zipCode");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		Customer customer = new Customer(name, password, zipCode, null, telephone, email);

		CustomerServiceImpl custservice = new CustomerServiceImpl();

		String url = "";
		try {
			custservice.register(customer);
			url = "/WEB-INF/jsp/login.jsp";
		} catch (Exception e) {
			e.getStackTrace();
			url = "/WEB-INF/jsp/register.jsp";
		}

		request.getRequestDispatcher(url).
		forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
