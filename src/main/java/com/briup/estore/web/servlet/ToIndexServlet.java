package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.service.impl.BookServiceImpl;
import com.briup.estore.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class ToIndexServlet
 */
public class ToIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryServiceImpl categoryService = new CategoryServiceImpl();
		List<Category> categorielist = categoryService.findFristWithSecondCategory();
		request.setAttribute("categorielist", categorielist);
	
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		List<Book> books = bookServiceImpl.findBookByClick();
		request.setAttribute("books", books);
		
		List<Book> findBooks = bookServiceImpl.findBooks();
		request.setAttribute("findBooks", findBooks);
		
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
