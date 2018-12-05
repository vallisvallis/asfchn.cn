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
  <h3>交过会费的会员</h3>
   <div class="table-responsive" >
							<table class="table table-striped table-hover" id="ListTB">
								<thead>
									<tr>

										<th>名称</th>
										<th>会员号</th>
										
										<th>联系电话 </th>
										<th>会员单位</th>
										<th>类别</th>
										<th>会费缴费日期</th>
										<th>会员状态</th>									
										<th>详情</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${peoplehasPay}" var="hxPeople">
										<tr>
											<td>${hxPeople.name }</td>
											<td>${hxPeople.sn }</td>
											
											<td>${hxPeople.prop3 }</td>
											<td>${hxPeople.teamname }</td>
													<c:choose>
											<c:when test="${hxPeople.age > 18 }"><td >成人</td></c:when>
											<c:when test="${hxPeople.age <= 18  }"><td >学生</td></c:when>
											
											</c:choose>
											<td>
											<fmt:formatDate value="${hxPeople.eligibledat}" pattern="yyyy-MM-dd " />
											
											</td>
											<td><a href="${path}/changePeopelStuatsInHx?id=${hxPeople.id}" title="将会员的状态更改为未付费">更改</a></td>
											
											
											<td><a href="${path}/toUpdateHxPeople?id=${hxPeople.id}">详情</a></td>
											
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>
						
							 </div>
  </body>
</html>
