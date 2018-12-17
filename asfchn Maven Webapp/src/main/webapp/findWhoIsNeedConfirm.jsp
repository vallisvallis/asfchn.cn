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
  <h3>报考驾照数量</h3>
   <div class="table-responsive" >
							<table class="table table-striped table-hover" id="ListTB">
								<thead>
									<tr>

										<th>名称</th>
										<th>会员号</th>
										
										<th>驾照类别 </th>
										<th>驾照等级</th>
										
										<th>缴费状态</th>
										<th>更改为已交费</th>
										
										
										<!--  <th>详情</th>-->
										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${joinExamPeoplesn}" var="joinExamPeople">
										<tr>
											<td>${joinExamPeople.name }</td>
											<td>${joinExamPeople.peoplesn }</td>
											
											<td>${joinExamPeople.examtype }</td>
											<td>${joinExamPeople.examtypelevel }</td>
											<td>
											<c:choose>
											<c:when test="${joinExamPeople.feestatus eq 0 }">未报名</c:when>
											<c:when test="${joinExamPeople.feestatus eq 1 }">已报名代缴费</c:when>
											<c:when test="${joinExamPeople.feestatus eq 2 }">已交费</c:when>
											
											</c:choose>
											
											</td>
											<td><a href="${path}/changejoinexamPeopelStuatsToYesInHx?id=${joinExamPeople.id}" title="将会员的驾照考试费状态更改为已付费">更改</a></td>
											
											
											<!--  <td><a href="${path}/toUpdateHxPeople?id=${hxPeople.id}">详情</a></td>-->
											
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>
						
							 </div>
  </body>
</html>
