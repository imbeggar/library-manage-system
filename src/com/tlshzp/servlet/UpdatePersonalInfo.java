package com.tlshzp.servlet;

import com.tlshzp.pojo.User;
import com.tlshzp.service.UserService;
import com.tlshzp.service.impl.UserServiceImpl;
import com.tlshzp.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/common/updatePersonalInfo")
public class UpdatePersonalInfo extends HttpServlet {
    UserService us = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        User user = CookieUtils.getUser(req.getCookies(), req.getSession(), resp);
        user.setPhone(Long.parseLong(req.getParameter("phone")));
        user.setEmail(req.getParameter("email"));
        us.updateUser(user);
        req.getRequestDispatcher("personalInfo.jsp").forward(req, resp);
    }
}
