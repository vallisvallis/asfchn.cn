<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'sendFeeToHx.jsp' starting page</title>
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
   <img alt="请扫描此二维码" src="${path }/images/pay3.jpg">
   <p>${price } 价格</p>   
   	<table class="table table-striped table-hover" id="ListTB">
	
								<tbody>
								<tr>
								<td>价格总计为：</td>
								<td>${price }<td>
								</tr>
							<c:forEach items="${hxPeoplelist }" var="hxPeople">
									<tr>
										<td>会员名字</td>
											<td>会员号</td>										
										</tr>
										<tr>
											<td>${hxPeople.name}</td>
											<td>${hxPeople.sn}</td>
										</tr>
			
										</c:forEach>
								
							</table>
							 <p><a href="messageIsYearFeeSuccessforPeople?peopleList=${peopleList }">已扫码支付，提交到航协</a></p>
   
 </div>
  </body>
</html>
