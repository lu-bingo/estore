package com.briup.estore.service;

import com.briup.estore.bean.Customer;

public interface ILoginService {

	public Customer findCustomerNameAndPassword(Customer customer);
}
