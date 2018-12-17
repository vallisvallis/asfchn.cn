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
<title>编辑会员</title>

<script type="text/javascript">
    function updatehxPeople() {
        var form = document.forms[0];
        form.action = "<%=basePath %>updateHxPeople";
        form.method = "post";
        form.submit();
    }
</script>

</head>
<body>
    <h1>编辑会员</h1>
    <form action="" name="hxPeopleForm"  >
	<hr>
	id<input type="hidden" name="id" value="${hxPeople.id }" ><br>
	名字<input type="text" name="name" value="${hxPeople.name }"><br>
	城市<input type="text" name="city" value="${hxPeople.city }"><br>
	所属会员单位<input type="text" name="belongTeam" value="${hxPeople.belongteam }"><br>
	<hr>
	
	性别<input type="text" name="managername" value="${hxPeople.gender }"><br>
	身份证号<input type="text" name="managermoblie" value="${hxPeople.certnumber }"><br>
	
	会费日期<input type="datetime-local" name="phone" value="${hxPeople.yearfeestatus }"><br>
	备注<input type="text" name="address"value="${hxPeople.prop1 }"><br>
	
<!--  	会费到期时间：<input type="datetime-local" name="eligibledat"><br>-->
	
	
	<hr>	
	
	
	
	<hr>
	<input type="submit" value="SUBMIT" onclick="updateHxPeople()">
	
	</form>
</body>

</html>
