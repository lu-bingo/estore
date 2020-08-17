package com.briup.estore.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.OrderLine;
import com.briup.estore.dao.OrderLineMapper;
import com.briup.estore.service.IOrderLineService;
import com.briup.estore.util.MybatisSqlSessionFactoryUtil;

public class OrderLineServiceImpl implements IOrderLineService {

	@Override
	public void insertLine(OrderLine line) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		OrderLineMapper mapper = session.getMapper(OrderLineMapper.class);
		mapper.insertLine(line);
		session.commit();
		
	}

}
