<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'UpdateFeeType.jsp' starting page</title>
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
  <form action="" name="updateFeeType"  class="form-horizontal" role="form">
    <input type="hidden" value="${feetype.id}" name="id" >
    <table>
    <tr>
    <td>名称</td>
    <td>价格</td>    
    </tr>
    <tr>
    <td><input type="text" value="${feetype.feetype }" name="feetype"></td>
    <td><input type="text" value="${feetype.price }" name="price"></td>
    </tr>
   
    </table>
    
   
    
    
    <button type="submit" class="btn btn-default" onclick="UpdateFeeType()" align="center">确定</button>
    </form>
    </div>
    
    <script type="text/javascript">
    function UpdateFeeType(){
    var form =document.forms[0];
    form.action="<%=basePath%>UpdateFeeType";
   	form.method="post";
	form.submit();
    }
    	
   
    </script>
  </body>
</html>
