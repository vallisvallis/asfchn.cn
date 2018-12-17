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
	function addJoinMatchTeamButton(){
	var form = document.forms[0];
	form.action = "<%=basePath%>addJoinMatchTeamButton";
		form.method = "post";
		form.submit();
	}
</script>

 
</head>

<body>
	<div align="center" >
	<h1>${hxTeam.fullname }</h1>
		<form action="" name="addJoinMatchTeam" class="form-horizontal" role="form">
		<input type="hidden" name="id">
		<input type="hidden" name="blongteam" value="${hxTeam.id }">
		<input type="hidden" name="blongteamname" value="${hxTeam.fullname }"  >
			<table class="table" style="width:500px">
			<tr>
			<td>选择需要报名的赛事</td>
			<td><select name="matchid" style="width: 90px; ">
			<c:forEach items="${allMatchs }" var="match">
			<option value="${match.id }">${match.name }</option>			
			</c:forEach>			
			</select></td>		
			</tr>
			
			<tr>
			<td>队伍名称</td>
		<!--  <td><input type="text" name="teamname" >(请输入规范队伍名称)</td>-->
		<td><select name="teamname" style="width: 90px; ">
		<option value="${hxTeam.fullname }"></option>
		<option value="一队">一队</option>
		<option value="二队">二队</option>
		<option value="三队">三队</option>
		<option value="四队">四队</option>
		
		</select></td>
			
			</tr>
			<tr><td style="color:red; font-size:10"><p>如果您单位只报名一支队伍，则队伍名称不填！</p>
<p>如果您单位报名多支队伍，则选择“一队”进行一队人员信息录入，并提交，完成“一队”报名；</p>
<p>再次进行报名，选择“二队”进行二队人员信息录入，并提交，完成“二队”报名，以此类推！</p></td>
</tr>
			<tr>
			<td>所属会员单位</td>
			<td>${hxTeam.fullname }${hxTeam.sn }</td>
			</tr>
			
			</table>
			<div class="form-group" align="center">
				<!-- <div>
					<button type="submit" class="btn btn-default"
						onclick="addJoinMatchTeamButton()" align="center">下一步</button>
				</div> -->
			</div>
		</form>
	</div>
</body>
</html>
