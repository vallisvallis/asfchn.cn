<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
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
	<script type="text/javascript">
	function addFeeType(){
	var form = document.forms[0];
	form.action = "<%=basePath%>addFeeType";
	form.method="post";
	form.submit();
	}	
	</script>
  </head>
  <body>
  <div align="center">
 <form action="" name="addFeeTypeform"     class="form-horizontal" role="form">
 <input type="hidden" name="id">
 <table>
 <tr>
 <th>费用名称</th>
 <th>费用</th>
 </tr>
 <tr>
 <td><input type="text" name="feetype"></td>
 <td><input type="text" name="price"></td>
 </tr>
 </table>
 <div class="form-group" align="center">
		<div >
			<button type="submit" class="btn btn-default" onclick="addFeeType()" align="center">确定添加</button>
		</div>
	</div>
 </form> 
  </div>
  </body>
</html>
