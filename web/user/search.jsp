<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/search.css">
    <link rel="stylesheet" type="text/css" href="../css/StudentPubMed.css"/>
</head>

<body>
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
            <div class="bottom" style="margin: 10px">
                <form>
                    <table class="table table-bordered">
                        <tr>
                            <th>编号</th>
                            <th>书名</th>
                            <th>作者</th>
                            <th>出版社</th>
                            <th>借书日期</th>
                            <th>归还日期</th>
                        </tr>
                        <c:forEach var="book" items="${books}">
                            <tr>
                                <td>${book.id}</td>
                                <td>${book.bookName}</td>
                                <td>${book.author}</td>
                                <td>${book.publisher}</td>
                                <td>${book.borrow_date}</td>
                                <td>${book.back_date}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

</html>