<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
	String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>
<!DOCTYPE HTML>
<html>
  <head> 
    <title> 'showMatchInReferee.jsp'</title>
     
    <link rel="stylesheet" href="css/buttons.css">
         <link href="css/font-awesome.min.css" rel="stylesheet">
         <script src="js/jquery-1.12.3.min.js"></script>
       <script type="text/javascript" src="js/buttons.js"></script>
  </head>

  <body>
   <!--<div>
    <c:forEach  items="${peopleWhoHasSelect}" var="joinMatchTeamPeople">
    <p>  ${joinMatchTeamPeople.name} </p>
    </c:forEach>
    </div>-->
    
    
    <div>
    <div>此项目参加人数为${fn:length(peopleWhoHasSelect)}</div>
    <table class="table table-striped table-hover">
    <tr>
    <td>姓名</td>
    <td>参加项目</td>
    <td>所属会员单位</td>
    
    <td>操作</td>
    </tr>
    
    <c:forEach items="${peopleWhoHasSelect}" var="joinMatchTeamPeople">
    <tr>
    <td>${joinMatchTeamPeople.name}</td>
    <td>${joinMatchTeamPeople.peoplesn}</td>
    <td>${joinMatchTeamPeople.teamname }</td>
  	
    <td><a href="redayQr?id=${joinMatchTeamPeople.id}&rid=${rid}">打分</a></td>
   </tr>
    </c:forEach>
    
   
    
    </table>
    
    
    </div>
    
    
    
    
  </body>
</html>
