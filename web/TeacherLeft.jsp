<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/StudentLeft.css">
	</head>
	<body>
		<div class="nav">
			<div class="nav-list">
				<div class="nav-tit">
					<a href="TeacherPersonalInfo.jsp" target="main">
						<img src="images/archives-msg.png" alt="">
						<span>个人信息</span>
					</a>
				</div>
				<div class="nav-tit" id="personal">
					<a href="BooksInfo.jsp" target="main">
						<img src="images/PubMed-msg.png" alt="">
						<span>图书信息</span>
					</a>
				</div>
				<div class="nav-tit">
					<a href="StudentRevise.jsp" target="main">
					<img src="images/modify-password.png" alt="">
					<span>修改密码</span>
					</a>
				</div>
			</div>
		</div>
		
		<script src="js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script>
			$(document).ready(function(){
				$('#personal').on('click',function(){
					$('#personal_child').fadeToggle(300);
				});
				let aLi = $('#personal_child li');
				aLi.on('click',function(){
					$(this).addClass('active').siblings('li').removeClass('active');
				})
			});
		</script>
	</body>
</html>
