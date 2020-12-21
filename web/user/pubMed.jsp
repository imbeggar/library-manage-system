<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--学生借书信息
    待改造！！！
-->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" type="text/css" href="../css/StudentPubMed.css"/>


</head>
<body>
<div class="container">
    <div class="content">
        <div class="bx">
            <div class="box">
                <div class="top">
                    <div class="left">当前位置>借书信息</div>
                </div>
                <div class="content">
                    <div class="left">
                        <i class="column"></i>
                        <span class="tit">已借/外借</span>
                    </div>
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
                            <tr>
                                <td>1</td>
                                <td>java</td>
                                <td>ABCD</td>
                                <td>人民邮电出版社</td>
                                <td>2020.12.21</td>
                                <td>2021.1.21</td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../js/jquery-1.9.1.min.js"></script>
<script>
    $('.l').click(function () {
        $('.oInp').removeAttr('disabled');
        $.ajax({
            url: "http://101.201.154.205:9090/survey/list",
            data: {
                t: Math.random()
            },
            type: 'get',
            dataType: 'jsonp',
            'jsonp': 'callback'
        }).then(function (res) {
            console.log(res);
        },function (err) {
            console.log(err);
        });
    });
    $('.r').click(function () {
        $('.oInp').attr('disabled','disabled');

    });

</script>
</body>
</html>

