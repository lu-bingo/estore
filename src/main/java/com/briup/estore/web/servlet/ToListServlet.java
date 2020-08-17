package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.service.impl.BookServiceImpl;

/**
 * Servlet implementation class ToListServlet
 */
public class ToListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取前端传递的二级栏目的id
		int cateId = Integer.parseInt(request.getParameter("id"));
		
		//2.servlet中根据栏目的id查询所有的书籍信息
		BookServiceImpl bookservice = new BookServiceImpl();
		List<Book> booklist = bookservice.findBookByCateId(cateId);
		System.out.println("---------"+booklist);
		
		//3.servlet中根据栏目的id查询点击量最高的三本书
		List<Book> topBooklist = bookservice.findBookByCateIdAndClick(cateId);
		System.out.println("++++++++++"+topBooklist);
		//4.
		request.setAttribute("booklist", booklist);
		request.setAttribute("topBooklist", topBooklist);
		
		//5.
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
