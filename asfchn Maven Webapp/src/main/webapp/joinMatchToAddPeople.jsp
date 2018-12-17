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
	function joinMatchInfoShowButton(){
	var form = document.forms[0];
	form.action = "<%=basePath%>joinMatchInfoShowButton";
		form.method = "post";
		form.submit();
	}
</script>

 
</head>

<body>
	<div align="center">
	<h1>${joinMatchTeam.matchname }</h1>
	<h1>${joinMatchTeam.teamname }</h1>
	
	
		<form action="" name="addJoinMatchTeamPeople" class="form-horizontal" role="form">
		<input type="hidden" name="id" value="${joinMatchTeam.id }">
		<table  class="table" style="width:500px">
		<tr>
		<td>职务</td>
		<td>姓名</td>
		<td>比赛项目</td>
		<td>组别</td>
		<td>是否团体项目</td>
		<td>频率</td>
		
		</tr>
		
		<%int i=0; %>
		<c:forEach items="${ thisTeamPeoples}">
		<tr>
		<!--  <td><input type="checkbox" value="${matchJob.join }+${hxPeople.id }+${matchList.id }+${matchGroup.id }+${isNo.id }" name="peopleInfoInString"></td>-->
		<td>
		  <select name="joinMatchTeamPeople[<%=i %>].job" id="job">
		  <option ></option>
		<c:forEach items="${ allMatchJobs}" var="matchJob">
		
		<option  value="${ matchJob.id}" >${matchJob.occ }</option>
		
		</c:forEach>
		
		</select>
		
		</td>
		<td>
		<select name="joinMatchTeamPeople[<%=i %>].peopleid">
		<option ></option>
		<c:forEach items="${ thisTeamPeoples}" var="hxPeople">
		
		<option value="${hxPeople.id }">${hxPeople.name }</option>
		</c:forEach>
		
		</select>
		
		</td>
		
		<td>
		<select name="joinMatchTeamPeople[<%=i %>].joinmatchlist">
		<option ></option>
		<c:forEach items="${ allMatchLists}" var="matchList">
		
		<option value="${matchList.id }">${matchList.name }</option>
		</c:forEach>
		
		</select>
		</td>
		<td>
		<select name="joinMatchTeamPeople[<%=i %>].gage">
		<option ></option>
		<c:forEach items="${allMatchGroups}" var="matchGroup">
		
		<option value="${matchGroup.id }">${matchGroup.groupage }</option>
		</c:forEach>
		</select>
		
		</td>
		<td><select name="joinMatchTeamPeople[<%=i %>].isteammatchlist" >
		<option ></option>
		<c:forEach items="${allIsNo }" var="isNo">
		
		<option value="${isNo.id }">${isNo.isno}</option>
		
		</c:forEach>

		
		
		</select></td>
		<td><input type="text" name="joinMatchTeamPeople[<%=i %>].pinlv" value="2.4GHz"></td>
		<td><input type="hidden" name="joinMatchTeamPeople[<%=i %>].matchid" value="${joinMatchTeam.matchid  }"></td>
		
		
		</tr>
	<%i+=1; %>
		</c:forEach>
		
		
		</table>
		备注：<input type="text" name="prop1">
			<div class="form-group" align="center">
				<div>
					<button type="submit" class="btn btn-default"
						onclick="joinMatchInfoShowButton()" align="center">下一步</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
