<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'QRcheck.jsp' starting page</title>
    
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
   <a href="createQR">生成二维码</a> <br>
   <form action="" name="testQQ">
   <input type="text" name="id" >
  <button type="submit" onclick="testQQQ()">确定</button>
   </form>  
   <script type="text/javascript">
function testQQQ(){
var form=document.forms[0];
form.action="<%=basePath%>testQQQ";
form.method="post";
form.submit();
}


</script>
   
  </body>
</html>
