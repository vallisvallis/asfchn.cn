<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cutTest1.jsp' starting page</title>
    
	<meta name="layout" content="main">    
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />      
        <script type="text/javascript" src="jquery-1.12.3.min.js"></script>    
        <script type="text/javascript" src="html2canvas.js"></script>    
             
        <script  type="text/javascript" >    
    $(document).ready( function(){    
                $(".button").on("click", function(event) {    
                        event.preventDefault();    
                        html2canvas(document.getElementById("textArea"), {    
                        allowTaint: true,    
                        taintTest: false,    
                        onrendered: function(canvas) {    
                            canvas.id = "mycanvas";    
                            //生成base64图片数据    
                            var dataUrl = canvas.toDataURL();    
                            var newImg = document.createElement("img");    
                            newImg.src =  dataUrl;    
                            document.body.appendChild(newImg);    
                        }    
                    });    
                });     
    });    
        </script>    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <div class="" style="background-color: white;">     
            测试图片  
        </div>    
             
        <textArea id="textArea" col="20" rows="10" ></textArea>    
        <input class="button" type="button" value="button">测试</input>    
  </body>
</html>
