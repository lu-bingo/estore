package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.dao.OrderFormMapper;
import com.briup.estore.service.IOrderFormService;
import com.briup.estore.util.MybatisSqlSessionFactoryUtil;

public class OrderFormServiceImpl implements IOrderFormService {

	@Override
	public void insertOrder(OrderForm orderForm) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		OrderFormMapper mapper = session.getMapper(OrderFormMapper.class);
		mapper.insertOrder(orderForm);
		session.commit();
		
		
	}

	@Override
	public List<OrderForm> findOrderByCustId(int custId) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		OrderFormMapper mapper = session.getMapper(OrderFormMapper.class);
		List<OrderForm> orderlist = mapper.selectOrderByCustId(custId);
		return orderlist;
	}

}
