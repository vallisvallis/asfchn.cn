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
  <div><h4>${thisJoinMatchTeamPeople.name }的遥控特技飞机（P3A-2） 打分表</h4></div>
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
   
   

    起飞程序:裁判评分<input type="text" name="score1one1rid"><br>
    因麦曼:裁判评分<input type="text" name="score2one1rid"><br>
    内筋斗 3 个:裁判评分<input type="text" name="score3one1rid"> <br>
    倒飞直线 :裁判评分<input type="text" name="score4one1rid"><br>
    礼帽:裁判评分<input type="text" name="score5one1rid"><br>
    双向横滚:裁判评分<input type="text" name="score6one1rid"><br>
    眼镜蛇横滚 :裁判评分<input type="text" name="score7one1rid"><br>
    双因麦曼:裁判评分<input type="text" name="score8one1rid"><br>
    垂直上升横滚:裁判评分<input type="text" name="score9one1rid"><br>
    着陆程序:裁判评分<input type="text" name="score10one1rid"><br>
    
    </td>
   
    </tr>
    <tr>
    <td>第二轮成绩</td>
     <td>
  
     

    起飞程序:裁判评分<input type="text" name="score1two1rid"><br>
    因麦曼:裁判评分<input type="text" name="score2two1rid"><br>
    内筋斗 3 个:裁判评分<input type="text" name="score3two1rid"> <br>
    倒飞直线 :裁判评分<input type="text" name="score4two1rid"><br>
    礼帽:裁判评分<input type="text" name="score5two1rid"><br>
    双向横滚:裁判评分<input type="text" name="score6two1rid"><br>
    眼镜蛇横滚 :裁判评分<input type="text" name="score7two1rid"><br>
    双因麦曼:裁判评分<input type="text" name="score8two1rid"><br>
    垂直上升横滚:裁判评分<input type="text" name="score9two1rid"><br>
    着陆程序:裁判评分<input type="text" name="score10two1rid"><br>
   
   
   </td>
    </tr>
    
    
 
    
 
   <!--<td><input type="text" name="score3"></td>-->
   
    </table>
    
   
   
    <button type="submit" onclick="getMarking5()">确定打分</button>
 
   
 
   
    </form>
    </div>
   
    <script type="text/javascript">
    function getMarking5(){
    	var form =document.forms[0];
    	form.action="<%=basePath%>getMarking5";
    	form.method="post";
    	form.submit();}  
    </script>
  </body>
</html>