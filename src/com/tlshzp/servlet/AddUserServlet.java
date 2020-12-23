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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/addUserServlet")
public class AddUserServlet extends HttpServlet {
    UserService us = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        String[] numbers = req.getParameterValues("numbers");
        String[] names = req.getParameterValues("names");
        String[] sexs = req.getParameterValues("sexs");
        String[] phones = req.getParameterValues("phones");
        String[] emails = req.getParameterValues("emails");

        for (int i = 0; i < names.length; ++i)
            if (names[i] != "" && names[i] != null) {
                boolean sex = sexs[i] == "男" ? false : true;
                users.add(new User(Long.parseLong(numbers[i]), names[i], sex, Long.parseLong(phones[i]), emails[i]));
            }
        int res = us.insertUser(users);
        req.setAttribute("addUser_msg", "成功" + res + "条数据，失败" + (names.length - res) + "条数据");
        req.getRequestDispatcher("addUser.jsp").forward(req, resp);
    }
}
