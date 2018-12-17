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
  <div><h4>${thisJoinMatchTeamPeople.name }的室内电动线操纵特技（P2B-P） 打分表</h4></div>
    <form action="" >
    <input type="hidden" name="id" >
    <input type="hidden" value="${thisJoinMatchTeamPeople.id }" name="joinpeopleid" >
    <input type="hidden" value="${thisJoinMatchTeamPeople.teamid }" name="teamid" >
    <input type="hidden" value="${thisJoinMatchTeamPeople.peoplesn}" name="sn" >
    <input type="hidden" value="${thisJoinMatchTeamPeople.teamname}" name="jointeamname" >
    <input type="hidden"  value="${thisJoinMatchTeamPeople.name}" name="pname" >
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
    <c:when test="${thisPeopleScore.score151 eq null}">
  <!--   飞行风格 K=6<input type="text" name="str1" style="width:75px"><br>-->
  <!--  艺术性K-6<input type="text" name="str2" style="width:75px"><br>-->
   <!--   总体印象K-6<input type="text" name="str3" style="width:75px">-->
   <input type="text" name="score151">
    </c:when>
    <c:when test="${!(thisPeopleScore.score151 eq null)}">${thisPeopleScore.score151}</c:when>
    </c:choose>
    </td>
    </tr>
    <tr>
    <td>第二轮成绩</td>
    <td>
  <c:choose>
   <c:when test="${(thisPeopleScore.score152 eq null)|| thisPeopleScore.score152 eq '0.0'}">  
   <!--  飞行风格 K=6<input type="text" name="str4" style="width:75px"><br> -->
   <!--  艺术性K-6<input type="text" name="str5" style="width:75px"><br> -->
   <!--  总体印象K-6<input type="text" name="str6" style="width:75px"> -->
     <input type="text" name="score151">
    </c:when>
   <c:when test="${!(thisPeopleScore.score152 eq '0.0')&&!(thisPeopleScore.score152 eq null)}">${thisPeopleScore.score152}  </c:when>
   
   </c:choose>
   </td>
   <!--<td><input type="text" name="score3"></td>-->
    </tr>
    </table>
     <button type="submit" onclick="getMarking15()">确定打分</button>
    </form>
    </div>
   
    <script type="text/javascript">
    function getMarking15(){
    	var form =document.forms[0];
    	form.action="<%=basePath%>getMarking15";
    	form.method="post";
    	form.submit();}  
    </script>
  </body>
</html>