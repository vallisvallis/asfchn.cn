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
  <div><h4>${thisJoinMatchTeamPeople.name }的线操纵特技飞机（P2B） 打分表</h4></div>
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
   
   
    起动&nbsp;&nbsp;<input type="text" name="score1one1rid" style="width:75px"><br>
    起飞&nbsp;&nbsp;<input type="text" name="score2one1rid" style="width:75px"><br>
    双过顶1个&nbsp;&nbsp;<input type="text" name="score3one1rid" style="width:75px"><br>
    连续内筋斗，3个<input type="text" name="score4one1rid" style="width:75px"><br>
    倒飞，两圈&nbsp;&nbsp;<input type="text" name="score5one1rid" style="width:75px">
        连续外筋斗，3个&nbsp;&nbsp;<input type="text" name="score6one1rid" style="width:75px">
            连续内方筋斗，2个&nbsp;&nbsp;<input type="text" name="score7one1rid" style="width:75px">
                连续外方筋斗，2个&nbsp;&nbsp;<input type="text" name="score8one1rid" style="width:75px">
                    连续内三角筋斗，2个&nbsp;&nbsp;<input type="text" name="score9one1rid" style="width:75px">
                        横八字，2个&nbsp;&nbsp;<input type="text" name="score10one1rid" style="width:75px">
        正方横八字&nbsp;&nbsp;<input type="text" name="score11one1rid" style="width:75px">
   竖八字，2个    &nbsp;&nbsp;<input type="text" name="score12one1rid" style="width:75px">
    竖三角八字，1个    &nbsp;&nbsp;<input type="text" name="score13on1erid" style="width:75px">
    头顶八字，2个    &nbsp;&nbsp;<input type="text" name="score14one1rid" style="width:75px">
    四叶玫瑰 1个     &nbsp;&nbsp;<input type="text" name="score15one1rid" style="width:75px">
        着陆&nbsp;&nbsp;<input type="text" name="score16one1rid" style="width:75px">
    </td>
   
    </tr>
    <tr>
    <td>第二轮成绩</td>
     <td>

  起动&nbsp;&nbsp;<input type="text" name="score1two1rid" style="width:75px"><br>
    起飞&nbsp;&nbsp;<input type="text" name="score2two1rid" style="width:75px"><br>
    双过顶1个&nbsp;&nbsp;<input type="text" name="score3two1rid" style="width:75px"><br>
    连续内筋斗，3个<input type="text" name="score4two1rid" style="width:75px"><br>
    倒飞，两圈&nbsp;&nbsp;<input type="text" name="score5two1rid" style="width:75px">
        连续外筋斗，3个&nbsp;&nbsp;<input type="text" name="score6two1rid" style="width:75px">
            连续内方筋斗，2个&nbsp;&nbsp;<input type="text" name="score7two1rid" style="width:75px">
                连续外方筋斗，2个&nbsp;&nbsp;<input type="text" name="score8two1rid" style="width:75px">
                    连续内三角筋斗，2个&nbsp;&nbsp;<input type="text" name="score9two1rid" style="width:75px">
                        横八字，2个&nbsp;&nbsp;<input type="text" name="score10two1rid" style="width:75px">
        正方横八字&nbsp;&nbsp;<input type="text" name="score11two1rid" style="width:75px">
   竖八字，2个    &nbsp;&nbsp;<input type="text" name="score12two1rid" style="width:75px">
    竖三角八字，1个    &nbsp;&nbsp;<input type="text" name="score13two1rid" style="width:75px">
    头顶八字，2个    &nbsp;&nbsp;<input type="text" name="score14two1rid" style="width:75px">
    四叶玫瑰 1个     &nbsp;&nbsp;<input type="text" name="score15two1rid" style="width:75px">
        着陆&nbsp;&nbsp;<input type="text" name="score16two1rid" style="width:75px">   </td>
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