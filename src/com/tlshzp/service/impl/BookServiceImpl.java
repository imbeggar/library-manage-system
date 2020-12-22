package com.tlshzp.service.impl;

import com.tlshzp.dao.BookDao;
import com.tlshzp.dao.impl.BookDaoImpl;
import com.tlshzp.pojo.Book;
import com.tlshzp.service.BookService;

import java.util.Date;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bd = new BookDaoImpl();

    @Override
    public int insertBook(Book book) {
        return bd.insertBook(book);
    }

    @Override
    public int insertBook(List<Book> books) {
        return bd.insertBook(books);
    }

    @Override
    public int deleteBookById(String id) {
        return bd.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bd.updateBook(book);
    }

    @Override
    public List<Book> selectAllBooks() {
        return bd.selectAllBooks();
    }

    @Override
    public Book findBookById(int id) {
        return bd.findBookById(id);
    }

    @Override
    public List<Book> findBookByName(String bookName) {
        return bd.findBookByName(bookName);
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        return bd.findBookByAuthor(author);
    }

    @Override
    public List<Book> findBookByPublisher(String publisher) {
        return bd.findBookByPublisher(publisher);
    }

    @Override
    public List<Book> findBookByDateIn(Date left, Date right) {
        return bd.findBookByDateIn(left, right);
    }

    @Override
    public List<Book> findBookByDateOut(Date left, Date right) {
        return bd.findBookByDateOut(left, right);
    }
}
