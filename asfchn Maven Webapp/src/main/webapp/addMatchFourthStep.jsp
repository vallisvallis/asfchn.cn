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
 <form action="" name="addMatch"     class="form-horizontal" role="form">
 <h1>${match}需要的职务</h1>
 <table>

 <tr>
 <td> <input type="checkbox"></td>
 <td>教练</td>
 <td>
 <select>
 <option></option>
 <option>1个</option>
 <option>2个</option>
 </select> 
 </td>
 </tr> 
 <tr>
 <td> <input type="checkbox"></td>
 <td>领队</td>
 <td>
 <select>
 <option></option>
 <option>1个</option>
 <option>2个</option>
 </select> 
 </td>
 </tr> 
 <tr>
 <td> <input type="checkbox"></td>
 <td>运动员</td>
 <td>
 <select>
 <option></option>
 <option>1个</option>
 <option>2个</option>
 </select> 
 </td>
 </tr> 
 </table> 

 <div class="form-group" align="center">
		<div >
			<button type="submit" class="btn btn-default" onclick="addFeeType()" align="center">下一步</button>
		</div>
	</div>
 </form> 
  </div>
  </body>
</html>

