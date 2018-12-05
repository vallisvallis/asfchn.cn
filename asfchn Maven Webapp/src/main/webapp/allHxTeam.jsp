<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
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
<title>会员单位管理</title>
 <script type="text/javascript">
	function search(){
	var form = document.forms[0];
	form.action = "<%=basePath%>search";
	form.method="post";
	form.submit();
	}	
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>会员单位管理</h5>
					</div>
					<div class="ibox-content">
						<div class="row">
							<form class="form-horizontal">
								<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-3">
											<div class="J_menuItem">
												<div class="widget green-bg p-lg text-center">
													<div class="m-b-md">
														<h1 class="m-xs">${pageInfo.total}</h1>
														<span class="m-xs box-block">会员单位数量</span>
													</div>
												</div>
											</div>
										</div>
										<div class="col-sm-3">
											<a class="J_menuItem" data-title="已交会费会员单位" href="toTeamHasPay">
												<div class="widget  yellow-bg p-lg text-center">
													<div class="m-b-md">
														<h1 class="m-xs">  ${hxTeamHasFeed }</h1>
														<span class="m-xs box-block">已交会费会员单位</span>
													</div>
												</div>
											</a>
										</div>
										<div class="col-sm-3">
											<a class="J_menuItem" data-title="未缴会费会员单位" href="toTeamHasNoPay">
												<div class="widget  blue-bg p-lg text-center">
													<div class="m-b-md">
														<h1 class="m-xs">${pageInfo.total-hxTeamHasFeed}</h1>
														<span class="m-xs box-block">未缴会费会员单位</span>
													</div>
												</div>
											</a>
										</div>
										<div class="col-sm-3">
											<div class="col-md-12">
												<div class="widget lazur-bg">
													<h4>&nbsp</h4>
													<div class="box-block">
														<p><a href="trainTeam">1，训练单位</a></p>
														<p><a href="flyTeam">2，飞行营地</a></p>
														<p>&nbsp</p>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
						<div class="hr-line-dashed"></div>
						<div class="row m-b-lg m-t-lg">
							<div class="col-sm-4"></div>
							<div class="col-sm-4 text-center">
								<div class="form-group">
								<form name="search"  action=""     class="form-horizontal" role="form">
									<div class="input-group">
										<input class="form-control" id="str" name="str"
											placeholder="姓名/会员号/城市" type="text" value="${str}"> <span
											class="input-group-btn">
											<button type="submit" class="btn btn-primary" onclick="search()">
												<i class="fa fa-search" ></i> 搜索
											</button>
										</span>
									</div></form>
								</div>
							</div>
						</div>
						<div class="table-responsive">
							<table class="table table-striped table-hover" id="ListTB">
								<thead>
									<tr>
										<th>序号</th>
										<th>会员单位名称</th>
										<th>会员单位号</th>
										<th>负责人 </th>
										<th>联系电话 </th>
										<th>类型</th>										
										<th>会费状态</th>
										<th>训练单位</th>
										<th>飞行营地</th>
										<th>成员</th>
										<th>详情</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								<%int i=1; %>
									<c:forEach items="${pageInfo.list }" var="hxTeam">
										<tr>
										<td><%=i %></td>
											<td>${hxTeam.fullname }</td>
											<td>${hxTeam.sn }</td>
											<td>${hxTeam.managername }</td>
											<td>${hxTeam.phone }</td>											
											<td>
											<c:choose>
											<c:when test="${hxTeam.orgtype eq 'Q'}">企业</c:when>
											<c:when test="${hxTeam.orgtype eq 'X'}">学校</c:when>
											<c:when test="${hxTeam.orgtype eq 'H'}">协会</c:when>
											</c:choose>							
											</td>
											
											<c:choose>
											<c:when test="${hxTeam.status eq '' }"><td style="color:red">未交费</td></c:when>
											<c:when test="${hxTeam.status eq null }"><td style="color:red">未交费</td></c:when>
											<c:when test="${hxTeam.status eq '1' }"><td style="color:red">未交费</td></c:when>
											<c:when test="${hxTeam.status eq  '2'}"><td style="color:green">正常</td></c:when>
											</c:choose>										
											<!--<fmt:formatDate value="${hxTeam.eligibledat }" pattern="yyyy-MM-dd HH:mm:ss" />   </td>-->
											<td></td>
											<td></td>
											<td><a href="${path}/showTeamPeopleInHx?id=${hxTeam.id}">成员</a></td>
											<td><a href="${path}/showTeamIntroduce?id=${hxTeam.id}">详情</a></td>
											<td><!-- <a type="button"
												href="${path}/getHxTeam?id=${hxTeam.id}">编辑</a> --> <a
												type="button"
												href="${path}/todelConfirm?id=${hxTeam.id}">删除</a></td>
										</tr>
<%i+=1; %>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<nav class="navbar-right" id="pagination">
									<ul class="pagination no-margins">
										<li class="active"><a href="${path}/hxTeamInfo?pn=1">首页</a></li>
										<c:if test="${pageInfo.hasPreviousPage }">
											<li><a
												href="${path}/hxTeamInfo?pn=${pageInfo.pageNum-1}"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a></li>
										</c:if>

										<c:forEach items="${pageInfo.navigatepageNums }"
											var="page_Num">
											<c:if test="${page_Num == pageInfo.pageNum }">
												<li class="active"><a href="#">${ page_Num}</a></li>
											</c:if>
											<c:if test="${page_Num != pageInfo.pageNum }">
												<li><a href="${path}/hxTeamInfo?pn=${ page_Num}">${ page_Num}</a></li>
											</c:if>
										</c:forEach>
										<c:if test="${pageInfo.hasNextPage }">
											<li><a
												href="${path}/hxTeamInfo?pn=${pageInfo.pageNum+1}"
												aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a></li>
										</c:if>
										<li><a href="${path}/hxTeamInfo?pn=${pageInfo.pages}">末页</a></li>
									</ul>
								</nav>
								<div class="clearfix"></div>
							</div>
							<div class="col-sm-3 text-left">
								共 <span class="text-danger">${pageInfo.total} </span>条，第 <span
									class="text-danger">${pageInfo.pageNum} </span> 页
							</div>
							<div class="col-sm-3 text-right">
<div class="btn btn-sm btn-white active" id="PageSizeRG" >
<a href="addHxTeam.jsp">增加会员单位</a>
</div>
								<div class="clearfix"></div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/plugins/iCheck/icheck.min.js"></script>
	<script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>
	<script>
		$(document).ready(function() {
			$(".nav-tab-info li a:eq(0)").addClass("active");
			$(".i-checks").iCheck({
				checkboxClass : "icheckbox_square-green",
				radioClass : "iradio_square-green"
			})
		});
		
		
		
	
	</script>
</body>
</html>