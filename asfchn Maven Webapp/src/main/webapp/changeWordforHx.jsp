<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript">
function changeHxPassword(){
var form =document.forms[0];


form.action="<%=basePath %>changeHxPassword";
form.method="post";
form.submit();

}


</script>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tochangeword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
  </head>
  
  <body>
   <div align="center">
   <div>修改${manager.sn }的密码</div>
   <form action="" name="changeWord"    class="form-horizontal" role="form">
   <input type="hidden" name="id" value="${manager.id }">
   <table>
 <!--   <tr>
    <th>您的会员名为：</th>
   <th><input type="text" value="${hxTeam.fullname }" disabled="disabled"></th>
   </tr>-->
    <tr>
   <th>请输入你的旧密码：</th>
   <th><input type="text" name="password"  ></th>
   </tr>
    <tr>
   <th>请输入你的新密码：</th>
   <th><input type="text" name="newPassword" ></th>
   </tr>
    <tr>
   <th>请输入你的新密码：</th>
   <th><input type="text" name="newPassword2" ></th>
   </tr>
   </table>
   <div class="form-group" align="center">
		<div >
			<button type="submit" class="btn btn-default" onclick="changeHxPassword()" align="center">确定修改</button>
		</div>
	</div>
   </form></div>
   
  </body>
</html>
