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
  <div><h4>${thisJoinMatchTeamPeople.name }的双桨共轴直升机救援赛 打分表</h4></div>
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
    <tr>
    <td>会员名称</td>
     <td>${thisJoinMatchTeamPeople.name}</td>
    </tr>
    <tr>
    <td>第一轮成绩</td>
     <td>
   
  <input type="text" name="score1one"  style="width:75px">救援得分<br>
  <input type="text" name="score2one" style="width:75px">着陆得分
    
   
    </td>
    </tr>
    <tr>
    <td>第二轮成绩</td>
     <td>
<input type="text" name="score1two" style="width:75px">救援得分<br>
<input type="text" name="score2two" style="width:75px">着陆得分
   
   
   </td>
    </tr>
    
   
   
   
   
   
   <!--<td><input type="text" name="score3"></td>-->
    
    </table>
   <button type="submit" onclick="getMarking2()">确定打分</button>
  
   
    </form>
    </div>
   
    <script type="text/javascript">
    function getMarking2(){
    	var form =document.forms[0];
    	form.action="<%=basePath%>getMarking2";
    	form.method="post";
    	form.submit();}  
    </script>
  </body>
</html>