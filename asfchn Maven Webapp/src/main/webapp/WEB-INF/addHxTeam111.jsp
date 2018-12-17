<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>编辑会员单位</title>

<script type="text/javascript">
    function updateHxTeam() {
        var form = document.forms[0];
        form.action = "<%=basePath %>updateHxTeam";
        form.method = "post";
        form.submit();
    }
</script>

</head>
<body>
    <h1>编辑会员单位</h1>
    <form action="" name="hxTeamFrom"  >
	<hr>
	会员单位名称：<input type="text" name="fullname" value="${hxTeam.fullname }"><br>
	单位所在城市：<input type="text" name="city" value="${hxTeam.city }"><br>
	会员单位类型：<input type="text" name="orgtype" value="${hxTeam.orgtype }"><br>
	<hr>
	
	会员单位负责人：<input type="text" name="managername" value="${hxTeam.managername }"><br>
	单位负责人电话：<input type="text" name="managermoblie" value="${hxTeam.managermoblie }"><br>
	会员单位邮箱：<input type="text" name="email" value="${hxTeam.email }"><br>
	会员单位电话：<input type="text" name="phone" value="${hxTeam.phone }"><br>
	会员单位地址：<input type="text" name="address"value="${hxTeam.address }"><br>
	会员单位主页：<input type="text" name="homepage" value="${hxTeam.homepage }"><br>
<!--  	会费到期时间：<input type="datetime-local" name="eligibledat"><br>-->
	
	
	<hr>	
	会员单位的训练单位：（没有请勿填）<input type="text" name="trainingcenter" value="${hxTeam.trainingcenter }"><br>
	会员单位的飞行营地：（没有请勿填）<input type="text" name="flyingcamp" value="${hxTeam.flyingcamp }"><br>
	备注1：<input type="text" name="prop1" value="${hxTeam.prop1 }"><br>
	备注2：<input type="text" name="prop2" value="${hxTeam.prop2 }"><br>
	添加人：<input type="text" name="addUser" value="${hxTeam.addUser }"><br>
	
	<hr>
	<input type="submit" value="提交" onclick="updateHxTeam()">
	
	</form>
</body>

</html>
