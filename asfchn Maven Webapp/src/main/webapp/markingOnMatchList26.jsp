<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'markingOnMatchList1.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div align="center">
		<div>
			<h4>${thisJoinMatchTeamPeople.name }的遥控牵引滑翔机（P3B）打分表</h4>
		</div>
		<form action="">
			<input type="hidden" name="id"> <input type="hidden"
				value="${thisJoinMatchTeamPeople.id }" name="joinpeopleid">
			<input type="hidden" value="${thisJoinMatchTeamPeople.teamid }"
				name="teamid"> <input type="hidden"
				value="${thisJoinMatchTeamPeople.peoplesn}" name="sn"> <input
				type="hidden" value="${thisJoinMatchTeamPeople.teamname}"
				name="jointeamname"> <input type="hidden"
				value="${thisJoinMatchTeamPeople.name}" name="name"> <input
				type="hidden" value="${rid}" name="rid">
			<!-- <input type="text"  value="${referee.id }" name="refereeid" disabled="disabled"> -->
			<table border="1px">
				<tr>
					<td>会员号</td>
					<td>${thisJoinMatchTeamPeople.peoplesn}</td>
				</tr>
				<tr>
					<td>会员单位</td>
					<td>${thisJoinMatchTeamPeople.teamname}</td>
				</tr>
				<tr>
					<td>会员名称</td>
					<td>${thisJoinMatchTeamPeople.name}</td>
				</tr>
				<tr>
					<td>第一轮成绩</td>


					<td>留空时间: <input type="text" name="min1">分<input type="text" name="second1">秒
						着陆定点：<input type="text" name="oneturnpointmeter">米

					</td>
				</tr>
				<tr>
					<td>第二轮成绩</td>
					<td>留空时间：<input type="text" name="min2">分<input type="text" name="second2">秒
						着陆定点：<input type="text" name="twoturnpointmeter">米
					</td>
					<!--<td><input type="text" name="score3"></td>-->
				</tr>
			</table>

			<button type="submit" onclick="getMarking3()">确定打分</button>



		</form>
	</div>

	<script type="text/javascript">
	
    function getMarking3(){
    	var form =document.forms[0];
    	form.action="<%=basePath%>getMarking3";
		
			form.method = "post";
			form.submit();
		}
	</script>
</body>
</html>