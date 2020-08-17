package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.ShopAddress;
import com.briup.estore.dao.ShopAddressMapper;
import com.briup.estore.service.IShopAddressService;
import com.briup.estore.util.MybatisSqlSessionFactoryUtil;

public class ShopAddressServiceImpl implements IShopAddressService {

	@Override
	public List<ShopAddress> findAddressByCustId(int custId) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		ShopAddressMapper mapper = session.getMapper(ShopAddressMapper.class);
		List<ShopAddress> addresslist = mapper.selectAddressByCustId(custId);
		
		return addresslist;
	}

	@Override
	public ShopAddress findAddressById(int id) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		ShopAddressMapper mapper = session.getMapper(ShopAddressMapper.class);
		ShopAddress address = mapper.selectAddressById(id);
		return address;
	}

}
