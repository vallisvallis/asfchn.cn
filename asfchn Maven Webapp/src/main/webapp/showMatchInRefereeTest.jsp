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
    <title>showMatchInReferee.jsp</title>
    
    <link rel="stylesheet" href="css/buttons.css">
         <link href="css/font-awesome.min.css" rel="stylesheet">
         <script src="js/jquery-1.12.3.min.js"></script>
  
       <script type="text/javascript" src="js/buttons.js"></script>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
 <!--  <script type="text/javascript">
  function showThisMatchListInReferee(){
  var form=document.forms[0];
  form.action="<%=basePath%>showThisMatchListInReferee";
  form.method="post";
  form.submit();
  }
  </script> -->
  <body>
  <!--   <form   >
    <select name="id" >
    <c:forEach items="${matchs}" var="match">
    <option value="${match.id}">${match.name}</option> 
    </c:forEach>
    </select>
    <button type="submit"  onclick="showThisMatchListInReferee()">查看此赛事的所有项目</button>
    <!--  <a href="showThisMatchListInReferee?id=${match.id }">查看此赛事的所有项目</a> -->
<!--  </form> -->
    
   <!--   <div>
  <span class="button-dropdown button-dropdown-primary" data-buttons="dropdown">
    <button class="button button-primary button-large">
      <i class="fa fa-bars"></i> 查看此赛事的所有项目
    </button>
 
    <ul class="button-dropdown-list is-below">
    <c:forEach items="${matchs }" var="match">
        <li><a href="showThisMatchListInReferee?id=${match.id }"><i class="fa fa-heart-o"></i> ${match.name }</a></li>
    
    </c:forEach>
  
     
    
    </ul>
  </span>
    
    </div>-->
    
    <div>
  <!--  <span class="button-dropdown button-dropdown-primary" data-buttons="dropdown">
    <button class="button button-primary button-large">
      <i class="fa fa-bars"></i>查看此赛事的所有项目
    </button>

    <ul class="button-dropdown-list is-below">-->
    <c:forEach items="${matchs }" var="match">
    
    <!--  <li style="text-align: center">--><a href="showThisMatchListInReferee?id=${match.id }&rid=${rid}"  ><!--<i class="fa fa-flag"> </i >-->${match.name }</a><!-- </li>-->
    </c:forEach>
     
    
    <!--  </ul>
  </span>-->

 
</div>
    
  </body>
</html>
