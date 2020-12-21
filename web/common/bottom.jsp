<%@ page import="com.tlshzp.utils.CookieUtils" %>
<%@ page import="com.tlshzp.listener.CountLitsener" %>
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
        <span>当前在线人数<%=CountLitsener.getActiveNumber()%></span>
        <br/>
        <span>copyright@hahaha</span>
    </div>
</body>
</html>


