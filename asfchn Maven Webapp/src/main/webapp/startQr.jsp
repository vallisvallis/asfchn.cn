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
    <title> </title>
     
    <link rel="stylesheet" href="css/buttons.css">
         <link href="css/font-awesome.min.css" rel="stylesheet">
         <script src="js/jquery-1.12.3.min.js"></script>
       <script type="text/javascript" src="js/buttons.js"></script>
	
  </head>

  <body>
  
   
    
   <!--  <div>
    <c:forEach  items="${peopleWhoHasSelect}" var="joinMatchTeamPeople">
    <p>  ${joinMatchTeamPeople.name} </p>

    </c:forEach>
    
    
    </div>-->
    
    <script type="text/javascript">
    function StartQr(){
    	var form = document.forms[0];
    	//var reg=/^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
    	//if(reg.test($("checkCert").value))
    	form.action = "<%=basePath%>StartQr";
    	form.method="post";
    	form.submit();}
    
    
    </script>
    <div>
    <p>请将扫码设备对准<span style="font-weight: bold">${joinMatchTeamPeople.name }</span>的二维码</p>
    <form action="">
    
    <input type="hidden" name="rid" value="${rid}">
    <input type="hidden" name="jpid" value="${joinMatchTeamPeople.id}">
     <input type="text" name="str" autofocus="autofocus">
    
    <input type="submit" onclick="StartQr()" >
    </form>
   
    
    
    </div>
    
    
    
    
  </body>
</html>
