<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>My JSP 'showThisMatchList.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
<link rel="stylesheet" type="text/css"
	href="css/plugins/chosen/chosen.css">
	
	<!--<link rel="stylesheet" type="text/css" href="styles.css">-->
	 <script type="text/javascript">
	function updateMatchInHX(){
	var form = document.forms[0];
	form.action = "<%=basePath%>updateMatchInHX";
	form.method="post";
	form.submit();
	}
	</script>
	
	
  </head>
  <body style="text-align:center">
   
  <div align="center">
  <div class="row">
  <form class="form-horizontal">
		<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-3">
							<div class="J_menuItem">
									<div class="widget green-bg p-lg text-center">
											<div class="m-b-md">
														<h1 class="m-xs">秩序册</h1>
														<a class="m-xs box-block" href="orderNameList?id=${match.id }">生成秩序册</a>
													</div>
												</div>
											</div>
										</div>
									<div class="col-sm-3">
											<div class="J_menuItem">
												<div class="widget  yellow-bg p-lg text-center">
													<div class="m-b-md">
														<h1 class="m-xs">成绩册</h1>
														<a class="m-xs box-block" href="downloadAllscore?matchid=${match.id }">生成成绩册</a>
													</div>
												</div>
											</div>
									</div>
											<div class="col-sm-3">
											<div class="J_menuItem">
												<div class="widget  blue-bg p-lg text-center">
													<div class="m-b-md">
														<h1 class="m-xs">参赛人员校验系统</h1>
														<a  href="#"><span style="color:red;">打开参赛人员校验系统<br>（此功能在正式比赛前请慎用）</span></a>
														
													</div>
												</div>
											</div>
										</div>	
									
									</div>
								</div>
							</form>
						</div>
						</div>
    <div align="center">
    <div style="border-width:2px; border-style:solid; border-color:red;">
  <form action="">
   <input type="hidden" name="matchid" value="${match.id }">
   <table>
   <thead>
   <tr>
   <th>项目名称</th>
    <th>组别名称</th>
  
   </tr>
  </thead>
  <tbody>
    <tr>
   
    <td><select name="matchlistid">
    
     <c:forEach items="${allMatchLists }" var="matchlist" >
     <option value="${ matchlist.id}">${matchlist.name } </option>
     </c:forEach>
    </select></td>
    <td><select name="gageid">
    
     <c:forEach items="${allMatchGroups }" var="matchGroup" >
     <option value="${ matchGroup.id}">${matchGroup.groupage } </option>
     </c:forEach>
    </select></td>
    
    
   </tr>
  
  
  
  </tbody>
   
   
   </table>
  
   <button type="submit" class="btn btn-default"
						onclick="readydownloadsingle()" align="center">下载成绩</button>
   </form>
   </div>
   <div style="border-width:2px; border-style:solid; border-color:red;">
   <form action="">
   <input type="hidden" name="matchid" value="${match.id }">
   <table>
   <thead>
   <tr>
   
    <th>组别名称</th>
  
   </tr>
  </thead>
  <tbody>
    <tr>

    <td><select name="gageid">
    
    <option  value="1">小学组 </option>
    <option  value="3"> 初中组</option>
    <option  value="5"> 高中组</option>
    </select></td>
    <td></td>
    
   </tr>
  
  
  
  </tbody>
   
   
   </table>
  
   <button type="submit" class="btn btn-default"
						onclick="downloadTeamMatchBook()" align="center">下载团体成绩</button>
   </form>
   </div>
   <form action="">
   <input type="hidden" name="matchid" value="${match.id }">
   <table>
   <thead>
   <tr>
   <th>项目名称</th>
  <th>证书类型</th>
   </tr>
  </thead>
  <tbody>
    <tr>
   
    <td><select name="matchlistid">
    
     <c:forEach items="${allMatchLists }" var="matchlist" >
     <option value="${ matchlist.id}">${matchlist.name } </option>
     </c:forEach>
    </select></td>
   <!--  <td><select name="zstype">
    
    <option value="等奖">等奖名次证书</option>
    <option value="团体">团体证书</option>
    </select></td>-->
   
    
   </tr>
  
  
  
  </tbody>
   
   
   </table>
  
   <button type="submit" class="btn btn-default"
						onclick="downloadZS()" align="center">下载证书</button>
   </form>
   <a href="createAllQR?id=1">二维码</a>
   <script type="text/javascript">
	function readydownloadsingle(){
	var form = document.forms[1];
	form.action = "<%=basePath%>readydownloadsingle";
		form.method = "post";
		form.submit();
	}
	
</script>
  <script type="text/javascript">
	function downloadTeamMatchBook(){
	var form = document.forms[2];
	form.action = "<%=basePath%>downloadTeamMatchBook";
		form.method = "post";
		form.submit();
	}
	
</script>
  <script type="text/javascript">
	function downloadZS(){
	var form = document.forms[3];
	form.action = "<%=basePath%>downloadZS";
		form.method = "post";
		form.submit();
	}
	
</script>
    </div>
  </body>
</html>
