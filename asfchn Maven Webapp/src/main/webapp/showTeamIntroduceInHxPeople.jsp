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
<title>${hxTeam.fullname}</title>
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
    <form action="" name="hxTeamFrom" >
	<hr>
	<input type="hidden" name="id" value="${hxTeam.id }" ><br>	
	<table class="table table-striped table-hover" id="ListTB" >
	<tr>
	<th>会员单位名称</th>
	<th><input type="text" name="fullname" value="${hxTeam.fullname }" disabled="disabled">*</th>
	<th> </th>
	<th> </th>
	</tr>
	<tr>
	<th>会员单位所在城市</th>
	<th><input type="text" name="city" value="${hxTeam.city }" disabled="disabled">*</th>
	<th> </th>
	<th> </th>
	</tr>
	<tr>
	<th>会员单位类型</th>
	<th><input type="text" name="orgtype" value="${hxTeam.orgtype }" disabled="disabled">(Q为企业、X为学校、H为协会)</th>
	<th> </th>
	<th> </th>
	</tr>
	</table>
	<hr>
	<table class="table table-striped table-hover" id="ListTB" align="center">
	
	<tr>
	<th>会员单位官网</th>
	<th><input type="text" name="homepage" value="${hxTeam.homepage }" disabled="disabled"></th>
	<th>会费缴纳时间</th>
	<th><fmt:formatDate value="${hxTeam.eligibledat }" pattern="yyyy-MM-dd HH:mm:ss" /></th>
	</tr>
	
	<tr>
	<th>负责人</th>
	<th><input type="text" name="managername" value="${hxTeam.managername }" disabled="disabled"></th>
	<th></th>
	<th></th>
	<!--  <th>修改会费到期时间</th>
	<th><input type="datetime-local" name="eligibledat" value="${hxTeam.eligibledat}"></th>	-->
	
	</tr><tr>
	<th>负责人手机号</th>
	<th><input type="text" name="managermoblie" value="${hxTeam.managermoblie }" disabled="disabled"></th>
	<th>训练单位</th>
	<th><input type="text" name="trainingcenter" value="${hxTeam.trainingcenter }" disabled="disabled">（若无请勿填）</th>
	</tr><tr>
	<th>会员单位邮箱</th>
	<th><input type="text" name="email" value="${hxTeam.email }"></th>
	<th>飞行营地</th>
	<th><input type="text" name="flyingcamp" value="${hxTeam.flyingcamp }" disabled="disabled">（若无请勿填）</th>
	</tr><tr>
	<th>会员单位联系方式</th>
	<th><input type="text" name="phone" value="${hxTeam.phone }" disabled="disabled"></th>
	<th>备注1</th>
	<th><input type="text" name="prop1" value="${hxTeam.prop1 }" disabled="disabled"></th>
	</tr><tr>
	<th>会员单位地址</th>
	<th><input type="text" name="address"value="${hxTeam.address }" disabled="disabled"></th>
	<th>备注2</th>
	<th><input type="text" name="prop1" value="${hxTeam.prop2 }" disabled="disabled"></th>
	</tr>
	
	</table>
	<hr>
	
	<hr>
	<div align="center" >
	<h1>简&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;介</h1>
	<textarea  cols="100%" rows="10%" disabled="disabled">${hxTeam.introduce }</textarea><br>
	
	</div>
	</form>
	</div>
	
	
	
	
	<!-- <form>
	<input type="hidden" name="id" value="${hxTeam.id }">
	<span align="center">
	<p>会员单位名称</p><input type="text" name="fullname" value="${hxTeam.fullname }"></span>
	</form> -->
	
</body>

</html>
