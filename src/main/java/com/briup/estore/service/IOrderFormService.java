package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.OrderForm;

public interface IOrderFormService {
	public void insertOrder(OrderForm orderForm);
	public List<OrderForm> findOrderByCustId(int idS);
	
}
