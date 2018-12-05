<%@ page language="java" contentType="text/html; charset=UTF-8"  import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<meta name="keywords" content="">
<meta name="description" content="">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.min.css">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min_EDT.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css"
	href="css/plugins/iCheck/custom.css">
	<title>添加新闻</title>
	</head>
	<body>

	<div align="center" background-image="">
	<h1>发布新闻</h1>
	<form action="" name="newsForm"    class="form-horizontal" role="form">
	
	<table>
	<tr>
	<td>新闻标题：</td>
	<td><input type="text" name="title" placeholder="请输入名称"></td>
	</tr>
	<tr>
	<td>文章类型：</td>
	<td><select name="type" style="width: 172px; ">
	<option value=""></option>
	<option value="1">新闻</option>
	<option value="2">公告</option>
	</select></td>
	</tr>
	<tr>
	<td>发布人</td>
	<td><input type="text" name="manager" placeholder="请输入名称"></td>
	</tr>	
	</table>
	<hr>
	<textarea rows="50%" cols="80%" name="content">${news.content }</textarea>
	<hr>

	
<!--  	会费到期时间：<input type="datetime-local" name="eligibledat"><br>-->	
	
	<div class="form-group" align="center">
		<div >
			<button type="submit" class="btn btn-default" onclick="addNews()" align="center">确定添加</button>
		</div>
	</div>
	
	</form>
	</div>
	 <script type="text/javascript">
	function addNews(){
	var form = document.forms[0];
	form.action = "<%=basePath%>addNews";
	form.method="post";
	form.submit();
	}	
	</script>
	</body>
	</html>