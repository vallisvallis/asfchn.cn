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
	function changeSuccesss(){
	var form = document.forms[0];
	form.action = "<%=basePath%>changeSuccesss";
		form.method = "post";
		form.submit();
	}
</script>

 
</head>
<body>

	<div align="center">
	<h1>${joinMatchTeam.matchname }</h1>
	<h1>${joinMatchTeam.teamname }</h1>
	
	
		<form action=""  class="form-horizontal" role="form">
		<input type="hidden" name="id" value="${joinMatchTeam.id }">
		队伍名称：<input type="text" name="teamname" value="${joinMatchTeam.teamname}">
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
		<c:forEach items="${ joinMatchTeamPeopless}" var="joinMatchTeamPeople">
		<tr>
		<!--  <td><input type="checkbox" value="${matchJob.join }+${hxPeople.id }+${matchList.id }+${matchGroup.id }+${isNo.id }" name="peopleInfoInString"></td>-->
		<td>
		  <select name="joinMatchTeamPeople[<%=i %>].job" id="job">
		  		  <option  value="${joinMatchTeamPeople.job }">
		  		  <c:choose>
		  		  
		  		  <c:when test="${joinMatchTeamPeople.job eq 1}">教练</c:when>
		  		  <c:when test="${joinMatchTeamPeople.job eq 2}">领队</c:when>
		  		  <c:when test="${joinMatchTeamPeople.job eq 3}">运动员</c:when>
		  		  </c:choose>
		  		 </option>
		  		 
		  	
		  	<option ></option>
	
		<c:forEach items="${ allMatchJobs}" var="matchJob">
		
		<option  value="${ matchJob.id}" >${matchJob.occ }</option>
		
		</c:forEach>
		
		</select>
		
		</td>
		<td>
		<select name="joinMatchTeamPeople[<%=i %>].peopleid">
			 <option value="${joinMatchTeamPeople.peopleid}">${joinMatchTeamPeople.name}</option>
		<option ></option>
	
		<c:forEach items="${ thisTeamPeoples}" var="hxPeople">
		
		<option value="${hxPeople.id }">${hxPeople.name }</option>
		</c:forEach>
		
		</select>
		
		</td>
		
		<td>
		<select name="joinMatchTeamPeople[<%=i %>].joinmatchlist">
		 <option value="${joinMatchTeamPeople.joinmatchlist }">${joinMatchTeamPeople.joinmatchlistinname }</option>
		<option ></option>
			
		<c:forEach items="${ allMatchLists}" var="matchList">
		
		<option value="${matchList.id }">${matchList.name }</option>
		</c:forEach>
		
		</select>
		</td>
		<td>
		<select name="joinMatchTeamPeople[<%=i %>].gage">
		<option value="${joinMatchTeamPeople.gage}">
		<c:choose>
		<c:when test="${joinMatchTeamPeople.gage eq 1}">小学男</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 2}">小学女</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 3}">初中男</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 4}">初中女</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 5}">高中男</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 6}">高中女</c:when>
		</c:choose>
		
		
		</option>
		<option ></option>
			 
		<c:forEach items="${allMatchGroups}" var="matchGroup">
		
		<option value="${matchGroup.id }">${matchGroup.groupage }</option>
		</c:forEach>
		</select>
		
		</td>
		<td><select name="joinMatchTeamPeople[<%=i %>].isteammatchlist" >
		 <option value="${joinMatchTeamPeople.isteammatchlist }">
		 <c:choose>
		 <c:when test="${joinMatchTeamPeople.isteammatchlist eq 1}">是</c:when>
		 <c:when test="${joinMatchTeamPeople.isteammatchlist eq 2}">否</c:when>
		 </c:choose>
		</option>
		<option ></option>
		
		<c:forEach items="${allIsNo }" var="isNo">
		
		<option value="${isNo.id }">${isNo.isno}</option>
		
		</c:forEach>

		
		
		</select></td>
		<td><input type="text" name="joinMatchTeamPeople[<%=i %>].pinlv" value="2.4GHz"></td>
		
		<td><input type="hidden" name="joinMatchTeamPeople[<%=i %>].matchid" value="${joinMatchTeam.matchid  }"></td>
		<td><input type="hidden" name="joinMatchTeamPeople[<%=i %>].id" value="${joinMatchTeamPeople.id  }"></td>
		<td><input type="hidden" name="joinMatchTeamPeople[<%=i %>].matchname" value="${joinMatchTeamPeople.matchname  }"></td>
		<td><input type="hidden" name="joinMatchTeamPeople[<%=i %>].score1" value="${joinMatchTeamPeople.score1  }"></td>
		<td><input type="hidden" name="joinMatchTeamPeople[<%=i %>].score2" value="${joinMatchTeamPeople.score2  }"></td>
		<td><input type="hidden" name="joinMatchTeamPeople[<%=i %>].score3" value="${joinMatchTeamPeople.score3  }"></td>
		
		<td><input type="hidden" name="joinMatchTeamPeople[<%=i %>].teamname" value="${joinMatchTeamPeople.teamname  }"></td>
	
		
		
		</tr>
	<%i+=1; %>
		</c:forEach>
		
		
		</table>
		备注：<input type="text" name="prop1">
			<div class="form-group" align="center">
				<div>
					<button type="submit" class="btn btn-default"
						onclick="changeSuccesss()" align="center">修改完毕并提交</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>