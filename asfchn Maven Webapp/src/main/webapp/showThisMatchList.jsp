<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showThisMatchList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <script type="text/javascript">
	function updateMatchListbutton(){
	var form = document.forms[0];
	form.action = "<%=basePath%>updateMatchListbutton";
	form.method="post";
	form.submit();
	}	
	</script>
  </head>
  
  <body>
    <div align="center">
    <form>
    <input type="hidden" name="id" value="${matchList.id }">
    <table>
    <tr>
    <td>项目名称:</td>
    <td><input type="text" name="name" value="${matchList.name }"></td>
    
    </tr>  
    
    </table>
    <textarea rows="30%" cols="30%" name="rule">${matchList.rule }</textarea>
    <div class="form-group" align="center">
		<div >
			<button type="submit" class="btn btn-default" onclick="updateMatchListbutton()" align="center">确定修改</button>
		</div>
	</div>
    </form>
    </div>
  </body>
</html>
