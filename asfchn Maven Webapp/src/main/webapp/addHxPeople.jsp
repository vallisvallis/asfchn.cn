<%@ page language="java" contentType="text/html; charset=UTF-8"  import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<title>添加会员</title>
	</head>
	<body>
	<div align="center" >
	<h1>添加会员</h1>
	<form action="" name="hxPeopleFrom"    class="form-horizontal" role="form">
	  <input type="hidden" name="id" ><!--
	<input type="hidden" name="belongteam" value="${xd }">-->
	<table>
	<tr>
	<td>会员名称：</td>
	<td><input type="text" name="name" placeholder="请输入名称"></td>
	</tr>
	<tr>
	<td>会员单位名称：</td>
	<td><select name="belongteam" style="width: 172px; ">
	<c:forEach items="${allHxTeamlist }" var="hxTeam">
	<option value="${hxTeam.id }">${hxTeam.fullname }</option>
	</c:forEach>
	</select>
	</tr>
	<tr>
	<td>注册地：</td>
	<td><select name="city" style="width: 172px; ">
	<!-- <option value=""></option>-->
	<option value="郑州市">郑州市</option>
	<option value="开封市">开封市</option>
	<option value="平顶山">平顶山市</option>
	<option value="洛阳市">洛阳市</option>
	<option value="商丘市">商丘市</option>
	<option value="安阳市">安阳市</option>
	<option value="新乡市">新乡市</option>
	<option value="许昌市">许昌市</option>
	<option value="鹤壁市">鹤壁市</option>
	<option value="濮阳市">濮阳市</option>
	<option value="漯河市">漯河市</option>
	<option value="三门峡市">三门峡市</option>
	<option value="周口市">周口市</option>
	<option value="驻马店市">驻马店市</option>
	<option value="南阳市">南阳市</option>
	<option value="信阳市">信阳市</option>
	<option value="焦作市">焦作市</option>	
	<option value="济源市">济源市</option>
	</select></td>
	</tr>	
	</table>
	<hr>
	<hr>
	<table>
	<tr>
	<td>性别：</td>
	<td><input type="text" name="gender"></td>
	</tr>
	<!--  <tr>
	<td>出生日期</td>
	<td><input type="datetime-local" name="birthday"></td>
	</tr>-->
	<tr>
	<td>年龄：</td>
	<td><input type="text" name="age"></td>
	</tr>
	<tr>
	<td>身份证号:</td>
	<td><input type="text" name="certnumber"></td>
	</tr>
	<tr>
	<td>个人信息简介:</td>
	<td><textarea  name="personIntro"></textarea></td>
	</tr>
	</table>
	<hr>
	<table>
	<tr>
	<td>住址：</td>
	<td><input type="text" name="prop4"></td>
	</tr>
	<tr>
	<td>手机号：</td>
	<td><input type="text" name="prop3"></td>
	</tr>
	<tr>
	<td>备注：</td>
	<td><input type="text" name="prop1"></td>
	</tr>		
	</table>
<!--  	会费到期时间：<input type="datetime-local" name="eligibledat"><br>-->	
	
	<div class="form-group" align="center">
		<div >
			<button type="submit" class="btn btn-default" onclick="addHxPeople()" align="center">确定添加</button>
		</div>
	</div>	
	</form>
	</div>
	 <script type="text/javascript">
	function addHxPeople(){
	var form = document.forms[0];
	//var reg=/^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
	//if(reg.test($("checkCert").value))

	form.action = "<%=basePath%>addHxPeople";
	form.method="post";
	form.submit();}
	//}{alert("身份证号不合法");}	}
	</script>
	</body>