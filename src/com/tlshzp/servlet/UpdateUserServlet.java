package com.tlshzp.servlet;

import com.tlshzp.pojo.User;
import com.tlshzp.service.UserService;
import com.tlshzp.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    UserService us = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean sex = req.getParameter("sex").toString().equals("男")  ? false : true;
        int res = us.updateUser(new User(
                Long.parseLong(req.getParameter("number")),
                req.getParameter("name"),
                sex,
                Long.parseLong(req.getParameter("phone")),
                req.getParameter("email")
        ));
        req.setAttribute("uu_msg", "修改" + res + "个用户");
        req.getRequestDispatcher("usersManage.jsp").forward(req, resp);
        return;
    }
}
