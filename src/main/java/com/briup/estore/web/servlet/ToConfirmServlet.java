package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.service.IShopAddressService;
import com.briup.estore.service.impl.ShopAddressServiceImpl;

/**
 * Servlet implementation class ToConfirmServlet
 */
public class ToConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从session中获取customer
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("customer");
		
		//根据用户的id查询地址信息
		IShopAddressService  addressService= new ShopAddressServiceImpl();
		List<ShopAddress> addresslist = addressService.findAddressByCustId(customer.getId());
		
		
		//跳转的comfrim.jsp
		request.setAttribute("addresslist",addresslist);
		
		request.getRequestDispatcher("/WEB-INF/user/confirm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
