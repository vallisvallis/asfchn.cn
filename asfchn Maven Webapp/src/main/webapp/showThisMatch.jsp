<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
														<h1 class="m-xs">${num}</h1>
														<a class="m-xs box-block" href="showthismatchteam?id=${match.id }">参赛队伍</a>
													</div>
												</div>
											</div>
										</div>
									<div class="col-sm-3">
											<div class="J_menuItem">
												<div class="widget  yellow-bg p-lg text-center">
													<div class="m-b-md">
														<h1 class="m-xs">${nump}</h1>
														<a class="m-xs box-block" href="showthismatchpeople?id=${match.id }">参赛人数</a>
													</div>
												</div>
											</div>
									</div>
											<div class="col-sm-3">
											<div class="J_menuItem">
												<div class="widget  blue-bg p-lg text-center">
													<div class="m-b-md">
														<h1 class="m-xs">秩序册或成绩册</h1>
														<a  href="readyShowOrder?id=${match.id }"><span style="color:red;">准备生成</span></a>
														
													</div>
												</div>
											</div>
										</div>	
									<div class="col-sm-3">
											<a class="J_menuItem" data-title="" href="allcertificate?matchid=${match.id }">
												<div class="widget  lazur-bg p-lg text-center">
													<div class="m-b-md">
														<h1 class="m-xs">证书下载</h1>
														<span class="m-xs box-block">点此下载证书</span>
													</div>
												</div>
											</a>
										</div>
									</div>
								</div>
							</form>
						</div>
						</div>
    <div align="center">
    <form>
    <input type="hidden" name="id" value="${match.id }">
    <table>
    <tr>
    <td>比赛名称:</td>
    <td><input type="text" name="name" value="${match.name }"></td>
    </tr>  
    <tr>
    <td>比赛开始时间:</td>
    <td><input type="date" name="start" value="${match.starttime }"></td>
    </tr> <tr>
    <td>比赛结束时间:</td>
    <td><input type="date" name="end" value="${match.endtime }"></td>
    </tr> <tr>
    <td>比赛开始报名时间:</td>
    <td><input type="date" name="startReport" value="${match.addtime }"></td>
    </tr> <tr>
    <td>比赛结束报名时间:</td>
    <td><input type="date" name="endReport" value="${match.edittime }"></td>
    
    </tr> 
 <!-- <tr>
    <td><a  href="showthismatchteam?id=${match.id }">参赛队伍(${num })</a></td>
  
    </tr>-->
    
    
    <tr>
    <td>比赛地址:</td>
    <td><input type="text" name="address" value="${match.address }"></td>
    
    </tr>
    </table>
    <textarea rows="10%" cols="100%" name="introduce">${match.introduce }</textarea>
    <div class="form-group" align="center">
		<div >
			<button type="submit" class="btn btn-default" onclick="updateMatchInHX()" align="center">确定修改</button>
		</div>
	</div>
    </form>
    </div>
  </body>
</html>
