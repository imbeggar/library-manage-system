<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script>
        function refreshCode() {
            //1.切换验证码
            var vcode = document.getElementById("vcode");
            //2.设置其src属性，加时间戳
            /*
            缓存先看请求地址是不是一样，地址一样就取出缓存内容
                加new Date().getTime()，每次请求地址就不一样，保证了不从缓存里面取
             */
            vcode.src = "${pageContext.request.contextPath}/checkCodeServlet?time=" + new Date().getTime();
        }
    </script>
</head>
<body>
<div class="login">
    <div class="content clearfix">
        <div class="content-left">
            <div class="logo">
                <img src="images/logo.png" alt=""/>
                <p>攀枝花学院图书管理系统</p>
            </div>
        </div>
        <div class="shu"></div>
        <div class="content-right">
            <div class="login-form">
                <h2>用户登录/LOGIN</h2>
                <div class="identifire">
                    <span>身　份：</span>
                    <select>
                        <option value="学生" selected="selected">学生</option>
                        <option value="教师教辅人员">教师教辅人员</option>
                    </select>
                </div>
                <div class="account clearfix">
                    <span>账　号：</span>
                    <input type="text" value="" />
                </div>
                <div class="password clearfix">
                    <span>密　码：</span>
                    <input type="text" value="" />
                </div>
                <div class="code clearfix">
                    <span>验证码：</span>
                    <input type="text" id="verifycode" name="verifycode" placeholder="请输入验证码"/>
                    <a href="javascript:refreshCode()" style="padding-left: 10px">
                        <img src="${pageContext.request.contextPath}/checkCodeServlet" title="刷新" id="vcode">
                    </a>
                </div>
                <div class="btn">
                    <span id="login"><a>登录</a></span>
                    <span class="forget"><a href="password.jsp">忘记密码</a></span>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        $('#login').on('click','a',function(){
            var aVal = $('.identifire select');
            if (aVal.val() == '学生') {
                $(this).attr('href','StudentIndext.jsp');
            } else if (aVal.val() == '教师教辅人员'){
                $(this).attr('href','TeacherIndex.html');
            }
        });
    });


</script>
<!--<script type="text/javascript">
    $(document).ready(function(){
        if (window.PIE) {
            $('.rounded').each(function() {
                PIE.attach(this);
            });
        }
    });
</script>-->
</body>
</html>
