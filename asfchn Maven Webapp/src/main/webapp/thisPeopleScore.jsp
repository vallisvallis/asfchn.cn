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
  <div><h1>打分成功</h1></div> 
  <div><h4>${twoptionsmatch.name }的第一轮成绩为${twoptionsmatch.scoreone} <br>第二轮成绩为${twoptionsmatch.scoretwo}  <br>总成绩为${twoptionsmatch.finalscore }</h4></div> 
  <a href="startMarking?id=${joinMatchTeamPeople.id}&rid=${twoptionsmatch.rid}">觉得分数有误？点此返回修改</a>
  
  <div>
    <p>请将扫码设备对准<span style="font-weight: bold">${twoptionsmatch.name }</span>的二维码</p>
    <form action="">
    <input type="hidden" name="joinpeopleid" value="${twoptionsmatch.joinpeopleid}">
     <input type="hidden" name="peopleid" value="${hxpeople.id }">
     <input type="hidden" name="rid" value="${twoptionsmatch.rid }">
     <input type="hidden" name="twoid" value="${twoptionsmatch.id }">
     
     <input type="text" name="str" autofocus="autofocus">
    
    <input type="submit" onclick="confirmScore()" >
    </form>
        <script type="text/javascript">
    function confirmScore(){
    	var form = document.forms[0];
    	//var reg=/^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
    	//if(reg.test($("checkCert").value))
    	form.action = "<%=basePath%>confirmScore";
    	form.method="post";
    	form.submit();}
    
    
    </script>
  </div>
  </div>
   <!--   <input type="hidden" name="id" >
     <input type="hidden" value="${thisJoinMatchTeamPeople.peopleid }" name="peopleid" >
    <input type="hidden" value="${thisJoinMatchTeamPeople.teamid }" name="teamid" >
    <!-- <input type="text"  value="${referee.id }" name="refereeid" disabled="disabled"> -->
   <!--  <table>
    <tr>
    <td>会员号</td>
    <td>会员单位</td>
    <td>会员名称</td>
    <td>第一轮成绩</td>
    <td>第二轮成绩</td>
    <td>总成绩</td>
    </tr>
    <tr>
    <td><input type="text" value="${thisJoinMatchTeamPeople.peoplesn}" name="peoplesn"  disabled="disabled"></td>
    <td><input type="text" value="${thisJoinMatchTeamPeople.teamname}" name="jointeamname" disabled="disabled"></td>
    <td><input type="text"  value="${thisJoinMatchTeamPeople.name}" name="peoplename" disabled="disabled"></td>
    <td><input type="text" name="score1" value="${ matchlist1.score1}" disabled="disabled"></td>
   
 <td><input type="text" name="score2" value="${ matchlist1.score2}" disabled="disabled"></td>
    <td><input type="text" name="score3" value="${ matchlist1.score3}" disabled="disabled"></td> 
    </tr>
    </table>
    <button type="submit" onclick="">确定打分</button>
    
    
    </div>
  
     -->
  </body>
</html>
