<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
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
  <div align="center" >
  <h3 >${joinMatchTeam.blongteamname }的所有参赛队伍</h3>
   <div class="table-responsive">
							<table class="table table-striped table-hover" id="ListTB">
								<thead>
									<tr>

										<th>队伍名字</th>
										<th>会员单位</th>
										<th>添加时间</th>
										<th>参加比赛名称</th>
										<th>审核状态</th>
										<th>详情</th>
										<!-- <th>批量生成二维码</th>-->
										<!-- <th>详情</th> -->
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${joinMatchTeams}" var="JoinMatchTeam">
										<tr>
											<td>${JoinMatchTeam.teamname }</td>
											<td>${JoinMatchTeam.blongteamname }</td>
											 <td><fmt:formatDate value="${JoinMatchTeam.addtime }" pattern="yyyy-MM-dd " />										
											</td>
											<td>${JoinMatchTeam.matchname }</td>
											<td>
											<c:choose>
											<c:when test="${JoinMatchTeam.isconfirm eq 1}">未审核</c:when>
											<c:when test="${JoinMatchTeam.isconfirm eq 2}"><span style="color:green;">审核通过</span></c:when>
											<c:when test="${JoinMatchTeam.isconfirm eq 3}"><span style="color:red;"><a href="changeMyJoinTeam?id=${ JoinMatchTeam.id}" style="color:red;">审核不通过（点击此处修改）</a> </span></c:when>
		</c:choose>
											</td>
											<td><a href="showMyTeamInfo?id=${JoinMatchTeam.id }" title="最终样式">详情</a></td>
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
