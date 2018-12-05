<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>${hxTeam.fullname }</title>
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


</head>
<body>
 <div class="table-responsive">
    <h2 align="center">${hxTeam.fullname }</h2>
    
	
	
	
	
	<hr>
	<div align="center" >
	<h1>简&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;介</h1>
	<textarea disabled="disabled" cols="100%" rows="10%">${hxTeam.introduce }</textarea><br>
	
	
	</div>
	</div>
	
	
	<!-- <form>
	<input type="hidden" name="id" value="${hxTeam.id }">
	<span align="center">
	<p>会员单位名称</p><input type="text" name="fullname" value="${hxTeam.fullname }"></span>
	</form> -->
	
</body>

</html>
