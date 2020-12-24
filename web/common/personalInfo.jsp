<%@ page import="com.tlshzp.utils.CookieUtils" %>
<%@ page import="com.tlshzp.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/student.css">
    <script src="../js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        //校验手机号
        function checkPhone() {
            var phoneNumber = document.getElementById("phone").value;
            var phoneSpan = document.getElementById("warning");
            var reg = /^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/;
            if (phoneNumber == "" || phoneNumber == null) {
                phoneSpan.innerHTML = '<div class="alert alert-warning" role="alert"><strong>提示:&nbsp&nbsp</strong>手机号不能为空</div>';
                phoneSpan.style.color = "red";
                return false;
            } else if (reg.test(phoneNumber)) {
                document.getElementById("a").innerHTML = '✓';
                return true;
            } else {
                phoneSpan.innerHTML =  '<div class="alert alert-warning" role="alert"><strong>提示:&nbsp&nbsp</strong>请输入正确的手机号</div>';
                phoneSpan.style.color = "red";
                return false;
            }
        }    //校验邮箱
        function checkMail() {
            var mail = document.getElementById("email").value;
            var phoneSpan = document.getElementById("warning");
            var reg = /^[\w-_]+@[\w-_]+\.[\w-_]+$/;
            if (mail == "" || mail == null) {
                phoneSpan.innerHTML =  '<div class="alert alert-warning" role="alert"><strong>提示:&nbsp&nbsp</strong>邮箱不能为空</div>';
                phoneSpan.style.color = "red";
                return false;
            } else if (reg.test(mail)) {
                document.getElementById("b").innerHTML = '✓';
                return true;
            } else {
                phoneSpan.innerHTML =  '<div class="alert alert-warning" role="alert"><strong>提示:&nbsp&nbsp</strong>请输入正确的邮箱</div>';
                phoneSpan.style.color = "red";
                return false;
            }
        }
        function check(){
            return (checkPhone() && checkMail());
        }
    </script>
</head>
<body>
<%
    User user = CookieUtils.getUser(request.getCookies(), request.getSession(), response);
    if (user == null) user = new User();
%>
<div class="container">
    <div class="content">
        <div class="header clearfix">
            <div class="top fl">当前位置>个人信息</div>
        </div>
        <div class="main">
            <!--基础信息-->
            <div class="BasicInformation">
                <div class="title">
                    基础信息
                </div>
            </div>
            <div class="content clearfix">
                <div class="left fl">
                    <div>
                        <label>姓名：</label> <%=user.getName()%>
                    </div>
                    <div>
                        <label>性别：</label> <% if (!user.isSex()) out.print("男"); else out.print("女");%>
                    </div>
                </div>
                <div class="right fr">
                    <div>
                        <label>学号/工号：</label> <%=user.getNumber()%>
                    </div>
                </div>
            </div>
            <!--联系方式-->
            <form action="updatePersonalInfo" method="post" onsubmit="return check()">
                <div class="BasicInformation">
                    <div class="title">
                        <div style="float: left">联系方式</div>
                        <div style="float: right; width: 60px" >
                            <input type="submit" id="keep" href="javascript:;" value="修改&nbsp&nbsp" style="height: 60%; width: 50px"/>
                        </div>
                    </div>
                </div>
                <div class="content clearfix">
                    <div class="left fl">
                        <div>
                            <label >手机号码：</label>
                            <input id="phone" type="number" name="phone" value="<%=user.getPhone()%>" onblur="checkPhone()"/>
                            <span id="a"></span>
                        </div>
                    </div>
                    <div class="right fr">
                        <div>
                            <label>电子邮箱：</label>
                            <input id="email" type="email" name="email" value="<%=user.getEmail()%>" class="mailbox" onblur="checkMail()"/>
                            <span id="b"></span>
                        </div>
                    </div>
                    <div id="warning"></div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    // $('#politics i').on('click', function() {
    //     $(this).siblings('ul').show();
    // });
    // $('#politics ul li').on('click', function() {
    //     var selTxt = $(this).text();
    //     $('#politics a').text(selTxt);
    //     $('#politics ul').hide();
    // });
    // $('#child i').on('click', function() {
    //     $(this).siblings('ul').show();
    // });
    // $('#child ul li').on('click', function() {
    //     var selTxt = $(this).text();
    //     $('#child a').text(selTxt);
    //     $('#child ul').hide();
    // });
</script>

</body>
</html>
