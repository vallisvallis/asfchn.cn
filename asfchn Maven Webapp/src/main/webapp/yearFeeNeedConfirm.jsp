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
  <h3>待确定的会费申请</h3>
   <div class="table-responsive" >
							<table class="table table-striped table-hover" id="ListTB">
								<thead>
									<tr>

										<th>缴纳单位或个人</th>
										<th>费用类型</th>
										<th>申请时间</th>
										<th>会费状态</th>
										<th>提交人</th>
										<th>价格</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pageInfo.list }" var="fee">
										<tr>
											<td>${fee.teamname }${fee.peoplename }</td>
											<td>
											<c:choose>
											<c:when test="${fee.feetype  eq '1'}"><p>企业会费</p></c:when>
											<c:when test="${fee.feetype  eq '2'}"><p>学校会费</p></c:when>
											<c:when test="${fee.feetype  eq '3'}"><p>协会会费</p></c:when>										
											<c:when test="${fee.feetype  eq '4'}"><p>学生会费</p></c:when>										
											<c:when test="${fee.feetype  eq '5'}"><p>成人会费</p></c:when>										
											</c:choose>
										
											</td>
											
											<td><fmt:formatDate value="${fee.addtime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
											<td>
											<c:choose>
											<c:when test="${fee.feestatus  eq '1'}">航协已拒绝</c:when>
											<c:when test="${fee.feestatus  eq '2'}">已申请未审核</c:when>
											<c:when test="${fee.feestatus  eq '3'}">已申请待审核</c:when>
											<c:when test="${fee.feestatus  eq '3'}">已申请已审核</c:when>
											<c:when test="${fee.feestatus  eq '4'}">航协已通过</c:when>										
											</c:choose>
										</td>
											<td>${fee.manager }</td>
											<td>${fee.price }</td>
											<td> <a href="updateFeeStatusYes?id=${fee.id }">同意</a> <a href="updateFeeStatusNo?id=${fee.id }">拒绝</a>  </td>

										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>
						
							 </div>
  </body>
</html>
