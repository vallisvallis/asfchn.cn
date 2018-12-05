<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<link rel="shortcut icon" href="../images/favicon.ico"
	type="image/x-icon" />
<meta name="robots" content="all" />
<meta name="author" content="郑州谛道文化传播有限公司 tel:18838262217" />
<meta name="Copyright" content="航协" />
<title>航协登录和注册界面</title>
<meta name="keywords" content="航协登录和注册界面" />
<meta name="description" content="航协登录和注册界面" />
<link rel="stylesheet" type="text/css" href="login/style.css">
<link rel="stylesheet" type="text/css" href="login/popup-box.css">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<script type="text/javascript" src="login/jquery.min.js"></script>
<script type="text/javascript" src="login/jquery.magnific-popup.js"
	type="text/javascript"></script>
<script type="text/javascript" src="login/modernizr.custom.53451.js"></script>
<script>
	$(document).ready(function() {
		$('.popup-with-zoom-anim').magnificPopup({
			type : 'inline',
			fixedContentPos : false,
			fixedBgPos : true,
			overflowY : 'auto',
			closeBtnInside : true,
			preloader : false,
			midClick : true,
			removalDelay : 300,
			mainClass : 'my-mfp-zoom-in'
		});
	});
</script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5shiv.min.js"></script>
<script type="text/javascript" src="js/respond.min.js"></script>
<![endif]-->

<script type="text/javascript">
function login(){
var form =document.forms[0];


form.action="<%=basePath %>loginWithName";
form.method="post";
form.submit();

}


</script>
</head>

<body>
	<h1>
		<a href="#"><img src="login/logo.png"></a>
	</h1>
	<div class="w3layouts">
		<div class="signin-agile">
			<h2>登录（用户名为大写，密码为小写）</h2>
			<form action="" method="post">
				<input type="text" name="username" class="name" placeholder="用户名" required=""> 
					<input type="password" name="password"	class="password" placeholder="密码" required="">
				<ul>
					<li><input type="checkbox" id="brand1" value=""> <label
						for="brand1"><span></span>记住密码</label></li>
				</ul>
				<a href="#">忘记密码?</a><br>
				<div class="clear"></div>
				<input type="submit" value="登录"  onclick="login()"> 
			
			</form>

		</div>
		<div class="signup-agileinfo">
			
			<h3>成为会员流程：</h3>
			<a href="allTeamsIndex"><p>请点击此链接,选择您要加入的会员单位</p></a>
			<!--  <div class="more"> <a class="book popup-with-zoom-anim button-isi zoomIn animated" data-wow-delay=".5s" href="#small-dialog">点击注册</a> </div>-->
		</div>
		<div class="clear"></div>
	</div>
	<div class="footer-w3l">
		<p class="agileinfo">Copyright © 2018 猛犸科技 </p>
	</div>
	<div class="pop-up">
		<div id="small-dialog" class="mfp-hide book-form">
			<h3>在线注册</h3>
			<form action="#" method="post">
				<input type="text" name="Name" placeholder="用户名" required="" /> <input
					type="text" name="Email" class="email" placeholder="邮件" required="" />
				<input type="password" name="Password" class="password"
					placeholder="密码" required="" /> <input type="password"
					name="Password" class="password" placeholder="重复密码" required="" />
				<input type="submit" value="点击注册">
			</form>
		</div>
	</div>
</body>
</html>
