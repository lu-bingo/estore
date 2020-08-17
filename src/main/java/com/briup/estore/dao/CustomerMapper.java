package com.briup.estore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Customer;

/**
 * @author  
 */
public interface CustomerMapper {
	public void insertCustomer(Customer customer);
	public List<Customer> selectCustomerByName(String name);

}
