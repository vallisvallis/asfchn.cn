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
  <c:choose>
  <c:when test="${withfriendmWhoNeedtoConfirm.oneroundisconfirm eq 1 }">第一轮分数，通过${withfriendmWhoNeedtoConfirm.oneroundrid}号设备输入，输入的分数为：<span style="color:red;">${withfriendmWhoNeedtoConfirm.scoreone}</span>,请选手确认！！！
  <br> <a href="startMarking?id=${withfriendmWhoNeedtoConfirm.joinpeopleid}&rid=${withfriendmWhoNeedtoConfirm.oneroundrid}">觉得分数有误？点此返回修改</a>
  
  <div>
    <p>请将扫码设备对准<span style="font-weight: bold">${withfriendmWhoNeedtoConfirm.name }</span>的二维码</p>
    <form action="">
    <input type="hidden" name="joinpeopleid" value="${withfriendmWhoNeedtoConfirm.joinpeopleid}">
     <input type="hidden" name="peopleid" value="${hxpeople.id }">
     <input type="hidden" name="rid" value="${withfriendmWhoNeedtoConfirm.oneroundrid }">
     <input type="hidden" name="scoreid" value="${withfriendmWhoNeedtoConfirm.id }">

     
     <input type="text" name="str" autofocus="autofocus">
    
    <input type="submit" onclick="confirmScore()" >
    </form>
    </div>
    </c:when>
    <c:when test="${withfriendmWhoNeedtoConfirm.tworoundisconfirm eq 1 }">第二轮分数，通过${withfriendmWhoNeedtoConfirm.tworoundrid}号设备输入，输入的分数为：<span style="color:red;">${withfriendmWhoNeedtoConfirm.scoretwo}</span>,请选手确认！！！
    
    <br> <a href="startMarking?id=${joinMatchTeamPeople.id}&rid=${withfriendmWhoNeedtoConfirm.tworoundrid}">觉得分数有误？点此返回修改</a>
  
  <div>
    <p>请将扫码设备对准<span style="font-weight: bold">${withfriendmWhoNeedtoConfirm.name }</span>的二维码</p>
    <form action="">
    <input type="hidden" name="joinpeopleid" value="${withfriendmWhoNeedtoConfirm.joinpeopleid}">
     <input type="hidden" name="peopleid" value="${hxpeople.id }">
     <input type="hidden" name="rid" value="${withfriendmWhoNeedtoConfirm.tworoundrid }">
     <input type="hidden" name="scoreid" value="${withfriendmWhoNeedtoConfirm.id }">

     
     <input type="text" name="str" autofocus="autofocus">
    
    <input type="submit" onclick="confirmScore()" >
    </form>
     </div>
    
    </c:when>
  </c:choose>
  
  
 <!--  <div><h4>${twoptionsmatch.name }的第一轮成绩为${twoptionsmatch.scoreone} <br>第二轮成绩为${twoptionsmatch.scoretwo}  <br>总成绩为${twoptionsmatch.finalscore }</h4></div>  -->
 
  
  
  
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
  
 
  </body>
</html>
