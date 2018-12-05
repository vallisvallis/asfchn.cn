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
<title>${hxPeople.name}</title>
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
    <h2 align="center">${hxPeople.name }</h2>
    <form action="" name="hxPeopleFrom" >
	<hr>
	<input type="hidden" name="id" value="${hxPeople.id }" >	
	<input type="hidden" name="sn" value="${hxPeople.sn }" >
	<input type="hidden" name="password" value="${hxPeople.password }" >	
	<input type="hidden" name="belongteam" value="${hxPeople.belongteam }" ><br>	
	<table class="table table-striped table-hover" id="ListTB" >
	<tr>
	<th>会员名称</th>
	<th><input type="text" name="name" value="${hxPeople.name }" >*</th>
	<th> </th>
	<th> </th>
	</tr>
	<tr>
	<th>会员注册地</th>
	<th><input type="text" name="city" value="${hxPeople.city }" disabled="disabled" >*</th>
	<th> </th>
	<th> </th>
	</tr>
	<tr>
	<th>会员性别：</th>
	<th><input type="text" name="gender" value="${hxPeople.gender }"disabled="disabled" ></th>
	<th> </th>
	<th> </th>
	</tr>
	</table>
	<hr>
	<table class="table table-striped table-hover" id="ListTB" align="center">
	
	<tr>
	<th>出生日期</th>
	<th><input type="text" name="homepage" value="${hxPeople.birthday }" disabled="disabled"></th>
	<th>会费缴纳时间</th>
	<th><fmt:formatDate value="${hxPeople.eligibledat }" pattern="yyyy-MM-dd HH:mm:ss" /></th>
	</tr>
	
	<tr>
	<th>年龄</th>
	<th><input type="text" name="age" value="${hxPeople.age }" disabled="disabled"></th>
	<th> </th>
	<th> </th>
	
	<!--  <th>修改会费到期时间</th>
	<th><input type="datetime-local" name="eligibledat" value="${hxPeople.eligibledat}" ></th>	-->
	
	</tr><tr>
	<th>身份证号:</th>
	<th><input type="text" name="certnumber" value="${hxPeople.certnumber }" disabled="disabled"></th>
	<th>住址：</th>
	<th><input type="text" name="prop4" value="${hxPeople.prop4 }" ></th>
	</tr><tr>
	
	
	<th>手机号：</th>
	<th><input type="text" name="prop3" value="${hxPeople.prop3 }" ></th>
	<th> </th>
	<th> </th>
	</tr><tr>
	
	<th>备注</th>
	<th><input type="text" name="prop1" value="${hxPeople.prop1 }" disabled="disabled" ></th>
	<th> </th>
	<th> </th>
	</tr><tr>
	
	<th>所属会员单位：</th>
	<th><input type="text" name="teamname" value="${hxPeople.teamname }" disabled="disabled"></th>
	<th> </th>
	<th> </th>
	
	</tr>
	
	</table>
	<hr>
	
	<hr>
	<div align="center" >
	<h1>个&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;简&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;介</h1>
	<textarea  cols="100%" rows="10%">${hxTeam.introduce }</textarea><br>
	<input type="submit" value="修改" onclick="updatemyself()">
	</div>
	</form>
	</div>
	<script type="text/javascript">
	function updatemyself(){
	 var form = document.forms[0];
        form.action = "<%=basePath %>updatemyself";
        form.method = "post";
        form.submit();
	
	
	
	}
	
	
	
	
	</script>
	
	
	<!-- <form>
	<input type="hidden" name="id" value="${hxTeam.id }">
	<span align="center">
	<p>会员单位名称</p><input type="text" name="fullname" value="${hxTeam.fullname }"></span>
	</form> -->
	
</body>

</html>
