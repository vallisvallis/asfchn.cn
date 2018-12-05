<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
	<style type="text/css">
	a {
    text-decoration: none;
    color: #fff;
    font-size: 14px;
}

h2 {
    width: 180px;
    height: 38px;
    margin: 100px auto;
    text-align: center;
    line-height: 38px;
    background: #5BC0DE;
    border-radius: 4px;
}
	
	
	</style>	
</head>
<body>
<h2><a href="${path }/hxTeamInfo">航协页面</a></h2>
<h2><a href="${path }/hxPeopleInfo">会员单位页面</a></h2>
<h2><a href="${path }/showHxPeopleBySelf?id=1">会员页面</a></h2>
<h2><a href="${path }/matchInfo">赛事页面</a></h2>
<h2><a href="${path }/newsInfo">新闻页面</a></h2>
<h2><a href="${path }/matchListInfo">项目列表页面</a></h2>
</body>
</html>
