<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="../css/StudentLeft.css">
    <script src="../js/jquery-1.9.1.min.js"></script>
</head>
<body>
<div class="nav">
    <div class="nav-list">
        <div class="nav-tit">
            <a href="search.jsp" target="main">
                <img src="../images/archives-msg.png" alt="">
                <span>图书搜索</span>
            </a>
        </div>
        <div class="nav-tit" id="personal">
            <a href="../common/personalInfo.jsp" target="main">
                <img src="../images/personal-msg.png" style="height: 30px" alt="">
                <span>个人信息</span>
            </a>
        </div>
        <div class="nav-tit">
            <a href="pubMed.jsp" target="main">
                <img src="../images/PubMed-msg.png" alt="">
                <span>借书信息</span>
            </a>
        </div>
        <div class="nav-tit">
            <a href="../common/revise.jsp" target="main">
                <img src="../images/modify-password.png" alt="">
                <span>修改密码</span>
            </a>
        </div>
    </div>
</div>

<script>
    $(document).ready(function(){
        $('#personal').on('click',function(){
            $('#personal-child').fadeToggle(300);
        });
        let aLi = $('#personal-child li');
        aLi.on('click',function(){
            $(this).addClass('active').siblings('li').removeClass('active');
        })
    });
</script>
</body>
</html>
