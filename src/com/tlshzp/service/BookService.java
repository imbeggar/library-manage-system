package com.tlshzp.service;

import com.tlshzp.pojo.Book;

import java.util.Date;
import java.util.List;

public interface BookService {
    //增
    int insertBook(Book book);
    int insertBook(List<Book> books);
    //删
    int deleteBookById(int id);
    //改
    int updateBook(Book book);
    //查
    List<Book> selectAllBooks();
    Book findBookById(int id);
    List<Book> findBookByName(String bookName);
    List<Book> findBookByAuthor(String author);
    List<Book> findBookByPublisher(String publisher);
    List<Book> findBookByDateIn(Date left, Date right);
    List<Book> findBookByDateOut(Date left, Date right);
}
