<%@ page language="java" contentType="text/html; charset=UTF-8"  import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>

<!DOCTYPE html>
<html lang="en">
<head>
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
	<title>添加会员单位</title>
	</head>
	<body>
	<div align="center" background-image="">
	<h1>添加会员单位</h1>
	<form action="" name="hxTeamFrom"    class="form-horizontal" role="form">
	
	<table>
	<tr>
	<td>会员单位名称：</td>
	<td><input type="text" name="fullname" placeholder="请输入名称"></td>
	</tr>
	<tr>
	<td>单位所在城市：</td>
	<td><select name="city" style="width: 172px; ">
	<!--  <option value=""></option>-->
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
	</select></td>
	</tr>
	<tr>
	<td>会员单位类型：</td>
	<td><select name="orgtype" style="width: 172px; ">
	<option></option>
	<option value="X">学校</option>
	<option value="Q">企业</option>
	<option value="H">协会</option>
	</select></td>
	</tr>	
	</table>
	<hr>
	<table>
	<tr>
	<td>会员单位负责人：</td>
	<td><input type="text" name="managername" placeholder="请输入名字"></td>
	</tr>
	<tr>
	<td>单位负责人电话：</td>
	<td><input type="text" name="phone" placeholder="请输入电话"></td>
	</tr>
	<tr>
	<td>会员单位邮箱：</td>
	<td><input type="text" name="email" placeholder="请输入邮箱"></td>
	</tr>
	<tr>
	<td>会员单位地址：</td>
	<td><input type="text" name="address" placeholder="请输入地址"></td>
	</tr>
	<tr>
	<td>会员单位主页：</td>
	<td><input type="text" name="homepage" placeholder="请输入主页"></td>
	</tr>
	</table>
	<hr>
	<table>
	<tr>
	<td>会员单位的训练单位：（若否请勿填）</td>
	<td><input type="text" name="trainingcenter"></td>
	</tr>
	<tr>
	<td>会员单位的飞行营地：（若否请勿填）</td>
	<td><input type="text" name="flyingcamp"></td>
	</tr>
	</table>
	<hr>
	<table>
	<tr>
	<td>备注1：</td>
	<td><input type="text" name="prop1"></td>
	</tr>
	<tr>
	<td>备注2：</td>
	<td><input type="text" name="prop2"></td>
	</tr>
	<tr>
	<td>添加人：</td>
	<td><input type="text" name="addUser"></td>
	</tr>
	</table>
<!--  	会费到期时间：<input type="datetime-local" name="eligibledat"><br>-->
	<div class="form-group" align="center">
		<div>
			<button type="submit" class="btn btn-default" onclick="addHxTeam()" align="center">确定添加</button>
		</div>
	</div>
	
	</form>
	</div>
	 <script type="text/javascript">
	function addHxTeam(){
	var form = document.forms[0];
	form.action = "<%=basePath%>addHxTeam";
	form.method="post";
	form.submit();
	}
	</script>
	</body>