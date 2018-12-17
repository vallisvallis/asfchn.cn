<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<link rel="shortcut icon" href="../images/favicon.ico"
	type="image/x-icon" />
<meta name="robots" content="all" />
<meta name="author" content="郑州谛道文化传播有限公司 tel:18838262217" />
<meta name="Copyright" content="航协" />
<title>列表页</title>
<meta name="keywords" content="列表页" />
<meta name="description" content="列表页" />
<link rel="stylesheet" type="text/css" href="css/webstyle.css">
</head>

<body>
	<header>
	<div class="logo fl">
		<img src="images/logo.png" class="pclogo"><img
			src="images/mlogo.png" class="mlogo">
	</div>
	<div class="headbut fr">
		<a href="http://www.baidu.com/"><button
				class="button button_border" data-button="blue">登录</button></a>
	</div>
	<ul class="fr">
		<li><a href="#">新闻公告</a></li>
		<li><a href="#">赛事活动</a></li>
		<li><a href="#">成为会员</a></li>
	</ul>
	</header>
	<div class="listwenz">
		<ul class="listnew">
			<c:forEach items="${pageInfo.list }" var="match">
				<li>
					<div class="listnewdate">
						<span class="listnewdate_m">${news.addtime }</span> <span class="listnewdate_y">${news.addtime }</span>
					</div>
					<div class="listnewtitle">
						<h3>
							<a href="#">${news.title }</a>
						</h3>

					</div>

				</li>




			</c:forEach>
		</ul>
		<nav role="navigation">
		<ul class="cd-pagination no-space">
			<li class="button"><a class="disabled" href="#0">上一页</a></li>
			<li><a class="current" href="#0">1</a></li>
			<li><a href="#0">2</a></li>
			<li><a href="#0">3</a></li>
			<li><a href="#0">4</a></li>
			<li><span>...</span></li>
			<li><a href="#0">20</a></li>
			<li class="button"><a href="#0">下一页</a></li>
		</ul>
		</nav>
		<div class="fanhui">
			<a href="http://www.baidu.com/"><button
					class="button button_border" data-button="blue">返回首页</button></a>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery.min.js"></script>
</body>
</html>
