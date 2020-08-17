package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;
import com.briup.estore.dao.BookMapper;
import com.briup.estore.service.IBookService;
import com.briup.estore.util.MybatisSqlSessionFactoryUtil;

public class BookServiceImpl implements IBookService {

	public List<Book> findBookByClick() {
		SqlSession sqlSession = MybatisSqlSessionFactoryUtil.openSession();
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		List<Book> findFrontThreeBook = mapper.findFrontThreeBook();
		
		return findFrontThreeBook;
	}

	@Override
	public List<Book> findBooks() {
		SqlSession sqlSession = MybatisSqlSessionFactoryUtil.openSession();
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		List<Book> findBookAll = mapper.findBookAll();
		return findBookAll;
	}

	@Override
	public Book findBookById(Integer id) {
		SqlSession sqlSession = MybatisSqlSessionFactoryUtil.openSession();
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		Book book = mapper.findBookById(id);
		
		//将该书籍的click加一
		book.setClick(book.getClick()+1);
		mapper.updateBook(book);
		sqlSession.commit();
		return book;
	}

	@Override
	public List<Book> findBookByCateId(int cateId) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> booklist = mapper.selectBookByCateId(cateId);
		return booklist;
	}

	@Override
	public List<Book> findBookByCateIdAndClick(int cateId) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> booklist = mapper.selectBookByCateIdAndClick(cateId);
		return booklist;
	}

}
