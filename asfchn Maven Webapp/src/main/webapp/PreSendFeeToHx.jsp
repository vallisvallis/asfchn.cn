<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
  <link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.min.css">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min_EDT.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css"
	href="css/plugins/iCheck/custom.css">
    <title>My JSP 'sendFeeToHx.jsp' starting page</title>
    
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
   
   <div align="center"><form action="" name="sendFeeToHx"  class="form-horizontal" role="form">
   
  
   <img alt="请扫描此二维码" src="${path }/images/pay3.jpg"  width="400px" height="400px">
    <h1 style="color:red ">请按下方提示应缴金额扫码支付</h1>
  <table class="table table-striped table-hover" id="ListTB">
    <tr>
    <th>申请单位</th>
    <th>费用类型</th>
    <th>费用价格</th>
    <th>申请时间</th>
    <th>申请人</th>
    </tr>
    
    <tr>
    <td>${hxTeam.fullname }</td>
    <td>
    <c:choose>
	<c:when test="${fee.feetype  eq '1'}">企业会费</c:when>
	<c:when test="${fee.feetype  eq '2'}">学校会费</c:when>
	<c:when test="${fee.feetype  eq '3'}">协会会费</c:when>											
</c:choose>	
    
    
    </td>
    <td>${fee.price }</td>
    <th><fmt:formatDate value="${fee.addtime }" pattern="yyyy-MM-dd HH:mm:ss" /></th>
    <td>${fee.manager }</td>
    </tr>
    
    
    </table>
   
  
   <p><a href="payTeamYearFee?id=${hxTeam.id}">已扫码支付，提交到航协</a></p>
    </form>
   
   
 </div>
  </body>
</html>
