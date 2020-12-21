package com.tlshzp.servlet;

import com.tlshzp.pojo.Acount;
import com.tlshzp.service.AcountService;
import com.tlshzp.service.impl.AcountServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    AcountService as = new AcountServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //2.验证码校验
        //2.1获取用户填写的信息
        String number = request.getParameter("number");
        String password = request.getParameter("password");
        String verifycode = request.getParameter("verifycode");
        //2.2校验验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER"); //确保验证码一次性
        if (number == null || number == ""  || password == null || password == "" || verifycode == null || verifycode == ""){
            //提示信息
            request.setAttribute("login_msg", "账号、密码、验证码均不能为空!");
            //跳转登录页面
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(verifycode)) {
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg", "验证码错误!");
            //跳转登录页面
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        Acount acount = as.findAcountByNumber(Long.parseLong(request.getParameter("number")));
        if (acount == null || !password.equals(acount.getPassword())) {
            //密码不正确
            //提示信息
            request.setAttribute("login_msg", "账号或密码错误!");
            //跳转登录页面
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        //用户信息验证通过，设置免登录，跳转页面
        String uuid = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("uuid", uuid);
        cookie.setMaxAge(60 * 60 * 24 * 3);
        response.addCookie(cookie);
        session.setMaxInactiveInterval(60 * 60 * 24 * 3);
        session.setAttribute(uuid, acount);
        if (!acount.isIdentify())
            response.sendRedirect("user/index.jsp");
        else
            response.sendRedirect("admin/index.jsp");
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
