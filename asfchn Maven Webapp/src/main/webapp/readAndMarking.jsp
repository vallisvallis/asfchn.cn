<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'readAndMarking.jsp' starting page</title>
    
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
  <form action="">
  
  <input type="hidden" name="rid" value="${rid }">
  <input type="text" name="str" autofocus="autofocus">
  <button type="submit" onclick="StrightQr()">扫码打分</button>
  </form>
  
  <script type="text/javascript">
  function StrightQr(){
	  var form=document.forms[0];
	 	 form.action = "<%=basePath%>StrightQr";
		form.method="post";
		form.submit();
  }
  </script>
  </body>
</html>
