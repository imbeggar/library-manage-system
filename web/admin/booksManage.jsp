<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.tlshzp.pojo.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tlshzp.service.BookService" %>
<%@ page import="com.tlshzp.service.impl.BookServiceImpl" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>图书管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<div class="content"><%
		BookService bs = new BookServiceImpl();
		List<Book> books = bs.selectAllBooks();
		if (books == null || books.size() == 0)
			out.print("<div class=\"alert alert-warning\" role=\"alert\"><strong>提示</strong>没有查询到相关书籍。</div>");
		else {
			SimpleDateFormat template = new SimpleDateFormat("yyyy-MM-dd");
	%>
		<div>
			<table class="table table-striped" style="margin-top: 20px">
				<thead>
				<tr>
					<th>编号</th>
					<th>书名</th>
					<th>作者</th>
					<th>出版社</th>
					<th>借出时间</th>
					<th>还书时间</th>
					<th style="width: 150px;">操作</th>
				</tr>
				</thead>

				<%--                查询--%>
				<%--			<form action="FindBooks" method="POST">--%>
				<%--				<tr>--%>
				<%--					<td width="70px"><input type="text" class="form-control" name="id"></td>--%>
				<%--					<td><input type="text" class="form-control" name="name"></td>--%>
				<%--					<td>--%>
				<%--						<div class="form-inline" align="center">--%>
				<%--							<div class="form-group">--%>
				<%--								<input type="text" class="form-control" style="width: 90px" name="priceLeft" placeholder="0">--%>
				<%--							</div>--%>
				<%--							---%>
				<%--							<div class="form-group">--%>
				<%--								<input type="text" class="form-control" style="width: 90px" name="priceRight" placeholder="∞">--%>
				<%--							</div>--%>
				<%--						</div>--%>
				<%--					</td>--%>
				<%--					<td><input type="text" class="form-control" name="author"></td>--%>
				<%--					<td><input type="text" class="form-control" name="publisher"></td>--%>
				<%--					<td>--%>
				<%--						<input type="submit" value="查询" class="btn btn-sm btn-primary">--%>
				<%--					</td>--%>
				<%--				</tr>--%>
				<%--			</form>--%>

				<%--                展示--%>
				<%--			<c:forEach var="book" items="${books}">--%>
				<%--				<form action="updateBookServlet" method="POST">--%>
				<%--					<tr>--%>
				<%--						<td><input type="text" class="form-control" name="id" value="${book.id}" readonly="readonly"></td>--%>
				<%--						<td><input type="text" class="form-control" name="name" value="${book.bookName}"></td>--%>
				<%--						<td><input type="text" class="form-control" name="author" value="${book.author}"></td>--%>
				<%--						<td><input type="text" class="form-control" name="publisher" value="${book.publisher}"></td>--%>
				<%--						<td><input type="date" class="form-control" name="borrow_date" value="${book.borrow_date}"></td>--%>
				<%--						<td><input type="date" class="form-control" name="back_date" value="${book.back_date}"></td>--%>
				<%--						<td style="text-align: center;">--%>
				<%--							<div class="row">--%>
				<%--								<input type="submit" value="修改" class="btn btn-sm btn-primary">--%>
				<%--								<a href="deleteBookServlet?id=${book.id}" class="btn btn-sm btn-danger">删除</a>--%>
				<%--							</div>--%>
				<%--						</td>--%>
				<%--					</tr>--%>
				<%--				</form>--%>
				<%--			</c:forEach>--%>
				<tbody>
				<%
					for (Book book : books) {
						out.print("<form action=\"updateBookServlet\" method=\"POST\"><tr>");
						out.print("<td><input type=\"text\" class=\"form-control\" name=\"id\" value=\"" + book.getId() +"\" readonly=\"readonly\"></td>");
						out.print("<td><input type=\"text\" class=\"form-control\" name=\"name\" value=\"" + book.getBookName() + "\"></td>");
						out.print("<td><input type=\"text\" class=\"form-control\" name=\"author\" value=\"" + book.getAuthor() + "\"></td>");
						out.print("<td><input type=\"text\" class=\"form-control\" name=\"publisher\" value=\"" + book.getPublisher() + "\"></td>");
						if (book.getBorrow_date() == null) out.print("<td colspan=\"2\"><input type=\"text\" class=\"form-control\" value=\"未借出\"， readonly=\"readonly\"></td>");
						else {
							out.print("<td><input type=\"date\" class=\"form-control\" name=\"borrow_date\" value=\"" + template.format(book.getBorrow_date()) + "\"></td>");
							out.print("<td><input type=\"date\" class=\"form-control\" name=\"back_date\" value=\"" + template.format(book.getBack_date()) + "\"></td>");
						}
//					if (book.getBorrow_date() == null) out.print("\n" +
//							"\t\t\t\t\t\t<td><input type=\"date\" class=\"form-control\" name=\"borrow_date\" value=\"1970-01-01\"></td>");
//					else out.print("\n" +
//							"\t\t\t\t\t\t<td><input type=\"date\" class=\"form-control\" name=\"borrow_date\" value=\"" + template.format(book.getBorrow_date()) + "\"></td>");
//					if (book.getBack_date() == null) out.print("\n" +
//							"\t\t\t\t\t\t<td><input type=\"date\" class=\"form-control\" name=\"back_date\" value=\"1970-01-01\"></td>");
//					else out.print("\n" +
//							"\t\t\t\t\t\t<td><input type=\"date\" class=\"form-control\" name=\"back_date\" value=\"" + template.format(book.getBack_date()) + "\"></td>");

						out.print("<td style=\"text-align: center;\">" +
								"<div class=\"row\">" +
								"<input type=\"submit\" value=\"修改\" class=\"btn btn-sm btn-primary\">" +
								"<a href=\"backBookServlet?id=" + book.getId() + "\" class=\"btn btn-sm btn-success\">还书</a>" +
								"<a href=\"deleteBookServlet?id=" + book.getId() + "\" class=\"btn btn-sm btn-danger\">删除</a>" +
								"</div>" +
								"</td>" +
								"</tr>" +
								"</form>");
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
