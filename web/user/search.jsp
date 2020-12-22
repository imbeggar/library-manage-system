<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/search.css">
    <link rel="stylesheet" type="text/css" href="../css/StudentPubMed.css"/>
</head>

<body onload="refresh();">
<div class="container">
    <div class="search-content content clearfix">
        <div class="search-bar  clearfix ">
            <form action="searchServlet", method="post">
                <div class="bar-content clearfix fl">
                    <input type="text" value="" class="fr" name="keyword" />
                </div>
                <input type="submit" style="background-color: rgb(23,126,193)" class="search-font fr" value="搜索" />
            </form>
            <div class="word fl">建议搜索词汇</div>
            <div class="list fl ">
                <ul class="clearfix">
                    <li>书名</li>
                    <li>作者</li>
                </ul>
            </div>
        </div>
    </div>
    <div style="margin: 10px">
        <table>
            <thead>
                <th>编号</th>
                <th>书名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>借书日期</th>
                <th>归还日期</th>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.bookName}</td>
                        <td>${book.author}</td>
                        <td>${book.publisher}</td>
                        <td class="book">${book.borrow_date}</td>
                        <td class="book">${book.back_date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>

</html>