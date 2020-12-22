package com.tlshzp.dao.impl;

import com.tlshzp.dao.BookDao;
import com.tlshzp.pojo.Book;
import com.tlshzp.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int insertBook(Book book) {
        String sql = "insert into book (bookName, author, publisher, borrow_date, back_date) values (?, ?, ?, ?, ?)";
        int count = template.update(sql, new Object[]{
                book.getBookName(),
                book.getAuthor(),
                book.getPublisher(),
                book.getBorrow_date(),
                book.getBack_date()
        });
        return count;
    }

    @Override
    public int insertBook(List<Book> books) {
        String sql = "insert into book (bookName, author, publisher, borrow_date, back_date) values (?, ?, ?, ?, ?)";
        List<Object[]> batchArgs = new ArrayList<>();
        for (Book book : books) {
            batchArgs.add(new Object[]{
                    book.getBookName(),
                    book.getAuthor(),
                    book.getPublisher(),
                    book.getBorrow_date(),
                    book.getBack_date()
            });
        }
        int[] counts = template.batchUpdate(sql, batchArgs);
        int count = 0;
        for (int i : counts)
            count += i;
        return count;
    }

    @Override
    public int deleteBookById(String id) {
        String sql = "delete from book where id = ?";
        int count = template.update(sql, new Object[]{id});
        return count;
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update book set bookName = ?, author = ?, publisher = ?, borrow_date = ?, back_date = ? where id = ?";
        int count = template.update(sql, new Object[]{
                book.getBookName(),
                book.getAuthor(),
                book.getPublisher(),
                book.getBorrow_date(),
                book.getBack_date(),
                book.getId()
        });
        return count;
    }

    @Override
    public List<Book> selectAllBooks() {
        String sql = "select * from book";
        List<Book> books = template.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return books;
    }

    @Override
    public Book findBookById(int id) {
        String sql = "select * from book where id = ?";
        Book book = template.query(sql, new ResultSetExtractor<Book>() {
            @Override
            public Book extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Book book1 = new Book();
                if (resultSet.next()) {
                    book1.setId(resultSet.getInt("id"));
                    book1.setBookName(resultSet.getString("bookName"));
                    book1.setAuthor(resultSet.getString("author"));
                    book1.setPublisher(resultSet.getString("publisher"));
                    book1.setBorrow_date(resultSet.getDate("borrow_date"));
                    book1.setBack_date(resultSet.getDate("back_date"));
                }
                return book1;
            }
        }, id);
        return book;
    }

    @Override
    public List<Book> findBookByName(String bookName) {
        String sql = "select * from book where locate(bookName, ?)";
        List<Book> books = template.query(sql, new BeanPropertyRowMapper<Book>(Book.class), bookName);
        return books;
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        String sql = "select * from book where locate(author, ?)";
        List<Book> books = template.query(sql, new BeanPropertyRowMapper<Book>(Book.class), author);
        return books;
    }

    @Override
    public List<Book> findBookByPublisher(String publisher) {
        String sql = "select * from book where locate(publisher, ?)";
        List<Book> books = template.query(sql, new BeanPropertyRowMapper<Book>(Book.class), publisher);
        return books;
    }

    @Override
    public List<Book> findBookByDateIn(Date left, Date right) {
        String sql = "select * from book where borrow_date > ? and back_date < ?";
        List<Book> books = template.query(sql, new BeanPropertyRowMapper<Book>(Book.class), left, right);
        return books;
    }

    @Override
    public List<Book> findBookByDateOut(Date left, Date right) {
        String sql = "select * from book where borrow_date < ? and back_date > ?";
        List<Book> books = template.query(sql, new BeanPropertyRowMapper<Book>(Book.class),left, right);
        return books;
    }
}
