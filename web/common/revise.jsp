<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/StudentRevise.css">
</head>
<body>
<div class="container information-content">
    <div class="content">
        <div class="information-title">
            <span>当前位置>修改密码</span>
        </div>
        <form action="reviseServlet" method="post">
            <div class="revise-content clearfix ">
                <div class="list fr"><label>原密码</label> : <input id="origin" type="password" value="" name="origin"/></div>
                <div class="list fr"><label>新密码</label> : <input id="new1" type="password" value="" name="new_1"/></div>
                <div class="list fr "><label>确认密码</label> : <input id="new2" type="password" value="" name="new_2"/></div>
                <div class="list fr "><span style="font-size: 10px; color: red">${revise_msg}</span></div>
            </div>
            <div class="list1 "> <input type="submit" value="提交"/></div>
        </form>
    </div>
</div>
</body>
</html>