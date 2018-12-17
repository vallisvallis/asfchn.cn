<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
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
  <h3>所有具有赛事</h3>
   <div class="table-responsive" >
							<table class="table table-striped table-hover" id="ListTB">
								<thead>
									<tr>

										<th>赛事名称</th>										
										<th>负责人 </th>
										<th>联系电话 </th>
										<th>地址</th>
										<th>会员单位类型 </th>
										
										
										<th>详情</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pageInfo.list }" var="hxTeam">
										<tr>
											<td>${hxTeam.fullname }</td>
											
											<td>${hxTeam.managername }</td>
											<td>${hxTeam.managermoblie }</td>
											<td>${hxTeam.address }</td>
											<td>
											<c:choose>
											<c:when test="${hxTeam.orgtype eq 'Q'}">企业</c:when>
											<c:when test="${hxTeam.orgtype eq 'X'}">学校</c:when>
											<c:when test="${hxTeam.orgtype eq 'H'}">协会</c:when>											
											</c:choose>							
											</td>
											
											<td><a href="${path}/showTeamIntroduceInIndex?id=${hxTeam.id}">介绍</a></td>
											
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>
						
							<div class="col-sm-3 text-left">
								共 <span class="text-danger">${pageInfo.total} </span>条，第 <span
									class="text-danger">${pageInfo.pageNum} </span> 页
							</div>
							 </div>
  </body>
</html>
