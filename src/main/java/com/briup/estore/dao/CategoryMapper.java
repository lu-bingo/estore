package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Category;

/**
 * @author matingting
 * 分类的映射接口
 */
public interface CategoryMapper {
	
	//查找一级分类以及一级分类所对应的所有二级分类
	List<Category>  selectFristCategory();
	
	

}
