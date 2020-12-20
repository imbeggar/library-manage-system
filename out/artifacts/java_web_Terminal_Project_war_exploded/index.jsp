<%@ page import="com.tlshzp.servlet.LoginServlet" %>
<%@ page import="com.tlshzp.pojo.Acount" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script>
        function refreshCode() {
            //1.切换验证码
            var vcode = document.getElementById("vcode");
            //2.设置其src属性，加时间戳
            /*
            缓存先看请求地址是不是一样，地址一样就取出缓存内容
                加new Date().getTime()，每次请求地址就不一样，保证了不从缓存里面取
             */
            vcode.src = "${pageContext.request.contextPath}/checkCodeServlet?time=" + new Date().getTime();
        }
    </script>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null)
        for (Cookie cookie : cookies)
            if (cookie.getName().equals("uuid")) {
                String uuid = cookie.getValue();
                Acount acount = (Acount) session.getAttribute(uuid);
                if (acount == null) return;
                cookie = new Cookie("uuid", uuid);
                cookie.setMaxAge(60 * 60 * 24 * 3);
                response.addCookie(cookie);
                session.setAttribute(uuid, acount);
                if (!acount.isIdentify())
                    response.sendRedirect("StudentIndex.jsp");
                else
                    response.sendRedirect("TeacherIndex.jsp");
                return;
            }
%>
<div class="login">
    <div class="content clearfix">
        <div class="content-left">
            <div class="logo">
                <img src="images/logo.png" alt=""/>
                <p>攀枝花学院图书管理系统</p>
            </div>
        </div>
        <div class="shu"></div>
        <div class="content-right">
            <div class="login-form">
                <h2>用户登录/LOGIN</h2>
                <form action="${pageContext.request.contextPath}/loginServlet" method="post">
                    <br/>
                    <div class="account clearfix">
                        <span>账　号：</span>
                        <input type="number" name="number" />
                    </div>
                    <div class="password clearfix">
                        <span>密　码：</span>
                        <input type="password" name="password" />
                    </div>
                    <div class="code clearfix">
                        <span>验证码：</span>
                        <input type="text" id="verifycode" name="verifycode" placeholder="请输入验证码"/>
                        <a href="javascript:refreshCode()" style="padding-left: 10px">
                            <img src="${pageContext.request.contextPath}/checkCodeServlet" title="刷新" id="vcode">
                        </a>
                        <span style="font-size: 10px; color: red">${login_msg}</span>
                    </div>
                    <br/>
                    <div class="btn">
                        <input type="submit" style="display: block;width: 110px;height: 100%;line-height: 30px;text-align: center;background: #4fadeb;font-size: 18px;color: #fff;" value="登录">
                        <span class="forget"><a href="password.jsp">忘记密码</a></span>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
