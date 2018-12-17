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

<script type="text/javascript">
	function showjoinInfoButton(){
	var form = document.forms[0];
	form.action = "<%=basePath%>showjoinInfoButton";
		form.method = "post";
		form.submit();
	}
</script>

 
</head>

<body>
	<div align="center">
	<h1>${joinMatchTeam.matchname }</h1>
		<form action="" name="showJoinInfo" class="form-horizontal" role="form">
		
		<table  >
		<tr>
		<th>单位名称：</th>
		<th colspan="2">${joinMatchTeam.blongteamname }</th>
		
		<th>队伍名称：</th>
		<th>${joinMatchTeam.teamname }</th>
		
		<td>打印时间：</td>
		
		<td>${joinMatchTeam.addtime }</td>
		
		</tr>
		</table> 
		<table border="1px">
		<tr>
		<td>职务：</td>
		<td>姓名：</td>
		<td>性别：</td>
		<td>会员号：</td>
		<td>比赛项目：</td>
		<td>组别：</td>
		<td>团体项目：</td>
		<td>频率：</td>		
		</tr>
		<c:forEach items="${thisTeamjoinPeoples }" var="joinMatchTeamPeople">
		<tr>
		<td>${joinMatchTeamPeople.jobname }</td> 
		<td>${joinMatchTeamPeople.name }</td>
		<td>${joinMatchTeamPeople.peoplegender }</td>
		<td>${joinMatchTeamPeople.peoplesn }</td>
		<td>${joinMatchTeamPeople.joinmatchlistinname}</td>
		<td>${joinMatchTeamPeople.gage}</td>
		<td>
		<c:choose>
		<c:when test="${joinMatchTeamPeople.isteammatchlist eq '1'} ">是</c:when>
		<c:when test="${joinMatchTeamPeople.isteammatchlist eq '2'} ">否</c:when>
		
		</c:choose>
		
		</td>
		<td>${joinMatchTeamPeople.pinlv }</td>
		
		</tr>
		</c:forEach>	
		<tr>
		<th colspan="8" height="30">备注:<input type="text" name="joinMatchTeam.prop1"></th>
		</tr>	
		</table>
		
		
		
			<div class="form-group" align="center">
				<div>
					<button type="submit" class="btn btn-default"
						onclick="showjoinInfoButton()" align="center">提交</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
