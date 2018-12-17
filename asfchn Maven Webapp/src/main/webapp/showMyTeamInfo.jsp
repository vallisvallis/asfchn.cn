<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML >
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<meta name="keywords" content="">
<meta name="description" content="">
 <script type="text/javascript" src="js/html2canvas.js"></script>
 <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.min.css">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min_EDT.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css"
	href="css/plugins/iCheck/custom.css">
	
	<style type="text/css">
	
	#dw{position: absolute;top: 2px;left:13%;height: 620px;width:1030px;background: #ffffff; border:1px solid black;padding: 10px}

	.close:after{
 content: "";
 position: absolute;
 top: 0;
 left: 0;
 width:0.2em;
 height:1em;
 background: #333;
 -webkit-transform: rotate(270deg);
 -moz-transform: rotate(270deg);
 -o-transform: rotate(270deg);
 -ms-transform: rotate(270deg);
 transform: rotate(270deg);
}
	
	</style>
<script type="text/javascript">
  $("#dw").hide();
//关闭图片
function closeok(){
 $("#dw").hide();
}
//点击截图
function doScreenShot(){
 $("#dw").show();
 html2canvas($("#main"), {
  onrendered: function(canvas) {
   canvas.id = "mycanvas";
   var mainwh=$("#main").width();
   var mainhg=$("#main").height();
   var img = convertCanvasToImage(canvas);
   console.log(img);
   //document.body.appendChild(img);
   $("#dw").append(img) //添加到展示图片p区域
   img.onload = function() {
    img.onload = null;
    img.src = convertCanvasToImage(canvas).src;
    $(img).css({
     background:"#fff" 
    });
    //调用下载方法
     if(browserIsIe()){ //假如是ie浏览器   
      DownLoadReportIMG(img.src);
     }else{
      download(img.src)
     }
    }
   }   
 });
}
//绘制显示图片
function convertCanvasToImage(canvas) {
 var image = new Image();
 image.src = canvas.toDataURL("image/png"); //获得图片地址
 return image;
}
//生成canvas元素，相当于做了一个装相片的框架
function convertImageToCanvas(image, startX, startY, width, height) {
 var canvas = document.createElement("canvas");
 canvas.width = width;
 canvas.height = height;
 
 canvas.getContext("2d").drawImage(image, startX, startY, width, height, 20, 40, 1300, 1388); //在这调整图片中内容的显示（大小,放大缩小,位置等）
 return canvas;
}
 function DownLoadReportIMG(imgPathURL) {
 //如果隐藏IFRAME不存在，则添加
 if (!document.getElementById("IframeReportImg"))
  $('<iframe style="display:none;" id="IframeReportImg" name="IframeReportImg" onload="DoSaveAsIMG();" width="0" height="0" src="about:blank"></iframe>').appendTo("body");
 if (document.all.IframeReportImg.src != imgPathURL) {
  //加载图片
  document.all.IframeReportImg.src = imgPathURL;
 }
 else {
  //图片直接另存为
  DoSaveAsIMG();
 }
}
function DoSaveAsIMG() {
 if (document.all.IframeReportImg.src != "about:blank")
  window.frames["IframeReportImg"].document.execCommand("SaveAs");
}
// 另存为图片
function download(src) {
 var $a = $("<a></a>").attr("href", src).attr("download", "img.png");
 $a[0].click();
}
//判断是否为ie浏览器
function browserIsIe() {
 if (!!window.ActiveXObject || "ActiveXObject" in window)
  return true;
 else
  return false;
}
  
  </script>


 
</head>

<body>

<div>
<style type="text/css">

#dw img{ max-width:100%; height:100%}
</style>
	<div  align="center"   ><div>
	<div id="main" >
	<h1>${joinMatchTeam.matchname }报名表</h1>
		<table  id="ListTB" style="width:50%;">
		<tr>
		<th style="width:10%">单位名称：</th>
		<th style="width:20%">${joinMatchTeam.blongteamname }</th>
		
		<th style="width:10%">队伍名称：</th>
		<th style="width:40%">${joinMatchTeam.teamname }</th>	
		<th style="width:10%">打印时间：</th>
		<th style="width:10%">
		<fmt:formatDate value="${joinMatchTeam.addtime }" pattern="yyyy-MM-dd " />
		</th>
		</tr>
		</table> 
		<table  style="width:50%;" border="1px">
		<tr>
		<td style="width:10%">职务：</td>
		<td style="width:10%">姓名：</td>
		<td style="width:10%">性别：</td>
		<td style="width:10%">会员号：</td>
		<td style="width:30%">比赛项目：</td>
		<td style="width:10%">组别：</td>
		<td style="width:10%">团体项目：</td>
		<td style="width:10%">频率：</td>		
		<!--  <td style="width:10%">生成二维码：</td>	-->	
		</tr>
		<c:forEach items="${joinMatchTeamPeoples }" var="joinMatchTeamPeople">
		<tr>
		<td>${joinMatchTeamPeople.jobname }</td> 
		<td>${joinMatchTeamPeople.name }</td>
		<td>${joinMatchTeamPeople.peoplegender }</td>
		<td>${joinMatchTeamPeople.peoplesn }</td>
		<td>${joinMatchTeamPeople.joinmatchlistinname}</td>
		<td>
		<c:choose>
		<c:when test="${joinMatchTeamPeople.gage eq 1}">小学男</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 2}">小学女</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 3}">初中男</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 4}">初中女</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 5}">高中男</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 6}">高中女</c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 7}"></c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 8}"></c:when>
		<c:when test="${joinMatchTeamPeople.gage eq 9}"></c:when>
		</c:choose>
		</td>
		<td>
<c:choose>
<c:when test="${joinMatchTeamPeople.isteammatchlist eq 1}">是</c:when>
<c:when test="${joinMatchTeamPeople.isteammatchlist eq 1}">否</c:when>
</c:choose>				
		</td>
		<td>${joinMatchTeamPeople.pinlv }</td>	
		 <!-- <td><a href="createQR?id=${joinMatchTeamPeople.id }">生成二维码</a></td>-->
		</tr>
		</c:forEach>	
		<tr>
		<th colspan="8" height="30">备注:<input type="text" value="${joinMatchTeam.prop1 }" disabled="disabled" style="width: 950px; "></th>
		</tr>	
		</table>
		</div>
		</div>
			<div class="form-group" align="center">
				<!--  <div>
					<a  href="showMyJoinTeam?id=${joinMatchTeam.blongteam }" class="btn btn-default"
						 align="center">返回</a>					
				</div>-->
			</div>
			
		<div onclick="doScreenShot()" style="height: 30px;width: 168px;border:2px solid black;background: #999;text-align: center;"> 下载</div>
		
		</div>
	</div>
	<div id="dw" style="height: 30px;width: 68px;border:2px solid black;background: #999;text-align: center;align:center;">	
	<div title="关闭" onclick="closeok()" >关闭</div>
	</div>
</body>
</html>
