package com.tlshzp.servlet;

import com.tlshzp.service.BookService;
import com.tlshzp.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
    BookService bs = new BookServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        bs.deleteBookById(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("booksManage.jsp");
    }
}
