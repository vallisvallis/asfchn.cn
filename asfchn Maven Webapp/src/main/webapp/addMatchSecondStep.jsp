<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"        + request.getServerName() + ":" + request.getServerPort()  
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
	function addMatchSecondStepButton(){
	var form = document.forms[0];
	form.action = "<%=basePath%>addMatchSecondStepButton";
	form.method="post";
	form.submit();
	}	
	
	
	
	</script>
  </head>
 
  <body>
  <div align="center">
 <form action="" name="addMatch"     class="form-horizontal" role="form">
 <input type="hidden" value="${matchToAdd.id}" name=id>
 <h1>${matchToAdd.name}需要的项目</h1>
 <table border="1px">
 <tr>
 <td>${matchToAdd.name}需要的项目</td></tr>
 
 <tr>
 <c:forEach items="${allMatchList }" var="matchList">
 <tr><td><input type="checkbox" value="${matchList.id }" name="matchList">${matchList.name }</td></tr>
 
 </c:forEach>
 
 </tr>
 </table>
 <hr>
 
 <table>
 
  <tr>
 <td>${matchToAdd.name}需要的组别</td></tr>
 <tr>
 <c:forEach items="${allMatchGroups }" var="matchGroup">
 <tr><td><input type="checkbox" value="${matchGroup.id }" name="matchGroup">${matchGroup.groupage }</td></tr>
 
 </c:forEach>
 
 </tr>
 
 
 </table>
 <hr>
 <table>
 
  <tr>
 <td>${matchToAdd.name}需要的职务</td></tr>
 <tr>
 <c:forEach items="${allMatchJobs }" var="matchJob">
 <tr><td><input type="checkbox" value="${matchJob.id }" name="matchJob">${matchJob.occ } 所支持的最大数<input type="text" name="num" ></td></tr>
 
 </c:forEach>
 
 </tr>
 
 
 </table>
 <!--  
 <table>
  <tr>
 <td>此比赛需要的赛事项目</td>
 <td>
 1
 
 
 </td>
 
 <c:forEach items="${allMatchList }" var="matchList">
 <tr><input type="checkbox" value="${matchList.id }">${matchList.name }</tr>
 
 </c:forEach>
 </tr>
  <tr>
 
 </table> -->
 <div class="form-group" align="center">
		<div >
			<button type="submit" class="btn btn-default" onclick="addMatchSecondStepButton()" align="center">下一步</button>
		</div>
	</div>
 </form> 
  </div>
  </body>
</html>
