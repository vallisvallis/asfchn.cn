<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML >
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<meta name="keywords" content="">
<meta name="description" content="">
 <script type="text/javascript" src="js/html2canvas.js"></script>
 <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
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
<div>
	<div align="center" id="main"  >
	<h1>${joinMatchTeam.matchname }${fn:length(joinMatchTeamPeoples) }</h1>
		
		
		<table class="table  " id="ListTB">
		<tr>
		<th>单位名称：</th>
		<th colspan="2">${joinMatchTeam.blongteamname }</th>
		
		<th>队伍名称：</th>
		<th>${joinMatchTeam.teamname }</th>
		
		<td>打印时间：</td>
		
		<td>
		<fmt:formatDate value="${joinMatchTeam.addtime }" pattern="yyyy-MM-dd " />
		</td>
		
		</tr>
		</table> 
		<table  class="table ">
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
		<c:forEach items="${joinMatchTeamPeoples }" var="joinMatchTeamPeople">
		<tr>
		<td>${joinMatchTeamPeople.jobname }</td> 
		<td>${joinMatchTeamPeople.name }</td>
		<td>${joinMatchTeamPeople.peoplegender }</td>
		<td>${joinMatchTeamPeople.peoplesn }</td>
		<td>${joinMatchTeamPeople.joinmatchlistinname}</td>
		<td>
		<c:choose>
		<c:when test="${joinMatchTeamPeople.gage eq 1}">小学男</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 2}">小学女</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 3}">初中男</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 4}">初中女</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 5}">高中男</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 6}">高中女</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 7}"></c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 8}"></c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 9}"></c:when>
		
		</c:choose>
		
		</td>
		<td>
<c:choose>
<c:when test="${joinMatchTeamPeople.isteammatchlist eq 1}">是</c:when>
<c:when test="${joinMatchTeamPeople.isteammatchlist eq 1}">否</c:when>

</c:choose>		
		
		</td>
		<td>${joinMatchTeamPeople.pinlv }</td>
		
		</tr>
		</c:forEach>	
		<tr>
		<th colspan="8" height="30">备注:<input type="text" value="${joinMatchTeam.prop1 }" disabled="disabled"></th>
		</tr>	
		</table>
		
		
		
			<div class="form-group" align="center">
				<div>
					<a  href="allTeamsButton" class="btn btn-default"
						 align="center">返回</a>
					
					
				</div>
			</div>
		
	</div></div>
</body>
</html>
