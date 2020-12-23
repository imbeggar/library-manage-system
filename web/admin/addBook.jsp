<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script type="text/javascript">
        //添加<td>
        function foundTable() {
            var n = document.getElementById("n").value;
            for (var i = 0; i < n; i++) {
                var tableObj = document.getElementById("table");
                var newTr = tableObj.insertRow();

                var newTd0 = newTr.insertCell();
                var newTd1 = newTr.insertCell();
                var newTd2 = newTr.insertCell();

                newTd0.innerHTML = "<input name='names' type='text' class='form-control'/>";
                newTd1.innerHTML = "<input name='authors' type='text' class='form-control'/>";
                newTd2.innerHTML = "<input name='publishers' type='text' class='form-control'/>";
            }
        }
    </script>
</head>
<body onload="foundTable();">
<div class="container theme-showcase" role="main">
    <form action="addBookServlet" method="POST">
        <div align="center" class="form-inline" style="margin:20px 0">
            <input type="number" class="form-control" style="width: 70px" value="1" id="n">
            <input type="button" class="btn btn-sm btn-primary" value="创建表格" onclick="foundTable();">
            <input type="submit" class="btn btn-sm btn-primary" value="提交">
        </div>
        <div>
            <table id="table" class="table table-striped">
                <thead>
                <th>书名</th>
                <th>作者</th>
                <th>出版社</th>
                </thead>
            </table>
        </div>
    </form>
    <%
        String addBook_msg = (String) request.getAttribute("addBook_msg");
        if (addBook_msg != null && addBook_msg != "")
            out.print("<div class=\"alert alert-warning\" role=\"alert\"><strong>提示</strong>" + addBook_msg + "</div>");
    %>
</div>
</body>
</html>
