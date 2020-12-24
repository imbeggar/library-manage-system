<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/password.css"/>
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
                <form action="${pageContext.request.contextPath}/forgetPwdServlet" method="post">
                    <h2>忘记密码/LOGIN</h2>
                    <div class="identifire">
                        <span>　学  号：</span>
                        <input type="text" name="number" />
                    </div>
                    <div class="account clearfix">
                        <span>邮  箱：</span>
                        <input type="email" value="" name="email"/>
                    </div>
                    <div class="code clearfix">
                        <span>　验证码：</span>
                        <input type="text" value="" name="verifycode" />
                        <a href="javascript:refreshCode()" style="padding-left: 10px">
                            <img src="${pageContext.request.contextPath}/checkCodeServlet" title="刷新" id="vcode">
                        </a>
                    </div>
                    <span style="font-size: 10px; color: red">${forget_msg}</span>
                    <div class="btn">
                        <input type="submit" style="display: block;width: 110px;height: 100%;line-height: 30px;text-align: center;background: #4fadeb;font-size: 18px;color: #fff;" value="提交">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
