package com.briup.estore.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.LoginMapper;
import com.briup.estore.service.ILoginService;
import com.briup.estore.util.MybatisSqlSessionFactoryUtil;

public class LoginServiceImpl implements ILoginService {

	@Override
	public Customer findCustomerNameAndPassword(Customer customer) {
		SqlSession sqlSession = MybatisSqlSessionFactoryUtil.openSession();
		LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);
		Customer nameAndPassword = mapper.selectCustomerNameAndPassword(customer);
		return nameAndPassword;
	}

}
