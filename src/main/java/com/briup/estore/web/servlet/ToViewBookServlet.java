package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.impl.BookServiceImpl;

public class ToViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.接收来自前台的参数
		String id = request.getParameter("id");
		
		//2.调用service进行逻辑处理
		IBookService serviceImpl = new BookServiceImpl();
		
		Book book = serviceImpl.findBookById(Integer.parseInt(id));
		request.setAttribute("book",book);
		//3.给前台响应
		//服务器内部跳转
		request.getRequestDispatcher("/WEB-INF/jsp/viewBook.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
