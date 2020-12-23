<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.tlshzp.pojo.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tlshzp.service.BookService" %>
<%@ page import="com.tlshzp.service.impl.BookServiceImpl" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.tlshzp.service.UserService" %>
<%@ page import="com.tlshzp.service.impl.UserServiceImpl" %>
<%@ page import="com.tlshzp.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="../js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script>
        $(window).load(function(){
            $('.sex').each(function(){
                var s = $(this).val().toString();
                console.info(s)
                s = (s == "false" ? "男" : "女");
                console.info(s);
                $(this).find("option").get(0).value = "男";
                $(this).val(s);
            });
        });
    </script>
</head>
<body>
<div class="container theme-showcase" role="main">
    <%
        UserService us = new UserServiceImpl();
        List<User> users = us.selectAllUsers();
        if (users == null || users.size() == 0)
            out.print("<div class=\"alert alert-warning\" role=\"alert\"><strong>提示</strong>未查询到用户</div>");
        else {
            request.setAttribute("users", users);
    %>
    <div>
        <table class="table table-striped" style="margin-top: 20px">
            <thead>
            <tr>
                <th>用户id</th>
                <th>姓名</th>
                <th>性别</th>
                <th>手机号</th>
                <th>邮箱</th>
                <th style="width: 100px;">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <form action="updateUserServlet" method="POST">
                    <tr>
                        <td><input type="text" class="form-control" name="number" value="${user.number}" readonly="readonly"></td>
                        <td><input type="text" class="form-control" name="name" value="${user.name}"></td>
                        <td>
                            <select name="sex", class="form-control sex">
                                <option value="${user.sex}">男</option>
                                <option value="女">女</option>
                            </select>
                        </td>
                        <td><input type="text" class="form-control" name="phone" value="${user.phone}"></td>
                        <td><input type="text" class="form-control" name="email" value="${user.email}"></td>
                        <td>
                            <div class="row">
                                <input type="submit" value="修改" class="btn btn-sm btn-primary">
                                <a href="deleteUserServlet?number=${user.number}" class="btn btn-sm btn-danger">删除</a>
                            </div>
                        </td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%}%>
    <%
        String uu_msg = (String) request.getAttribute("uu_msg");
        if (uu_msg != null && uu_msg != "")
            out.print("<div class=\"alert alert-warning\" role=\"alert\"><strong>提示</strong>" + uu_msg + "</div>");
    %>
</div>
</body>
</html>
