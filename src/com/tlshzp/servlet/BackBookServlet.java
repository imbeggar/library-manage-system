package com.tlshzp.servlet;

import com.tlshzp.pojo.Book;
import com.tlshzp.service.BBInfoService;
import com.tlshzp.service.BookService;
import com.tlshzp.service.impl.BBInfoServiceImpl;
import com.tlshzp.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/backBookServlet")
public class BackBookServlet extends HttpServlet {
    BBInfoService bis = new BBInfoServiceImpl();
    BookService bs = new BookServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int res = bis.deleteInfoById(id);
        Book book = bs.findBookById(id);
        book.setBorrow_date(null);
        book.setBack_date(null);
        res  += bs.updateBook(book);
        if (res == 2) req.setAttribute("manage_msg", "还书成功");
        else req.setAttribute("manage_msg", "还书失败");
        req.getRequestDispatcher("booksManage.jsp").forward(req, resp);
        return;
    }
}
