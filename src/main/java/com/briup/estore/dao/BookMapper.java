package com.briup.estore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.briup.estore.bean.Book;

/**
 * @author matingting 书籍的映射接口
 */
public interface BookMapper {

	// 查找前3本书
	List<Book> findFrontThreeBook();

	// 查找所有书籍信息
	List<Book> findBookAll();

	// 查找书的总量
	int count();

	// 查找前3本书或者最后六本书
	// 一个参数的情况下用动态sql 要利用注解
	List<Book> findBooks(@Param(value = "count") Integer count);

	// 根据id查找书籍信息
	Book findBookById(Integer id);

	// 更新书籍信息
	public void updateBook(Book book);

	// 根据栏目id查询
	public List<Book> selectBookByCateId(int cateId);

	// 根据栏目id查询click最高三本书
	public List<Book> selectBookByCateIdAndClick(int cateId);

}
