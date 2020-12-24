package com.tlshzp.servlet;

import com.tlshzp.pojo.BBInfo;
import com.tlshzp.pojo.Book;
import com.tlshzp.service.BBInfoService;
import com.tlshzp.service.BookService;
import com.tlshzp.service.impl.BBInfoServiceImpl;
import com.tlshzp.service.impl.BookServiceImpl;
import com.tlshzp.utils.CookieUtils;
import com.tlshzp.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/user/borrowServlet")
public class BorrowServlet extends HttpServlet {
    BookService bs = new BookServiceImpl();
    BBInfoService bis = new BBInfoServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        BBInfo bbInfo = bis.findInfoById(id);
        if (bbInfo == null) {   //可借
            //获取要借的书信息
            Book book = bs.findBookById(id);
            //修改该书的时间信息
            book.setBorrow_date(new Date());
            try {
                book.setBack_date(DateUtils.caculateDate(new Date(), 0, 1, 0));
            } catch (Exception e) {
                e.printStackTrace();
            }
            bs.updateBook(book);
            //添加BBInfo
            bbInfo = new BBInfo(
                    CookieUtils.getAcount(req.getCookies(), req.getSession(), resp).getNumber(),
                    book.getId(),
                    book.getBorrow_date(),
                    book.getBack_date()
            );
            bis.insertInfo(bbInfo);
            req.setAttribute("search_msg", "借书成功");
        } else {    //已借出
            req.setAttribute("search_msg", "该书已被借出，现不在馆内");
        }
        req.getRequestDispatcher("search.jsp").forward(req, resp);
        return;
    }
}
