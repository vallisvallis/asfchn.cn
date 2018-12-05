<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon" />
<meta name="robots" content="all"/>
<meta name="author" content="郑州谛道文化传播有限公司 tel:18838262217"/>
<meta name="Copyright" content="航协"/>
<title>航协</title>
<meta name="keywords" content="航协首页"/>
<meta name="description" content="航协首页"/>

<link rel="stylesheet" type="text/css" href="css/webstyle.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
<header>	
	<div class="logo fl"><img src="images/logo.png" class="pclogo"><img src="images/mlogo.png" class="mlogo"></div>
	<div class="headbut fr"><a href="login"><button class="button button_border" data-button="blue">登录</button></a></div>
	<ul class="fr">
		<li><a href="showAllNewsInIndex">新闻公告</a></li>
		<li><a href="content.jsp">赛事活动</a></li>
		<li><a href="login">成为会员</a></li>
	</ul>
</header>
<!-- <canvas id="canvas"  ></canvas> -->
<div class="indexcon">	
	<ul class="white">
		<a href="showAllNewsInIndex" class="sekuai1hover">	
		<li class="sekuai1 white indexfont">
			<div class="icon" ><img src="images/ico6.png"></div>
			<h2>新闻公告</h2>
			<p>${news }</p>
		</li>
		</a>
		<a href="content.jsp" class="sekuai2hover">
		<li class="sekuai2 white indexfont">
			<div class="icon"><img src="images/ico1.png"></div>
			<h2>赛事活动</h2>
			<p></p>
		</li>
		</a>
		<a href="error2.jsp" class="sekuai3hover">
		<li class="sekuai3 white indexfont">
			<div class="icon"><img src="images/ico4.png"></div>
			<h2>飞行器注册</h2>
			<p>即将开放</p>
		</li>
		</a>
		<a href="error2.jsp" class="sekuai4hover">
		<li class="sekuai4 white indexfont">
			<div class="icon"><img src="images/ico3.png"></div>
			<h2>驾照报名</h2>
			<p>即将开放</p>
		</li>
		</a>
		<a href="allTeamsIndex" class="sekuai5hover">
		<li class="sekuai5 white indexfont">
			<div class="icon"><img src="images/ico2.png"></div>
			<h2>会员单位查询</h2>
			<p></p>
		</li>
		</a>
		<a href="trainTeamIndex" class="sekuai6hover">
		<li class="sekuai6 white indexfont">
			<div class="icon"><img src="images/ico8.png"></div>
			<h2>训练单位查询</h2>
			<p></p>
		</li>
		</a>
		<a href="flyTeamIndex" class="sekuai7hover">
		<li class="sekuai7 white indexfont">
			<div class="icon"><img src="images/ico9.png"></div>
			<h2>飞行营地查询</h2>
			<p></p>
		</li>
		</a>
		<a href="#" class="sekuai8hover">
		<li class="sekuai8 white indexfont">
			<div class="icon"><img src="images/ico10.png">
			<h2>视频分享</h2>
			<p></p>
		</li>
		</a>
	</ul>
	<div class="copyright">
		<div class="copyimg"><img src="images/hangXieWeiXin.jpg"></div>
		<p>地址：郑州市健康路150号 联系方式：0371-63936502&nbsp;&nbsp;&nbsp;豫ICP备18206461号</p>
	</div>
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="css/background.js"></script> -->

	 
</body>
</html>
