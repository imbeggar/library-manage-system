package com.tlshzp.pojo;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Book {
    private int id;
    private String bookName;
    private String author;
    private String publisher;
    private Date borrow_date;
    private Date back_date;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", borrow_date=" + borrow_date +
                ", back_date=" + back_date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Objects.equals(bookName, book.bookName) && Objects.equals(author, book.author) && Objects.equals(publisher, book.publisher) && Objects.equals(borrow_date, book.borrow_date) && Objects.equals(back_date, book.back_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, author, publisher, borrow_date, back_date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Date getBack_date() {
        return back_date;
    }

    public void setBack_date(Date back_date) {
        this.back_date = back_date;
    }

    public Book() {
        this.borrow_date = new Date();
        this.back_date = new Date();
    }

    public Book(int id, String bookName, String author, String publisher, Date borrow_date, Date back_date) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.borrow_date = borrow_date;
        this.back_date = back_date;
    }

}
