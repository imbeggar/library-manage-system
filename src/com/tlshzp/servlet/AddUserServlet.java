package com.tlshzp.servlet;

import com.tlshzp.pojo.Acount;
import com.tlshzp.pojo.User;
import com.tlshzp.service.AcountService;
import com.tlshzp.service.UserService;
import com.tlshzp.service.impl.AcountServiceImpl;
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
    AcountService as = new AcountServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        List<Acount> acounts = new ArrayList<>();
        String[] numbers = req.getParameterValues("numbers");
        String[] names = req.getParameterValues("names");
        String[] sexs = req.getParameterValues("sexs");
        String[] phones = req.getParameterValues("phones");
        String[] emails = req.getParameterValues("emails");

        for (int i = 0; i < names.length; ++i)
            if (names[i] != "" && names[i] != null) {
                if (as.findAcountByNumber(Long.parseLong(numbers[i])) == null) {
                    boolean sex = sexs[i].equals("男") ? false : true;
                    users.add(new User(Long.parseLong(numbers[i]), names[i], sex, Long.parseLong(phones[i]), emails[i]));
                    acounts.add(new Acount(Long.parseLong(numbers[i]), numbers[i], false));
                }
            }
        int resUser = 0;
        int resAcount = 0;
        if (users.size() != 0)
            resUser = us.insertUser(users);
        if (acounts.size() != 0)
            resAcount = as.insertAcount(acounts);
        if (resAcount != resUser) System.out.println("新建用户有错误产生");
        req.setAttribute("addUser_msg", "成功" + resUser + "条数据，失败" + (names.length - resUser) + "条数据");
        req.getRequestDispatcher("addUser.jsp").forward(req, resp);
    }
}
