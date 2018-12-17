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
        </style>
  </head>
  
  <body>
  <div align="center">
  <div><h4>${thisJoinMatchTeamPeople.name }的“美嘉欣”遥控四轴飞行器竞时赛打分表</h4></div>
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
    <tr> <td >编号</td> <td colspan="2">${thisJoinMatchTeamPeople.peoplesn}</td>    </tr>
    <tr> <td >单位</td> <td colspan="2">${thisJoinMatchTeamPeople.teamname}</td>    </tr>
    <tr>  <td >名称</td> <td colspan="2">${thisJoinMatchTeamPeople.name}</td></tr>   
    <tr> <td >第一轮成绩</td> <td colspan="1">完成</td> <td colspan="1"> 失败</td>  </tr>
    <tr> <td>起飞、自转   </td> <td><input type="radio" name="score1one"style="width:75px"  value="20"></td><td><input type="radio" name="score1one" style="width:75px" value="0"></td>  </tr>
    <tr> <td> 穿越圆环	</td><td><input type="radio" name="score2one" style="width:75px" value="30"></td>	<td><input type="radio" name="score2one" style="width:75px"value="0"></td>  </tr>
    <tr> <td> 空中翻滚</td><td><input type="radio" name="score3one" style="width:75px" value="10"></td><td><input type="radio" name="score3one" style="width:75px"value="0"></td>  </tr>
    <tr> <td>  穿越天井</td><td><input type="radio" name="score4one"style="width:75px"  value="50"></td><td><input type="radio" name="score4one" style="width:75px"value="0"></td>  </tr>
    <tr> <td> 空中翻滚</td><td><input type="radio" name="score5one" style="width:75px" value="10"></td><td><input type="radio" name="score5one" style="width:75px" value="0"></td>  </tr>
    <tr> <td> 冲出隧道</td><td><input type="radio" name="score6one" style="width:75px" value="50"></td><td><input type="radio" name="score6one" style="width:75px" value="0"></td>  </tr>
    <tr> <td>着陆</td><td colspan="2">30<input type="radio" name="score7one" style="width:75px" value="30">10<input type="radio" name="score7one" style="width:75px" value="10">0<input type="radio" name="score7one" style="width:75px"value="0"></td>  </tr>
    <tr> <td>时间</td><td colspan="2"><input type="text" name="score8one" style="width:75px"> </td> </tr>
    
   <!--   起飞、自转<input type="radio" name="score1one" style="width:75px"> 分数<br>
   分数<br>
    空中翻滚<input type="text" name="score3one" style="width:75px">分数<br>
    穿越天井<input type="text" name="score4one" style="width:75px">分数<br>
    空中翻滚<input type="text" name="score5one" style="width:75px">分数<br>
    冲出隧道<input type="text" name="score6one" style="width:75px">分数<br>
    着陆<input type="text" name="score7one" style="width:75px">分数<br>
    时间<input type="text" name="score8one" style="width:75px">秒-->
 
   <tr> <td>第二轮成绩</td><td colspan="1">完成</td> <td colspan="1"> 失败</td>  </tr>
    
   <!-- 
   起飞、自转<input type="text" name="score1two" style="width:75px">分数<br>
    穿越圆环<input type="text" name="score2two" style="width:75px">分数<br>
    空中翻滚<input type="text" name="score3two" style="width:75px">分数<br>
    穿越天井<input type="text" name="score4two" style="width:75px">分数<br>
    空中翻滚<input type="text" name="score5two" style="width:75px">分数<br>
    冲出隧道<input type="text" name="score6two" style="width:75px">分数<br>
    着陆<input type="text" name="score7two" style="width:75px">分数<br>
    时间<input type="text" name="score8two" style="width:75px">秒-->
  <tr> <td>起飞、自转   </td> <td><input type="radio" name="score1two" style="width:75px" value="20"></td><td><input type="radio" name="score1two" style="width:75px"value="0"></td>  </tr>
    <tr> <td> 穿越圆环	</td><td><input type="radio" name="score2two" style="width:75px" value="30"></td>	<td><input type="radio" name="score2two" style="width:75px"value="0"></td>  </tr>
    <tr> <td> 空中翻滚</td><td><input type="radio" name="score3two" style="width:75px" value="10"></td><td><input type="radio" name="score3two" style="width:75px"value="0"></td>  </tr>
    <tr> <td>  穿越天井</td><td><input type="radio" name="score4two" style="width:75px" value="50"></td><td><input type="radio" name="score4two" style="width:75px"value="0"></td>  </tr>
    <tr> <td> 空中翻滚</td><td><input type="radio" name="score5two" style="width:75px" value="10"></td><td><input type="radio" name="score5two" style="width:75px"value="0"></td>  </tr>
    <tr> <td> 冲出隧道</td><td><input type="radio" name="score6two" style="width:75px" value="50"></td><td><input type="radio" name="score6two" style="width:75px"value="0"></td>  </tr>
    <tr> <td>着陆</td><td colspan="2">30<input type="radio" name="score7two" style="width:75px" value="30">10<input type="radio" name="score7two" style="width:75px"value="10">0<input type="radio" name="score7one" style="width:75px"value="0"></td>  </tr>
    <tr> <td>时间</td><td colspan="2"><input type="text" name="score8two" style="width:75px"></td> </tr>
  
  
  
    
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