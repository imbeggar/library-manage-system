<%@ page import="com.tlshzp.pojo.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/search.css">
    <link rel="stylesheet" type="text/css" href="../css/StudentPubMed.css"/>
    <script src="../../js/jquery-2.1.0.min.js"></script>

    <script>
        function borrowBook(id) {
            location.href = "${pageContext.request.contextPath}/user/addServlet?id="+id;
        }
    </script>
</head>

<body>
<div class="container">
    <div class="content">
        <div class="search-content content clearfix">
            <div class="search-bar  clearfix ">
                <form action="searchServlet", method="post">
                    <div class="bar-content clearfix fl">
                        <input type="text" value="" class="fr" name="keyword" placeholder="全部" />
                    </div>
                    <input type="submit" style="background-color: rgb(23,126,193)" class="search-font fr" value="搜索" />
                </form>
                <div class="word fl">建议搜索词汇</div>
                <div class="list fl ">
                    <ul class="clearfix">
                        <li>书名</li>
                        <li>作者</li>
                        <li>出版社</li>
                    </ul>
                </div>
            </div>
        </div>
        <%
            List<Book> books = (List<Book>) request.getAttribute("books");
            SimpleDateFormat template = new SimpleDateFormat("yyyy-MM-dd");
            String search_msg = (String) request.getAttribute("search_msg");
            if (search_msg != null && !search_msg.equals(""))
                out.print("\n" +
                        "    <div class=\"alert alert-warning\" role=\"alert\"><strong>提示:&nbsp&nbsp</strong>" + search_msg + "</div>");
            if (books != null && books.size() > 0){
        %>
        <div style="margin: 10px">
            <table border="1" class="table table-bordered table-hover">
                <thead>
                <th>编号</th>
                <th>书名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>借书日期</th>
                <th>归还日期</th>
                <th>操作</th>
                </thead>
                <tbody>
                <%--                                        <c:forEach var="book" items="${books}" varStatus="b">--%>
                <%--                                            <tr>--%>
                <%--                                                <td>${b.count}</td>--%>
                <%--                                                <td>${book.bookName}</td>--%>
                <%--                                                <td>${book.author}</td>--%>
                <%--                                                <td>${book.publisher}</td>--%>
                <%--                                                <td class="book">${book.borrow_date}</td>--%>
                <%--                                                <td class="book">${book.back_date}</td>--%>
                <%--                                                <td><button type="submit" class="btn btn-primary" onclick="borrowBook(${book.id})">借书</button></td>--%>
                <%--                                            </tr>--%>
                <%--                                        </c:forEach>--%>
                <%
                    for (Book book : books) {
                        out.print("<tr>");
                        out.print("<td>" + book.getId() + "</td>");
                        out.print("<td>" + book.getBookName() + "</td>");
                        out.print("<td>" + book.getAuthor() + "</td>");
                        out.print("<td>" + book.getPublisher() + "</td>");

                        if (book.getBorrow_date() == null) out.print("\n" +
                                "\t\t\t\t\t\t<td colspan=\"2\">当前未借出，可借书一个月</td>");
                        else {
                            out.print("<td>" + template.format(book.getBorrow_date()) + "</td>");
                            out.print("<td>" + template.format(book.getBack_date()) + "</td>");
                        }
                        if (book.getBorrow_date() == null)
                            out.print("<td><a class=\"btn btn-primary\" href=\"borrowServlet?id=" + book.getId() + "\">借书</a></td>");
                        else
                            out.print("<td><a class=\"btn btn-primary disabled\">已借出</a></td>");
                        out.print("</tr>");
                    }
                %>
                </tbody>
            </table>
        </div>
        <%}%>
    </div>
</div>
</body>

</html>