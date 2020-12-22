package com.tlshzp.servlet;

import com.tlshzp.pojo.Book;
import com.tlshzp.service.BookService;
import com.tlshzp.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/user/searchServlet")
public class SearchServlet extends HttpServlet {
    BookService bs = new BookServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Book> books = new ArrayList<>();
        books.addAll(bs.findBookByName(keyword));
        books.addAll(bs.findBookByAuthor(keyword));
        books.addAll(bs.findBookByPublisher(keyword));
        Set<Book> books1 = new HashSet<>();
        books1.addAll(books);
        books.clear();
        books.addAll(books1);
        req.setAttribute("books", books);
        req.getRequestDispatcher("search.jsp").forward(req, resp);
        return;
    }
}
