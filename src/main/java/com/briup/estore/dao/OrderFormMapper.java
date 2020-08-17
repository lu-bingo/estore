package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.OrderForm;

public interface OrderFormMapper {

	public void insertOrder(OrderForm form);
	public List<OrderForm> selectOrderByCustId(int custId);
}
