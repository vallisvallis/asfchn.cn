<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showScore.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  <c:choose>
  <c:when test="${listid ==1 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score1 }</span><br><span>第二轮${matchlist1.score2}总分${ matchlist1.score3}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
   
  
  <c:choose>
  <c:when test="${listid ==2 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score21 }</span><br><span>第二轮${matchlist1.score22}总分${ matchlist1.score23}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==3 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score31 }</span><br><span>第二轮${matchlist1.score32}总分${ matchlist1.score33}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==4 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score41 }</span><br><span>第二轮${matchlist1.score42}总分${ matchlist1.score43}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==5 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score51 }</span><br><span>第二轮${matchlist1.score52}总分${ matchlist1.score53}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==6 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score61 }</span><br><span>第二轮${matchlist1.score62}总分${ matchlist1.score63}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==7}">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score71 }</span><br><span>第二轮${matchlist1.score72}总分${ matchlist1.score73}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==8 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score81 }</span><br><span>第二轮${matchlist1.score82}总分${ matchlist1.score83}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==9 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score91 }</span><br><span>第二轮${matchlist1.score92}总分${ matchlist1.score93}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==10 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score101 }</span><br><span>第二轮${matchlist1.score102}总分${ matchlist1.score103}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==11 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score111 }</span><br><span>第二轮${matchlist1.score112}总分${ matchlist1.score113}</p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==12 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score121 }</span><br><span>第二轮${matchlist1.score122}总分${ matchlist1.score123}</p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==13 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score131 }</span><br><span>第二轮${matchlist1.score132}总分${ matchlist1.score133}</p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==14 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score141 }</span><br><span>第二轮${matchlist1.score142}总分${ matchlist1.score143}</p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==15 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score151 }第二轮${matchlist1.score152}总分${ matchlist1.score153}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==16 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score161 }第二轮${matchlist1.score162}总分${ matchlist1.score163}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==17 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score171 }第二轮${matchlist1.score172}总分${ matchlist1.score173}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==18 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score181 }第二轮${matchlist1.score182}总分${ matchlist1.score183}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==19 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score191 }</span><br><span>第二轮${matchlist1.score192}总分${ matchlist1.score193}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==20 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score201 }</span><br><span>第二轮${matchlist1.score202}总分${ matchlist1.score203}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
  <c:choose>
  <c:when test="${listid ==21 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score211 }</span><br><span>第二轮${matchlist1.score212}总分${ matchlist1.score213}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  </c:choose>
  
  <c:choose>
  <c:when test="${listid ==22 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score221 }</span><br><span>第二轮${matchlist1.score222}总分${ matchlist1.score223}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  
  
  </c:choose>
   <c:choose>
  <c:when test="${listid ==23 }">
  
  
   <c:forEach items="${thislistscores}" var="matchlist1">
   <p>姓名：${matchlist1.peoplename }<br><span>第一轮${matchlist1.score231 }</span><br><span>第二轮${matchlist1.score232}总分${ matchlist1.score233}</span></p>
   
   </c:forEach>
  
  
  </c:when>
  </c:choose>
  </body>
</html>
