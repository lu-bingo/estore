package com.briup.estore.dao;

import com.briup.estore.bean.Customer;

public interface LoginMapper {
	public Customer selectCustomerNameAndPassword(Customer customer);
}
