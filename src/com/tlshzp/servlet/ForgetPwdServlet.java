package com.tlshzp.servlet;

import com.sun.mail.util.MailSSLSocketFactory;
import com.tlshzp.dao.AcountDao;
import com.tlshzp.pojo.Acount;
import com.tlshzp.pojo.User;
import com.tlshzp.service.AcountService;
import com.tlshzp.service.UserService;
import com.tlshzp.service.impl.AcountServiceImpl;
import com.tlshzp.service.impl.UserServiceImpl;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;

@WebServlet("/forgetPwdServlet")
public class ForgetPwdServlet extends HttpServlet {
    UserService us = new UserServiceImpl();
    AcountService as = new AcountServiceImpl();
    String number;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        number = req.getParameter("number");
        String email = req.getParameter("email");
        String verifycode = req.getParameter("verifycode");

        HttpSession sessio = req.getSession();
        String checkcode_server = (String) sessio.getAttribute("CHECKCODE_SERVER");
        sessio.removeAttribute("CHECKCODE_SERVER"); //确保验证码一次性

        if (number == null || number == "" || email == null || email == "" || verifycode == null || verifycode == ""){
            //提示信息
            req.setAttribute("forget_msg", "账号、邮箱、验证码均不能为空!");
            //跳转登录页面
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(verifycode)) {
            //验证码不正确
            //提示信息
            req.setAttribute("forget_msg", "验证码错误!");
            //跳转登录页面
            req.getRequestDispatcher("/forgetPwd.jsp").forward(req, resp);
            return;
        }
        User user = us.findUserByNumber(Long.parseLong(number));
        if (user == null) {
            //提示信息
            req.setAttribute("forget_msg", "账户不存在");
            //跳转登录页面
            req.getRequestDispatcher("/forgetPwd.jsp").forward(req, resp);
            return;
        }
        else if (!user.getEmail().equals(email)) {
            req.setAttribute("forget_msg", "邮箱不正确");
            req.getRequestDispatcher("/forgetPwd.jsp").forward(req, resp);
            return;
        }




        //创建一个配置文件保存并读取信息
        Properties properties = new Properties();
        //设置qq邮箱服务
        properties.setProperty("mail.host","smtp.qq.com");
        //设置发送协议
        properties.setProperty("mail.transport.protocol","smtp");
        //设置用户是否需要验证
        properties.setProperty("mail.smtp.quth","true");

        //关于QQ邮箱，还要设置SSL加密，加上以下代码即可
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);

        //===================准备工作完成

        //1、创建以session会话对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //发件人邮箱，授权码
                return new PasswordAuthentication("oopstls@foxmail.com","zxhufxixjmitcabi");
            }
        });

        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);

        //2、获取连接对象，通过session对象获得ransport，需要捕获或者抛出异常
        Transport transport = null;
        try {
            transport = session.getTransport();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        //3、连接服务器，抛出异常
        try {
            transport.connect("smtp.qq.com","oopstls@foxmail.com","zxhufxixjmitcabi");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //4、连接之后，创建邮件
        Message mimeMessage = null;
        try {
            mimeMessage = getMimeMessage(session, email);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //5. 发送邮件
        try {
            transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //6 关闭连接
        try {
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        req.setAttribute("forget_msg", "注意查收邮件");
        req.getRequestDispatcher("forget.jsp").forward(req, resp);
        return;
    }

    public MimeMessage getMimeMessage(Session session, String email) throws MessagingException {
        //4.1 创建邮件对象
        MimeMessage mimeMessage = new MimeMessage(session);
        //4.2 邮件发送人
        mimeMessage.setFrom(new InternetAddress("oopstls@foxmail.com"));
        //4.3 邮件接收人，可以同时发送给多人
        mimeMessage.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(email)});
        //4.4 邮件标题
        mimeMessage.setSubject("新密码");
        //4.5 邮件内容
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(62);
            stringBuffer.append(str.charAt(number));
        }
        mimeMessage.setContent("你的新密码是：" + stringBuffer.toString(), "text/html;charset=UTF-8");
        Acount acount = as.findAcountByNumber(Long.parseLong(number));
        acount.setPassword(stringBuffer.toString());
        as.updateAcount(acount);
        return mimeMessage;
    }
}
