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
      <i class="fa fa-bars"></i> 查看此项目的所有组别
    </button>
    <ul class="button-dropdown-list is-below">-->
    <c:forEach items="${thisMatchMatchLists}" var="matchList">
       <li  style="text-align:left"><a href="showThisMatchListAllGroup?id=${matchList.id }&matchId=${match}&rid=${rid}" >${matchList.name}</a></li>
    </c:forEach>
   <!--   </ul>
  </span>-->
    
 
    </div>
  </body>
</html>
