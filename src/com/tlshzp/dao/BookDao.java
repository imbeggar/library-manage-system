package com.tlshzp.dao;

import com.tlshzp.pojo.Book;

import java.util.Date;
import java.util.List;

public interface BookDao {
    //增
    int insertBook(Book book);
    int insertBook(List<Book> books);
    //删
    int deleteBookById(String id);
    //改
    int updateBook(Book book);
    //查
    List<Book> selectAllBooks();
    List<Book> findBookById(String id);
    List<Book> findBookByName(String bookName);
    List<Book> findBookByAuthor(String author);
    List<Book> findBookByPublisher(String Publisher);
    List<Book> findBookByDate(Date left, Date Right);
}
