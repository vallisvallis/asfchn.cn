<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showThisMatchList.jsp' starting page</title>
    
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
    
    <input type="hidden" name="id" value="${match.id }" >
    <table>
    <tr>
    <td>比赛名称:</td>
    <td><input type="text" name="name" value="${match.name }" disabled="disabled"></td>
    
    </tr>  
    <tr>
    <td>比赛地址:</td>
    <td><input type="text" name="address" value="${match.address }" disabled="disabled"></td>
    
    </tr>
    </table>
  <!--    <table>
    <tr>
    <td>${math.name }所包含的项目</td>

    </tr>
    <tr>
    <td></td>
    
    </tr>
    
    </table>-->
    
    
    <textarea rows="30%" cols="30%" name="introduce" disabled="disabled">${match.introduce }</textarea>
    
    
    </div>
  </body>
</html>
