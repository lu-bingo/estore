package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.ShopAddress;

public interface IShopAddressService {

	public List<ShopAddress> findAddressByCustId(int custId);
	public ShopAddress findAddressById(int id);
}
