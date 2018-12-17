<%@ page language="java" contentType="text/html; charset=UTF-8"  import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>

<!DOCTYPE html>
<html lang="en">

<head>


<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<script src="lib/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="lib/jquery.poshytip.js"></script>
<script type='text/javascript' src='lib/jq.validate.js'></script>

<link rel="stylesheet" href="lib/tip-yellowsimple/tip-yellowsimple.css" type="text/css" />





<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<meta name="keywords" content="">
<meta name="description" content="">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.min.css">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min_EDT.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css"
	href="css/plugins/iCheck/custom.css">
	<title>添加会员</title>
<style type="text/css">
body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,p,blockquote,th,td{margin:0;padding:0}
table{border-collapse:collapse;border-spacing:0}
fieldset,img{border:0}
address,caption,cite,code,dfn,th,var{font-style:normal;font-weight:normal}
ol,ul{list-style:none}
caption,th{text-align:left}
h1,h2,h3,h4,h5,h6{font-size:100%;font-style:normal;font-weight:normal}
q:before,q:after{content:''}
body{font:13px arial,helvetica,clean,sans-serif;font-size:small;}
select,input,textarea{font:99% arial,helvetica,clean,sans-serif}
pre,code{font:115% monospace;font-size:100%}
body * {line-height:1.22em}
body {
	color: #202020;
}

h1 {
	color: #fff;
	background: #06b;
	padding: 10px;
	font-size: 200%;
}

h2 {
	color: #000;
	font-size: 150%;
	padding: 10px 0;
}

h3 {
	color: #000;
	font-size: 120%;
	padding: 10px 0;
}

ul {
	list-style: disc inside;
	margin-left: 1em;
}

#content {
	padding: 10px;
}

label {
	float: left;
	width: 12em;
}
input[type=text] { width: 15em; }

#banner { padding: 15px; background-color: #06b; color: white; font-size: large; border-bottom: 1px solid #ccc;
    background: url(bg.gif) repeat-x; text-align: center }
#banner a { color: white; }

</style>	
	
	</head>
	<body>
	
	
	
	<div align="center" background-image="">
	<h1>添加会员</h1>
	<form action="" name="hxPeopleFrom"    class="form-horizontal" role="form">
	  <input type="hidden" name="id" >
	  <input type="hidden" name="belongteam" value="${thisHxTeam.id }">
	  <!--
	<input type="hidden" name="belongteam" value="${xd }">-->
	<table>
	<tr>
	<td>会员名称：</td>
	<td><input type="text" name="name" placeholder="请输入名称" id="name" valType="required" msg="<font color=red>*</font>会员名称不能为空">(必填)</td>
	</tr>
	
	<tr>
	
	<td>会员单位名称：</td>
	
	<td><input type="text" name="team" value="${thisHxTeam.fullname }" disabled="disabled"></td>
	</tr>
	<tr>
	<td>年龄：</td>
	<td><input type="text" name="age" id="age" valType="NUMBER" msg="<font color=red>*</font>验证码只能是数字" >(必填)</td>
	</tr>
	<tr>
	<td>注册地：</td>
	<td><select name="city" style="width: 172px; " id="city">
	<option value=""></option>
	<option value="郑州市">郑州市</option>
	<option value="开封市">开封市</option>
	<option value="平顶山市">平顶山市</option>
	<option value="洛阳市">洛阳市</option>
	<option value="商丘市">商丘市</option>
	<option value="安阳市">安阳市</option>
	<option value="新乡市">新乡市</option>
	<option value="许昌市">许昌市</option>
	<option value="鹤壁市">鹤壁市</option>
	<option value="濮阳市">濮阳市</option>
	<option value="漯河市">漯河市</option>
	<option value="三门峡市">三门峡市</option>
	<option value="周口市">周口市</option>
	<option value="驻马店市">驻马店市</option>
	<option value="南阳市">南阳市</option>
	<option value="信阳市">信阳市</option>
	<option value="焦作市">焦作市</option>	
	<option value="济源市">济源市</option>
	</select>(必填)</td>
	</tr>	
	</table>
	<hr>
	
	<hr>
	<table>
	<tr>
	<td>性别：</td>
	<td><input type="text" name="gender" >(必填)</td>
	</tr>
	<!--  <tr>
	<td>出生日期</td>
	<td><input type="datetime-local" name="birthday"></td>
	</tr>-->
	
	<tr>
	<td>身份证号:</td>
	<td><input type="text" name="certnumber" id="checkCert" >(必填)</td>
	</tr>
	<tr>
	<td>个人信息简介:</td>
	<td><textarea  name="personIntro"></textarea></td>
	</tr>
	</table>
	<hr>
	<table>
	<tr>
	<td>住址：</td>
	<td><input type="text" name="prop4" id="address"></td>
	</tr>
	<tr>
	<td>手机号：</td>
	<td><input type="text" name="prop3" ></td>
	</tr>
	<tr>
	<td>备注：</td>
	<td><input type="text" name="prop1"></td>
	</tr>		
	
	</table>
	
	
<!--  	会费到期时间：<input type="datetime-local" name="eligibledat"><br>-->	
	
	<div class="form-group" align="center">
		<div >
			<button type="submit" class="btn btn-default" onclick="addHxPeopleByHxTeam()" align="center">确定添加</button>
		</div>
	</div>
	
	</form>
	</div>

	 <script type="text/javascript">
		$(function(e) {
var vali=new Validators();
$("#btn").bind("click", vali.subByJs);
});
	
	function addHxPeopleByHxTeam(){
	var form = document.forms[0];
    var name=document.getElementById(name);
	var age =document.getElementById("age");
	var city=document.getElementById("city");
	String i=name.getAttribute(value);
	alert(i);
	alert(age);
	alert(city);
	if ((age!=null) && (name!=null) &&(city !=null) && (age!="") && (name!="") && (city!="")) {
	

		form.action = "<%=basePath%>addHxPeopleByHxTeam";
	form.method="post";
	form.submit();
	}else{
	alert(age!=null+"age");
	alert( name!=null+"name");
	alert(city !=null+"city");
	alert(age!="");
	alert(name!="");
	alert(city!="");
		alert((age!=null) && (name!=null) &&(city !=null) && (age!="") && (name!="") && (city!=""));
	alert("请输入必要信息");
	form.action = "<%=basePath%>addHxPeopleByHxTeamNo";
	form.method="post";
	form.submit();
	}
	
	
	}


//function $(e){return document.getElementById(e);}
//function go()
//{
//var reg=/^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
//if(reg.test($("checkCert").value))
//{}
//else{alert("请输入正确 的身份证号");}
//}



	</script>
	</body>