<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/StudentRevise.css">
    <script type="text/javascript">
        function checkPwd() {
            var pwd1 = document.getElementById("origin").value;
            var pwdSpan = document.getElementById("warning");
            if (pwd1 == "" || pwd1 == null) {
                pwdSpan.innerHTML = '<div class="alert alert-warning" role="alert"><strong>提示:&nbsp&nbsp</strong>密码不能为空</div>';
                document.getElementById("a").innerHTML = "×";
                return false;
            } else {
                document.getElementById("a").innerHTML = "✓"
                return true;
            }
        }
        function checkPwd1() {
            var pwd1 = document.getElementById("new1").value;
            var pwdSpan = document.getElementById("warning");
            var reg = /^[\w_-]{6,16}$/;
            if (pwd1 == "" || pwd1 == null) {
                pwdSpan.innerHTML = '<div class="alert alert-warning" role="alert"><strong>提示:&nbsp&nbsp</strong>新密码不能为空</div>';
                document.getElementById("b").innerHTML = "×";
                return false;
            } else if (!reg.test(pwd1)) {
                pwdSpan.innerHTML = '<div class="alert alert-warning" role="alert"><strong>提示:&nbsp&nbsp</strong>6-16位数字或字母或\'-\'\'_\'</div>';
                document.getElementById("b").innerHTML = "×";
                return false;
            } else {
                document.getElementById("b").innerHTML = "✓"
                return true;
            }
        }
        function checkPwd2() {
            var pwd1 = document.getElementById("new1").value;
            var pwd2 = document.getElementById("new2").value;
            var pwdSpan = document.getElementById("warning");
            checkPwd1();
            if (pwd2 == "" || pwd2 == null) {
                pwdSpan.innerHTML = '<div class="alert alert-warning" role="alert"><strong>提示:&nbsp&nbsp</strong>确认密码不能为空</div>';
                document.getElementById("c").innerHTML = "×";
                return false;
            } else if (pwd1 != pwd2) {
                pwdSpan.innerHTML = '<div class="alert alert-warning" role="alert"><strong>提示:&nbsp&nbsp</strong>确认密码不同</div>';
                document.getElementById("c").innerHTML = "×";
                return false;
            } else {
                document.getElementById("c").innerHTML = "✓"
                return true;
            }
        }
        function check(){
            if (checkPwd1() && checkPwd1() && checkPwd2()) return true;
            else return false;
        }
    </script>
    </head>
<body>
<div class="container information-content">
    <div class="content">
        <div class="information-title">
            <span>当前位置>修改密码</span>
        </div>
        <form action="reviseServlet" method="post" onsubmit="return check()">
            <%
                String revise_msg = (String) request.getAttribute("revise_msg");
                if (revise_msg != null) out.print("<div class=\"alert alert-warning\" role=\"alert\"><strong>提示: &nbsp&nbsp</strong>" + revise_msg + "</div>");
            %>
            <div id="warning"></div>
            <div class="revise-content clearfix ">
                <div class="list fr"><label>原密码</label> : <input id="origin" type="password" value="" name="origin" onblur="checkPwd();"/><span id="a"></span></div>
                <div class="list fr"><label>新密码</label> : <input id="new1" type="password" value="" name="new_1" onblur="checkPwd1();"/><span id="b"></span></div>
                <div class="list fr "><label>确认密码</label> : <input id="new2" type="password" value="" name="new_2" onblur="checkPwd2();"/><span id="c"></span> </div>
            </div>
            <div style="text-align: center;"> <input class="btn btn-sm btn-success" type="submit" value="提交"/></div>
        </form>
    </div>
</div>
</body>
</html>