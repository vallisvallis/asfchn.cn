<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cutTest.jsp' starting page</title>
    
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <script type="text/javascript" src="js/html2canvas.js"></script>
 <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
<style type="text/css">
body{background: #ccc}
#dw{position: absolute;top: 10px;left:10%;height: 620px;width:1030px;background: #fff; border:1px solid black;padding: 10px}
.close{
 position:relative;
 left: 10px;
 width:0.2em;
 height:1em;
 background: #333;
 -webkit-transform: rotate(45deg);
 -moz-transform: rotate(45deg);
 -o-transform: rotate(45deg);
 -ms-transform: rotate(45deg);
 transform: rotate(45deg);
 display: inline-block;
}
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
    canvas = convertImageToCanvas(img, 0, 0, 1024, 600); //设置图片大小和位置
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
 canvas.getContext("2d").drawImage(image, startX, startY, width, height, 20, 20, 960, 600); //在这调整图片中内容的显示（大小,放大缩小,位置等）
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

  <!-- 要截图的p main 蓝色区域 -->
<p id="main" style="width: 50%; margin-left: 100px;padding: 50px;height: 400px;background: #5a90a0">
　　<p style="height: 200px;width: 200px;background: #ccc;"></p>
　　<p style="height: 30px;width: 168px;border:2px solid black;background: red;text-align: center;" onclick="doScreenShot()">截图</p>
</p>
<!-- 生成图片展示的p dw-->
<p id="dw" >
　　<p style="float: right;width: 25px;height: 25px;" title="关闭" onclick="closeok()">
　　　　<span class="close"></span>
　　</p>
</p>
    
    
  </body>
</html>
