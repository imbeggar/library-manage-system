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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/admin/updateBookServlet")
public class UpdateBookServlet extends HttpServlet {
    BookService bs = new BookServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat template = new SimpleDateFormat("yyyy-MM-dd");
        Date borrow_date = null;
        Date back_date = null;
        if (req.getParameter("back_date") != null) {
            borrow_date = new Date();
            back_date = new Date();
            if (back_date.getTime() < borrow_date.getTime()) {
                req.setAttribute("manage_msg", "还书时间不能小于借书时间");
                req.getRequestDispatcher("booksManage.jsp").forward(req, resp);
                return;
            }
        }
        Book book = new Book(
                Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"),
                req.getParameter("author"),
                req.getParameter("publisher"),
                borrow_date,
                back_date
        );
        if (book != null) {
            int res = bs.updateBook(book);
            req.setAttribute("manage_msg", "修改" + res + "条数据");
        }
        req.getRequestDispatcher("booksManage.jsp").forward(req, resp);
        return;
    }
}
