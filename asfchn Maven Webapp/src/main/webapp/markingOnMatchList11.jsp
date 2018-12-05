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
<style type="text/css">
            td{
                text-align: center;
            }

            table{

table-layout: fixed;
}
        </style>
  </head>
  
  <body>
  <div align="center">
  <div><h4>${thisJoinMatchTeamPeople.name }的“天戈”遥控直升机障碍赛 打分表</h4></div>
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
    <tr> <td>会员号</td> <td colspan="4">${thisJoinMatchTeamPeople.peoplesn}</td> </tr>
      <tr> <td>会员单位</td>  <td colspan="4">${thisJoinMatchTeamPeople.teamname}</td>   </tr>
    <tr>  <td>会员名称</td>  <td colspan="4">${thisJoinMatchTeamPeople.name}</td>   </tr>
    <tr><td></td> <td colspan="4">第一轮成绩</td></tr> 
    <tr><td> 起飞</td><td colspan="2" >0<input type="radio" name="score1one"   value="0"></td><td colspan="2">10 <input type="radio" name="score1one"   value="10"></td></tr>
    <tr><td>   山洞</td><td colspan="4"><input type="text" name="score2one" style="width:75px;">得分</td></tr>
   	 <tr><td> 隧道</td><td >0<input type="radio" name="score3one" value="0"></td><td >50<input type="radio" name="score3one"  value="50"></td><td >100<input type="radio" name="score3one"  value="100"></td></tr>
   	 <tr><td>	 观景</td><td colspan="4"><input type="text" name="score4one" >得分</td></tr>
   	 <tr><td>  高山</td><td>0<input type="radio" name="score5one"  value="0"></td><td>30 <input type="radio" name="score5one"  value="30"></td><td>60<input type="radio" name="score5one"  value="60"></td></tr>
   	 <tr><td> 着 陆</td><td>0<input type="radio" name="score6one"  value="0"></td><td>10<input type="radio" name="score6one" value="10"></td><td>30<input type="radio" name="score6one" value="30"></td><td>50<input type="radio" name="score6one" value="50"></td></tr>
   	 <tr><td>  时间</td><td colspan="4"><input type="text" name="score7one" >秒</td></tr>   
    <tr><td></td><td colspan="4">第二轮成绩</td>   </tr>

  <tr><td> 起飞</td><td colspan="2">0<input type="radio" name="score1two"   value="0"></td><td colspan="2">10 <input type="radio" name="score1two"   value="10"></td></tr>
    <tr><td>   山洞</td><td colspan="4"><input type="text" name="score2two" style="width:75px;">得分</td></tr>
   	 <tr><td> 隧道</td><td >0<input type="radio" name="score3two" value="0"></td><td >50<input type="radio" name="score3two"  value="50"></td><td >100<input type="radio" name="score3two"  value="100"></td></tr>
   	 <tr><td>	 观景</td><td colspan="4"><input type="text" name="score4two" >得分</td></tr>
   	 <tr><td>  高山</td><td>0<input type="radio" name="score5two"  value="0"></td><td>30 <input type="radio" name="score5two"  value="30"></td><td>60<input type="radio" name="score5two"  value="60"></td></tr>
   	 <tr><td> 着 陆</td><td>0<input type="radio" name="score6two"  value="0"></td><td>10<input type="radio" name="score6two" value="10"></td><td>30<input type="radio" name="score6two" value="30"></td><td>50<input type="radio" name="score6two" value="50"></td></tr>
   	 <tr><td>  时间</td><td colspan="4"><input type="text" name="score7two" >秒</td></tr>
    
   
   
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