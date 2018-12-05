<html lang="ZH-CN">
<head>
  <meta charset="utf-8">
  <title>Web QrCode Test</title>
<script type="text/javascript" src="jquery-1.8.3.min.js"></script>

<script type="text/javascript" src="jsqrcode/src/grid.js"></script>
<script type="text/javascript" src="jsqrcode/src/version.js"></script>
<script type="text/javascript" src="jsqrcode/src/detector.js"></script> 
<script type="text/javascript" src="jsqrcode/src/formatinf.js"></script>
<script type="text/javascript" src="jsqrcode/src/errorlevel.js"></script>
<script type="text/javascript" src="jsqrcode/src/bitmat.js"></script>
<script type="text/javascript" src="jsqrcode/src/datablock.js"></script>
<script type="text/javascript" src="jsqrcode/src/bmparser.js"></script>
<script type="text/javascript" src="jsqrcode/src/datamask.js"></script>
<script type="text/javascript" src="jsqrcode/src/rsdecoder.js"></script>
<script type="text/javascript" src="jsqrcode/src/gf256poly.js"></script>
<script type="text/javascript" src="jsqrcode/src/gf256.js"></script>
<script type="text/javascript" src="jsqrcode/src/decoder.js"></script>
<script type="text/javascript" src="jsqrcode/src/qrcode.js"></script>
<script type="text/javascript" src="jsqrcode/src/findpat.js"></script>
<script type="text/javascript" src="jsqrcode/src/alignpat.js"></script>
<script type="text/javascript" src="jsqrcode/src/databr.js"></script>
</head>
<body>
  <div class="booth">
    <video id="video" width="400" height="400"></video>
    <canvas id='canvas' width='400' height='400'></canvas>
    <img id='img' src=''>
  </div>
  
  <div id="mm"></div>
  
 <!--  -->
<canvas id="qr-canvas" width="640" height="480"></canvas>
<script>
    
    
    //初始化媒体对象
  	var c=0;
    var video = document.getElementById('video'),
        canvas = document.getElementById('canvas'),
        img = document.getElementById('img'),
        vendorUrl = window.URL || window.webkitURL;
        
    //媒体对象
    navigator.getMedia = navigator.getUserMedia ||
                         navagator.webkitGetUserMedia ||
                         navigator.mozGetUserMedia ||
                         navigator.msGetUserMedia;
    navigator.getMedia({
        video: true, //使用摄像头对象
        audio: false  //不适用音频
    }, function(strem){
        console.log(strem);
        video.src = vendorUrl.createObjectURL(strem);
        video.play();
    }, function(error) {
        //error.code
        console.log(error);
    });
    
    //启动定时器
    setTimeout("actionP(null)","1000");
    
    //定时器
    function actionP(data){
    	if(data==null){
    		Screenshot()
        	
    	}else{
    		if(data!=null & data!="error decoding QR Code"){//识别出数据
        		if(data.indexOf("http")!=-1){
        			window.location.href=data;
        		}else alert(data);
        		
        	}else{//没有数据循环十次
           		c++;
               	if(c<10){
               		setTimeout("actionP(null)","1000");
               	}
            	
            }
    	}
    	
   	}
    
    
    function Screenshot(){//截取图像
 		 canvas.getContext('2d').drawImage(video, 0, 0, 400, 400);
 		 var imgData = canvas.toDataURL("image/png");
 		 load(imgData);
 		 img.src=imgData;
    	
    }
   ////////////////////////////////////////识别二维码////////////////////////////////////////////
   
	function dragenter(e) {
	  e.stopPropagation();
	  e.preventDefault();
	}
	
	function dragover(e) {
	  e.stopPropagation();
	  e.preventDefault();
	}
	function drop(e) {
	  e.stopPropagation();
	  e.preventDefault();
	
	  var dt = e.dataTransfer;
	  var files = dt.files;
	
	
	}
	
		
	function load(name)
	{
		initCanvas(640,480);
		//识别二维码并回调方法
		qrcode.callback = actionP;
		qrcode.decode(name);
	}
	
	function initCanvas(ww,hh)//创建画板
		{
		gCanvas = document.getElementById("qr-canvas");
		gCanvas.addEventListener("dragenter", dragenter, false);  
		gCanvas.addEventListener("dragover", dragover, false);  
		gCanvas.addEventListener("drop", drop, false);
		var w = ww;
		var h = hh;
		gCanvas.style.width = w + "px";
		gCanvas.style.height = h + "px";
		gCanvas.width = w;
		gCanvas.height = h;
		gCtx = gCanvas.getContext("2d");
		gCtx.clearRect(0, 0, w, h);
		imageData = gCtx.getImageData( 0,0,320,240);
	}


  </script>
</body>
</html>