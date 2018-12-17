<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%  
     String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/"; 
%>  


<!DOCTYPE HTML >
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
	function addMatchFirstStepButton(){
	var form = document.forms[0];
	form.action = "<%=basePath%>addMatchFirstStepButton";
	form.method="post";
	form.submit();
	}	
	
	
	
	</script>
  </head>
 
  <body>
  <div align="center">
 <form action="" name="addMatch"     class="form-horizontal" role="form">
 <input type="hidden" name="id">
 <table>
 <tr>
 <td>赛事名称</td>
 <td><input type="text" name="name"></td>

 </tr>

 <tr>
 <td>比赛报名开始时间</td>
 <td><input type="date" name="start" ></td>
 </tr>
 <tr>
 <td>比赛报名结束时间</td>
 <td><input type="date" name="end" ></td>
 </tr>
 <tr>
 <td>比赛开始时间</td>
 <td><input  type="date" name="startReport" ></td>
 </tr>
 <tr>
 <td>比赛结束时间</td>
 <td><input type="date"   name="endReport"></td>
 </tr><tr>
 <td>比赛地址</td>
 <td><input type="text"   name="address"></td>
 </tr>
 </table> 
 <h2>赛事详情</h2>
<textarea rows="30%" cols="30%" name="introduce"></textarea>
 <div class="form-group" align="center">
		<div >
			<button type="submit" class="btn btn-default" onclick="addMatchFirstStepButton()" align="center">下一步</button>
		</div>
	</div>
 </form> 
  </div>
  </body>
</html>
