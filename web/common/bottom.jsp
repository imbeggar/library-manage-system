<%@ page import="com.tlshzp.utils.CookieUtils" %>
<%@ page import="com.tlshzp.listener.CountLitsener" %>
<%@ page import="com.tlshzp.service.impl.CountsServiseImpl" %>
<%@ page import="com.tlshzp.service.CountsServise" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
        }
        #box {
            height: 50px;
            width: 100%;
        }
    </style>
</head>
<body>
    <div align="center" id="box">
        <span>当前在线人数<%=CountLitsener.getActiveNumber()%>&nbsp&nbsp本站成功登录人数<%
            CountsServise cs = new CountsServiseImpl();
            out.print(cs.getCount());
        %></span>
        <br/>
        <span>copyright@hahaha</span>
    </div>
</body>
</html>


