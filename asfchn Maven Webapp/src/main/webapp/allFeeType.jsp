<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  <div class="table-responsive">
  
    <table class="table table-striped table-hover" id="ListTB"  align="center">
								<thead>
									<tr>
										<th>费用名称</th>
										<th>费用</th>
										<th>操作</th>										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pageInfo.list }" var="feeType">
										<tr>
											<td>${feeType.feetype}</td>
											<td><input type="text" value="${feeType.price }" disabled="disabled"></td>											
											<!--  <td><a type="button" href="${path}/delFeeType?id=${feeType.id}">删除</a></td>	-->						
											<td><a type="button" href="${path}/toUpdateFeeType?id=${feeType.id}">修改</a></td>							
										</tr>										
										</c:forEach>																		
								</tbody>						
								</table>
								
								
								</div>
							<hr>
							<div align="center"><a type="button" href="${path}/toAddFeeType">增加费用类型</a></div>
  </body>
</html>
