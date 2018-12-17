<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'TestMySchedule.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  function TestMySchedule(){
	var form = document.forms[0];
	//var reg=/^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
	//if(reg.test($("checkCert").value))

	form.action = "<%=basePath%>TestMySchedule";
	form.method="post";
	form.submit();}
  
  </script>
  <div style="height: 201px; "></div>
  <div align="center" style="height: 186px; "><form style="height: 179px; width: 564px">
   <input type="date"  name="wlldateInweb"  style="width: 285px; height: 98px"><br>
 
  <input type="submit" onclick="TestMySchedule()" style="height:98px; width: 285px; ">
  
  </form></div>

  </body>
</html>
