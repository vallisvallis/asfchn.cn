<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
  String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"        + request.getServerName() + ":" + request.getServerPort()  
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
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="/asfchn Maven Webapp/src/main/webapp/js/jquery-1.11.3.min.js"></script>

  </head>
  
  <body>
  <div align="center">
  <h3>${hxTeam.fullname}中交年费的会员</h3>
   <div class="table-responsive" >
  
    
							<table class="table table-striped table-hover" id="ListTB">
								<thead>
									<tr>
										
										<th>会员名称</th>
										<th>会员号</th>
										<th>联系电话 <i class="fa fa-sort"></i></th>
										<th>地址</th>
										<th>会费缴费时间</th>																				
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${thisTeamHxPeopleWhohasPay}" var="hxPeople">
										<tr>
										
											<td>${hxPeople.name }</td>
											<td>${hxPeople.sn }</td>
											<td>${hxPeople.prop3 }</td>
											<td>${hxPeople.prop4 }</td>
											<td><fmt:formatDate value="${hxPeople.eligibledat }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
											
											
											
										</tr>

									</c:forEach>
								</tbody>
							</table>
							<div class="form-group" align="center">
		
	</div>
							
						</div>
						</div>
  </body>
</html>
