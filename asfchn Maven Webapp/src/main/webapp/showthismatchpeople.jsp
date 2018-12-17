<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'showthismatchteam.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
<link rel="stylesheet" type="text/css"
	href="css/plugins/chosen/chosen.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
   <div align="center" >
  <h3 >所有参赛人员</h3>
   <div class="table-responsive">
							<table class="table table-striped table-hover" id="ListTB">
								<thead>
									<tr>
										<th>姓名</th>
										<th>性别</th>
										<th>职务</th>
										<th>会员单位</th>
										<!--  <th>添加时间</th>-->
										<!--  <th>参加比赛名称</th>-->
										<!--  <th>详情</th>-->
										<!-- <th>批量生成二维码</th>-->
										<!-- <th>详情</th> -->
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${joinMatchTeamPeoples}" var="JoinMatchTeamPeople">
										<tr>
											<td>${JoinMatchTeamPeople.name }</td>
											<td>${JoinMatchTeamPeople.peoplegender }</td>
											<td>${JoinMatchTeamPeople.jobname }</td>
											<td>${JoinMatchTeamPeople.teamname }</td>
												<!--  <td><fmt:formatDate value="${JoinMatchTeam.addtime }" pattern="yyyy-MM-dd HH:mm:ss" />										
											</td>-->
										<!--  	<td>${JoinMatchTeamPeople.matchname }</td>-->
											
											<!--  <td><a href="showMyTeamInfo?id=${JoinMatchTeam.id }">详情</a></td>-->
											<!--   <td><a href="createAllQR?id=${JoinMatchTeam.id }">生成所有队员二维码</a></td> -->									
											<!--  <td><a href="${path}/showTeamIntroduce?id=${hxTeam.id}">详情</a></td>-->
											
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>
			</div>			
  </body>
</html>
