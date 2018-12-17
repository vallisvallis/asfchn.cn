<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'toJoinExam.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function joinExam(){
	var form = document.forms[0];
	form.action = "<%=basePath%>joinExam";
		form.method = "post";
		form.submit();
	}
</script>
  </head>
  
  <body>

<div align="center">
<h1>2018年10月河南省ASFC遥控航空模型飞行员执照考试</h1>
<div>
<h2>请选择考试类别与等级：</h2>
<h3>考试类别：</h3>

<form action="">
<input  type="hidden" name="id" value="${hxPeople.id }">
<div>
<input type="radio" name="examtype" value="A">固定翼（A类）<br>
<input type="radio" name="examtype" value="X">多旋翼（X类）<br>
<input type="radio" name="examtype" value="C">直升机（C类）<br>


</div>
<hr>
<h3>考试等级：</h3>
<div>
<input type="radio" name="examtypelevel" value="8">八级<br>
<input type="radio" name="examtypelevel" value="7">七级<br>
<input type="radio" name="examtypelevel" value="6">六级<br>

</div>
<hr>
<div>
<button onclick="joinExam()">确定</button>
</div>
</form>
</div>
</div>

  </body>
</html>
