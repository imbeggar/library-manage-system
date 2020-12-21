package com.tlshzp.servlet;

import com.tlshzp.pojo.Acount;
import com.tlshzp.service.AcountService;
import com.tlshzp.service.impl.AcountServiceImpl;
import com.tlshzp.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/common/reviseServlet")
public class ReviseServlet extends HttpServlet {
    AcountService as = new AcountServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String origin = req.getParameter("origin");
        String new_1 = req.getParameter("new_1");
        String new_2 = req.getParameter("new_2");
        if (!new_1.equals(new_2)) {
            req.setAttribute("revise_msg", "两次密码不相同！");
            req.getRequestDispatcher("revise.jsp").forward(req, resp);
            return;
        }
        Acount acount = CookieUtils.getAcount(req.getCookies(), req.getSession(), resp);
        if (acount.getPassword().equals(origin)) {
            acount.setPassword(new_1);
            if (as.updateAcount(acount) == 1) req.setAttribute("revise_msg", "成功");
            else req.setAttribute("revise_msg", "修改失败");
        } else req.setAttribute("revise_msg", "原密码错误");
        req.getRequestDispatcher("revise.jsp").forward(req, resp);
        return;
    }
}
