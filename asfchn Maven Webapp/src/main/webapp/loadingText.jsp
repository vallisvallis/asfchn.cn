<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML >
<html>
  <head>
  <script type="text/javascript">
  $(window).load(function(){
    $("#loading").hide();
})
  </script>
 
  
<script src="js/jquery-1.12.3.min.js"></script>

<style type="text/css">
#loading{
position:absolute;
width:300px;
top:0px;
left:50%;
margin-left:-150px;
text-align:center;
padding:7px 0 0 0;
font:bold 11px Arial, Helvetica, sans-serif;
}

</style>
  </head>
  
  <script type="text/javascript">
   //页面加载完成之后隐藏loading
   /*$(window).load(function(){
	      $(".Loading").hide();
	   });*/
   
   //设置页面加载3秒之后隐藏loading
   $(function(){
	      setTimeout(function(){
			     $("#loading").hide();
				
			  },3000);
	   })
</script>

  <body>
  
<div id="loading">

<img src="loading.gif" mce_src="loading.gif" alt="loading.." />
</div>
  
 
  </body>
</html>
