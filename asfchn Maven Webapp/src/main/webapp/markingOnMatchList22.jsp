<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'markingOnMatchList1.jsp' starting page</title>
    
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
  <div align="center">
  <div><h4>${thisJoinMatchTeamPeople.name }的遥控双机分离定点（P3S，双人组） 打分表</h4></div>
    <form action="" >
    <input type="hidden" name="id" >
    <input type="hidden" value="${thisJoinMatchTeamPeople.peopleid }" name="joinpeopleid" >
    <input type="hidden" value="${thisJoinMatchTeamPeople.teamid }" name="teamid" >
    <input type="hidden" value="${thisJoinMatchTeamPeople.peoplesn}" name="sn" >
    <input type="hidden" value="${thisJoinMatchTeamPeople.teamname}" name="jointeamname" >
    <input type="hidden"  value="${thisJoinMatchTeamPeople.name}" name="name" >
    <input type="hidden"  value="${rid}" name="rid" >
    <!-- <input type="text"  value="${referee.id }" name="refereeid" disabled="disabled"> -->
    <table border="1px">
    <tr>
    <td>会员号</td>
    <td>${thisJoinMatchTeamPeople.peoplesn}</td>
    </tr>
    <tr>
    <td>会员单位</td>
     <td>${thisJoinMatchTeamPeople.teamname}</td>
    </tr>
    <tr>
    <td>会员名称</td>
     <td>${thisJoinMatchTeamPeople.name}</td>
    </tr>
    <tr>
    <td>第一轮成绩</td>
    
    <td>
   
    <c:choose>
    <c:when test="${thisPeopleScore.score221 eq null}">
    主机着陆分<input type="text" name="str1" style="width:75px"><br>
    子机留空时间分<input type="text" name="str2" style="width:75px"><br>
    子机着陆定点分<input type="text" name="str3" style="width:75px"><br>
    主机飞行时间分<input type="text" name="str4" style="width:75px"><br>
    
    
    
    </c:when>
    <c:when test="${!(thisPeopleScore.score221 eq null)}">${thisPeopleScore.score221}</c:when>
    </c:choose>
    </td>
 
    </tr>
    <tr>
    <td>第二轮成绩</td>
       
      <td>
  <c:choose>
   
   
   
   <c:when test="${(thisPeopleScore.score222 eq null)|| thisPeopleScore.score222 eq '模型飞机主机着陆分:0.0,子机留空时间分:0.0,子机着陆定点分:0.0,主机飞行时间分:0.0'}">主机着陆分<input type="text" name="str6" style="width:75px"><br>
    子机留空时间分<input type="text" name="str7" style="width:75px"><br>
    子机着陆定点分<input type="text" name="str8" style="width:75px"><br>
    主机飞行时间分<input type="text" name="str9" style="width:75px">
    </c:when>
   <c:when test="${!(thisPeopleScore.score222 eq '模型飞机主机着陆分:0.0,子机留空时间分:0.0,子机着陆定点分:0.0,主机飞行时间分:0.0')&&!(thisPeopleScore.score222 eq null)}">${thisPeopleScore.score222}
    </c:when>
   
   </c:choose>
   </td>
    </tr>
   
 
   <!--<td><input type="text" name="score3"></td>-->
    
    </table>
     <c:choose>
   
   
   
   <c:when test="${(thisPeopleScore.score222 eq null)|| thisPeopleScore.score222 eq '模型飞机主机着陆分:0.0,子机留空时间分:0.0,子机着陆定点分:0.0,主机飞行时间分:0.0'}"> <button type="submit" onclick="getMarking22()">确定打分</button>
    </c:when>
   <c:when test="${!(thisPeopleScore.score222 eq '模型飞机主机着陆分:0.0,子机留空时间分:0.0,子机着陆定点分:0.0,主机飞行时间分:0.0')&&!(thisPeopleScore.score222 eq null)}">
    </c:when>
   
   </c:choose>
   
    </form>
    </div>
   
    <script type="text/javascript">
    function getMarking22(){
    	var form =document.forms[0];
    	form.action="<%=basePath%>getMarking22";
    	form.method="post";
    	form.submit();}  
    </script>
  </body>
</html>