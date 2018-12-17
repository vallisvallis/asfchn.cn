<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  
    <div align="center">
    <!--   <span class="button-dropdown button-dropdown-primary" data-buttons="dropdown">
    <button class="button button-primary button-large">
      <i class="fa fa-bars"></i> 查看此组别所有人
    </button>
    <ul class="button-dropdown-list is-below">-->
    <c:forEach items="${thisMatchGroups}" var="matchGroup">
       <li style="text-align:left"><a href="showJoinPeopleWhoHasSelect?matchid=${matchId }&matchListId=${matchListId}&matchgroup=${matchGroup.id}&rid=${rid}">${matchGroup.groupage}</a></li>
    </c:forEach>
   <!--   </ul>
  </span>-->
    <div>${match },${matchListId},${matchGroup.id},${matchGroup.groupage}</div>
    </div>
  </body>
</html>
