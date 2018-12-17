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
  <h3>${hxTeam.fullname }的缴费记录</h3>
   <div class="table-responsive" >
							<table class="table table-striped table-hover" id="ListTB">
								<thead>
									<tr>

										<th>会员单位名称</th>
										<th>费用类型</th>
										<th>申请时间</th>
										<th>会费状态</th>
										<th>提交人</th>
										<th>价格</th>
										
										
										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pageInfo.list }" var="fee">
										<tr>
											<td>${fee.team }</td>
											<td>
											<c:choose>
											<c:when test="${fee.feetype  eq '1'}"><p>企业会费</p></c:when>
											<c:when test="${fee.feetype  eq '2'}"><p>学校会费</p></c:when>
											<c:when test="${fee.feetype  eq '3'}"><p>协会会费</p></c:when>
											
											
										
											</c:choose>
											
											
											
											</td>
											
											<td><fmt:formatDate value="${fee.addtime }" pattern="yyyy-MM-dd" /></td>
											<td>
											<c:choose>
											<c:when test="${fee.feestatus  eq '1'}">航协已拒绝</c:when>
											<c:when test="${fee.feestatus  eq '2'}">已申请未审核</c:when>
											<c:when test="${fee.feestatus  eq '3'}">已申请待审核</c:when>
											<c:when test="${fee.feestatus  eq '3'}">已申请已审核</c:when>
											
											
										
											</c:choose>
											
											
											
											</td>
											<td>${fee.manager }</td>
											<td>${fee.price }</td>
											
											
											
											
											
										
											
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="row">
							
							<div class="col-sm-3 text-left">
								共 <span class="text-danger">${pageInfo.total} </span>条
							</div>
							 </div>
							 </div>
  </body>
</html>
