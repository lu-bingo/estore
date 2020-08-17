package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.CustomerMapper;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.util.MybatisSqlSessionFactoryUtil;

public class CustomerServiceImpl implements ICustomerService {

	//用户名不能重复
	@Override
	public void register(Customer customer) throws Exception {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
		List<Customer> customerlist = customerMapper.selectCustomerByName(customer.getName());
		System.out.println("size--------"+customerlist.size());
		if(customerlist.size()>0) {
			throw new Exception("该用户名已经被占用，请重新输入");
		}else {
			customerMapper.insertCustomer(customer);
			session.commit();
			System.out.println("插入成功");
		}
	}

	@Override
	public Customer login(String name, String password) throws Exception {
		//根据用户名查询数据库
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		List<Customer> custlist = mapper.selectCustomerByName(name);
		if(custlist.size()>0) {
			Customer customer = custlist.get(0);
			//判断密码是否正确
			if(customer.getPassword().equals(password)) {
				return customer;
			}else {
				throw new Exception("该用户名密码错误，请重新输入");
			}
		}else {
			throw new Exception("该用户名不存在，请重新输入");
		}
	}

}
