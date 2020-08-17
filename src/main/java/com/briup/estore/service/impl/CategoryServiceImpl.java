package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Category;
import com.briup.estore.dao.CategoryMapper;
import com.briup.estore.service.ICategoryService;
import com.briup.estore.util.MybatisSqlSessionFactoryUtil;

public class CategoryServiceImpl implements ICategoryService {

	@Override
	public List<Category> findFristWithSecondCategory() {
		//调用dao完成查找操作
				SqlSession sqlSession = MybatisSqlSessionFactoryUtil.openSession();
				CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
				List<Category> list = mapper.selectFristCategory();
				return list;
	}

}
