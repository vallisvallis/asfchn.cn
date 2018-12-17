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
    
    <title>My JSP 'markingOnthisPeopleScore.jsp' starting page</title>
    
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
  <div><h4>
<c:choose>
<c:when test="${thismanlistid ==1 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score1 }</span><br><span>第二轮${thisPeopleScore.score2}</span></p>

</c:when>


<c:when test="${thismanlistid ==2 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score21 }</span><br><span>第二轮${thisPeopleScore.score22}</span></p>

</c:when>
<c:when test="${thismanlistid ==3 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score31 }</span><br><span>第二轮${thisPeopleScore.score32}</span></p>

</c:when>
<c:when test="${thismanlistid ==4 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score41 }</span><br><span>第二轮${thisPeopleScore.score42}</span></p>

</c:when>
<c:when test="${thismanlistid ==5 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score51 }</span><br><span>第二轮${thisPeopleScore.score52}</span></p>

</c:when>
<c:when test="${thismanlistid ==6 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score61 }</span><br><span>第二轮${thisPeopleScore.score62}</span></p>

</c:when>
<c:when test="${thismanlistid ==7 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score71 }</span><br><span>第二轮${thisPeopleScore.score72}</span></p>

</c:when>
<c:when test="${thismanlistid ==8 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score81 }</span><br><span>第二轮${thisPeopleScore.score82}</span></p>

</c:when>
<c:when test="${thismanlistid ==9 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score91 }</span><br><span>第二轮${thisPeopleScore.score92}</span></p>

</c:when>
<c:when test="${thismanlistid ==10 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score101 }</span><br><span>第二轮${thisPeopleScore.score102}</span></p>

</c:when>
<c:when test="${thismanlistid ==11 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score111 }</span><br><span>第二轮${thisPeopleScore.score112}</span></p>

</c:when>
<c:when test="${thismanlistid ==12 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score121 }</span><br><span>第二轮${thisPeopleScore.score122}</span></p>

</c:when>
<c:when test="${thismanlistid ==13 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score131 }</span><br><span>第二轮${thisPeopleScore.score132}</span></p>

</c:when>
<c:when test="${thismanlistid ==14 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score141 }</span><br><span>第二轮${thisPeopleScore.score142}</span></p>

</c:when>
<c:when test="${thismanlistid ==15 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score151 }</span><br><span>第二轮${thisPeopleScore.score152}</span></p>

</c:when>
<c:when test="${thismanlistid ==16 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score161 }</span><br><span>第二轮${thisPeopleScore.score162}</span></p>

</c:when>
<c:when test="${thismanlistid ==17 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score171 }</span><br><span>第二轮${thisPeopleScore.score172}</span></p>

</c:when>
<c:when test="${thismanlistid ==18 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score181 }</span><br><span>第二轮${thisPeopleScore.score182}</span></p>

</c:when>
<c:when test="${thismanlistid ==19}">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score191 }</span><br><span>第二轮${thisPeopleScore.score192}</span></p>

</c:when>
<c:when test="${thismanlistid ==20}">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score201 }</span><br><span>第二轮${thisPeopleScore.score202}</span></p>

</c:when>
<c:when test="${thismanlistid ==21}">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score211 }</span><br><span>第二轮${thisPeopleScore.score212}</span></p>

</c:when>
<c:when test="${thismanlistid ==22}">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score221 }</span><br><span>第二轮${thisPeopleScore.score222}</span></p>

</c:when>
<c:when test="${thismanlistid ==23 }">

 <p>姓名：${thisPeopleScore.peoplename }<br><span>第一轮${thisPeopleScore.score231 }</span><br><span>第二轮${thisPeopleScore.score232}</span></p>

</c:when>
</c:choose>
  </h4>
  </div>
    <p>请将扫码设备对准<span style="font-weight: bold">${thisPeopleScore.peoplename }</span>的二维码</p>
    <form action="">
    <input type="hidden" name="peopleid" value="${thisPeopleScore.peopleid}">
     <input type="hidden" name="rid" value="${rid }">
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
    <td><input type="text" name="score1" value="${ thisPeopleScore.score1}" disabled="disabled"></td>
   
 <td><input type="text" name="score2" value="${ thisPeopleScore.score2}" disabled="disabled"></td>
    <td><input type="text" name="score3" value="${ thisPeopleScore.score3}" disabled="disabled"></td> 
    </tr>
    </table>
    <button type="submit" onclick="">确定打分</button>
    
    
    </div>
    <script type="text/javascript">
    function getMarking1(){
    	var form =document.forms[0];
    	form.action="<%=basePath%>";
    	form.method="post";
    	form.submit();}  
    </script>
     -->
  </body>
</html>
