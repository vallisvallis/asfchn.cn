<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
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
<title>会员单位详细信息</title>
</head>
<body>
<table class="table table-striped table-hover" id="ListTB">
								<thead>
									<tr>

										<th>会员单位名称</th>
										<th>会员单位号</th>
										<th>负责人 <i class="fa fa-sort"></i></th>
										<th>负责人手机号 <i class="fa fa-sort"></i></th>
										<th>地址</th>
										<th>会员单位类型 <i class="fa fa-sort"></i></th>
										<th>会费状态 <i class="fa fa-sort"></i></th>
										<th>会费缴纳时间</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pageInfo.list}" var="hxTeam">
										<tr>
											<td>${hxTeam.fullname }</td>
											<td>${hxTeam.sn }</td>
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
											<td>会费状态</td>
											<td>${hxTeam.eligibledat}</td>
											
										</tr>

									</c:forEach>
								</tbody>
							</table>
</body>
</html>