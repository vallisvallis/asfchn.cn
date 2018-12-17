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
  <div><h4>${thisJoinMatchTeamPeople.name }的室内电动线操纵飞机空战  打分表</h4></div>
    <form action="" >
    <input type="hidden" name="id" >
    <input type="hidden" value="${thisJoinMatchTeamPeople.id }" name="joinpeopleid" >
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
    <c:when test="${thisPeopleScore.score161 eq null}"><input type="text" name="score161"  style="width:75px">分数</c:when>
    <c:when test="${!(thisPeopleScore.score161 eq null)}">${thisPeopleScore.score161}</c:when>
    </c:choose>
    </td>
    </tr>
    <tr>
    <td>第二轮成绩</td>
     
    <td>
  <c:choose>
   
   
   <c:when test="${(thisPeopleScore.score162 eq null)|| thisPeopleScore.score162 eq '0.0'}"><input type="text" name="score162" style="width:75px">分数</c:when>
   <c:when test="${!(thisPeopleScore.score162 eq '0.0')&&!(thisPeopleScore.score162 eq null)}">${thisPeopleScore.score162}</c:when>
   
   </c:choose>
   </td>
    </tr>
    
    
    
   
   
   <!--<td><input type="text" name="score3"></td>-->
    
    </table>
    <c:choose>
   
   
   <c:when test="${(thisPeopleScore.score162 eq null)|| thisPeopleScore.score162 eq '0.0'}"><button type="submit" onclick="getMarking16()">确定打分</button></c:when>
   <c:when test="${!(thisPeopleScore.score162 eq '0.0')&&!(thisPeopleScore.score162 eq null)}"> <a href="readAndMarking?refereeid=${rid}">扫码打分</a></c:when>
   
   </c:choose>
    
    </form>
    </div>
   
    <script type="text/javascript">
    function getMarking16(){
    	var form =document.forms[0];
    	form.action="<%=basePath%>getMarking16";
    	form.method="post";
    	form.submit();}  
    </script>
  </body>
</html>