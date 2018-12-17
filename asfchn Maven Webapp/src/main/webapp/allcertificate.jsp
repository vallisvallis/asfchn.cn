<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>My JSP 'showThisMatchList.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
<link rel="stylesheet" type="text/css"
	href="css/plugins/chosen/chosen.css">
	<!--<link rel="stylesheet" type="text/css" href="styles.css">-->
	 <script type="text/javascript">
	function updateMatchInHX(){
	var form = document.forms[0];
	form.action = "<%=basePath%>updateMatchInHX";
	form.method="post";
	form.submit();
	}
	</script>
  </head>
  <body style="text-align:center">
  <div align="center">
  <div class="row">
  <form class="form-horizontal">
		<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-3">
							<div class="J_menuItem">
									<div class="widget green-bg p-lg text-center">
											<div class="m-b-md">
														<h1 class="m-xs">个人证书</h1>
														<!-- <a class="m-xs box-block" href="orderNameList?id=${match.id }"></a> -->
													</div>
												</div>
											</div>
										</div>
									<div class="col-sm-3">
											<div class="J_menuItem">
												<div class="widget  yellow-bg p-lg text-center">
													<div class="m-b-md">
														<h1 class="m-xs">团体证书</h1>
														<a class="m-xs box-block" href="#">生成(暂不可用)</a>
													</div>
												</div>
											</div>
									</div>
											
									
									</div>
								</div>
							</form>
						</div>
						</div>
    <div align="center">
  <form action="">
   <input type="hidden" name="matchid" value="${match.id }">
   <table>
   <thead>
   <tr>
   <th>项目名称</th>
    <th>组别名称</th>
  <th>下载证书</th>
   </tr>
  </thead>
  <tbody>
    <tr>
   
    <td><select name="listid">
    
     <c:forEach items="${allMatchLists }" var="matchlist" >
     <option value="${ matchlist.id}">${matchlist.name } </option>
     </c:forEach>
    </select></td>
    <td><select name="gageid">
    
     <c:forEach items="${allMatchGroups }" var="matchGroup" >
     <option value="${ matchGroup.id}">${matchGroup.groupage } </option>
     </c:forEach>
    </select></td>
    <td></td>
    
   </tr>
  
  
  
  </tbody>
   
   
   </table>
   <button type="submit" class="btn btn-default"
						onclick="certificate()" align="center">准备下载</button>
   </form>
   <script type="text/javascript">
	function certificate(){
	var form = document.forms[1];
	form.action = "<%=basePath%>certificate";
		form.method = "post";
		form.submit();
	}
</script>
 
    </div>
  </body>
</html>
