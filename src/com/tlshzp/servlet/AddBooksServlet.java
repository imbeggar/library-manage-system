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
import java.util.List;

@WebServlet("/admin/addBookServlet")
public class AddBooksServlet extends HttpServlet {
    BookService bs = new BookServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = new ArrayList<>();
        String[] names = req.getParameterValues("names");
        String[] authors = req.getParameterValues("authors");
        String[] publishers = req.getParameterValues("publishers");

        for (int i = 0; i < names.length; ++i)
            if (names[i] != "" && names[i] != null)
                books.add(new Book(0, names[i], authors[i], publishers[i], null, null));
        int res = bs.insertBook(books);
        req.setAttribute("addBook_msg", "成功" + res + "条数据，失败" + (names.length - res) + "条数据");
        req.getRequestDispatcher("addBook.jsp").forward(req, resp);
    }
}
