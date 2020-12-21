<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			*{
				margin: 0;
				padding: 0;
			}
			frame{
				height: 2000px;
			}
		</style>
	</head>
	<frameset frameborder="0" rows="60, *, 50">
		<frame src="../common/header.jsp" noresize="noresize" scrolling="no" />
		<frameset frameborder="0" cols="210,*">
			<frame src="left.jsp" noresize="noresize" scrolling="no" />
			<frame src="booksManage.jsp" noresize="noresize" scrolling="yes" name="main" />
		</frameset>
		<frame src="../common/bottom.jsp" noresize="noresize" scrolling="no" />
	</frameset>
</html>
