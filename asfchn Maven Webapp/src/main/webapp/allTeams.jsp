<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>

<!DOCTYPE HTML>
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
  <div align="center"><h3 >所有参赛队伍</h3></div>
  
   <div class="table-responsive">
							<table class="table table-striped table-hover" id="ListTB">
								<thead>
									<tr>

										<th>队伍名字</th>
										<th>会员单位</th>
										<th>添加时间</th>
										<th>参加比赛名称</th>
										<th>详情</th>
										<th>删除</th>
										
										<!-- <th>详情</th> -->
										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${matchteams}" var="JoinMatchTeam">
										<tr>
											<td>${JoinMatchTeam.teamname }</td>
											<td>${JoinMatchTeam.blongteamname }</td>
											 <td><fmt:formatDate value="${JoinMatchTeam.addtime }" pattern="yyyy-MM-dd HH:mm:ss" />										
											</td>
											<td>${JoinMatchTeam.matchname }</td>
											
											<td><a href="getJoinTeamInfoInAllTeam?id=${JoinMatchTeam.id }">详情</a></td>
											<td><a href="delJoinTeamWhichIsSuccess?id=${JoinMatchTeam.id }">删除</a></td>
											
											
											
											<!--  <td><a href="${path}/showTeamIntroduce?id=${hxTeam.id}">详情</a></td>-->
											
										</tr>

									</c:forEach>
								</tbody>
							</table>
							<div align="center"><a href="createAllQR">生成参赛人员二维码</a></div>
						</div>
						
  </body>
</html>
