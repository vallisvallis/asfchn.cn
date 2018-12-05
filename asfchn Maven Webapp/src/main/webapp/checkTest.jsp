<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
<head>  
  
  
<title>mybatis测试页面</title>  
  

  
</head>  
  
<body>  

   <form name="form" action="checkTest">
<br>

<input TYPE="checkbox" name="fruit" VALUE="apples"> Apples <BR>
<input TYPE="checkbox" name="fruit" VALUE="grapes"> Grapes <BR>
<input TYPE="checkbox" name="fruit" VALUE="oranges"> Oranges <BR>
<input TYPE="checkbox" name="fruit" VALUE="melons"> Melons <BR>
<input TYPE="checkbox" name="fruit" VALUE="melons"> Melons <BR>
<input TYPE="checkbox" name="fruit" VALUE="melons"> Melons <BR>
<input TYPE="checkbox" name="fruit" VALUE="melons"> Melons <BR>
<input TYPE="checkbox" name="fruit" VALUE="melons"> Melons <BR>
<input TYPE="checkbox" name="fruit" VALUE="melons"> Melons <BR>

<br>
<input name="aa" type="submit" value="click" />

</form>
</body>  
</html>  