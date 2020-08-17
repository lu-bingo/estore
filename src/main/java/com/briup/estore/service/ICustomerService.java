package com.briup.estore.service;

import com.briup.estore.bean.Customer;

public interface ICustomerService {
	public void register(Customer customer) throws Exception;
	public Customer login(String name,String password) throws Exception;
}
