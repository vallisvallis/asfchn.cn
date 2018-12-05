<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
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
<link rel="stylesheet" type="text/css"
	href="css/plugins/chosen/chosen.css">
<title>新闻管理</title>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>新闻管理</h5>
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
														<span class="m-xs box-block">文章总数</span>
													</div>
												</div>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="J_menuItem">
												<div class="widget  yellow-bg p-lg text-center">
													<div class="m-b-md">
														<h1 class="m-xs">${newsNum }</h1>
														<span class="m-xs box-block">新闻</span>
													</div>
												</div>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="J_menuItem">
												<div class="widget  blue-bg p-lg text-center">
													<div class="m-b-md">
														<h1 class="m-xs">${reportNum }</h1>
														<span class="m-xs box-block">公告</span>
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
									<div class="input-group">
										<input class="form-control" id="Keywords" name="Keywords"
											placeholder="" type="text" value=""> <span
											class="input-group-btn">
											<button type="submit" class="btn btn-primary">
												<i class="fa fa-search"></i> 搜索
											</button>
										</span>
									</div>
								</div>
							</div>
						</div>
						<div class="table-responsive">
							<table class="table table-striped table-hover" id="ListTB">
								<thead>
									<tr>
										<th>新闻名称</th>
										<th>新闻发布者</th>
										<th>新闻发布时间</th>
										<th>新闻修改时间</th>
										<th>类型</th>										
										<th>详情</th>										
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${pageInfo.list }" var="news">
									<tr>
										<td>${news.title }</td>
										<td>${news.manager }</td>
										<td><fmt:formatDate value="${news.addtime }" pattern="yyyy-MM-dd HH:mm:ss" /> </td>
										<td>${news.edittime }</td>	
										<td>
										<c:choose>
											<c:when test="${news.type eq '1'}">新闻</c:when>
											<c:when test="${news.type eq '2'}">公告</c:when>
											
											</c:choose>	
										
										
										
										</td>									
										<td><a href="ActivityApproval.html">详情</a></td>
										<td><a type="button"
												href="${path}/getNews?id=${news.id}">编辑</a> <a
												type="button"
												href="${path}/delNews?id=${news.id}">删除</a></td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					<div class="row">
							<!--  <div class="col-sm-6">
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
							</div>-->
							<div class="col-sm-3 text-left">
								共 <span class="text-danger">${pageInfo.total} </span>条
							</div>
							<div class="col-sm-3 text-right">
<div class="btn btn-sm btn-white active" id="PageSizeRG" data-toggle="buttons">
<a href="${path }/toAddNews">增加新闻</a>
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
	<script src="js/plugins/chosen/chosen.jquery.js"></script>
	<script>
		$(document).ready(function() {
			$(".nav-tab-info li a:eq(0)").addClass("active");
			$(".i-checks").iCheck({
				checkboxClass : "icheckbox_square-green",
				radioClass : "iradio_square-green"
			});
		});
	</script>
</body>
</html>