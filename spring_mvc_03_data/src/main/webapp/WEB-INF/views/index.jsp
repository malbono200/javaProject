<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	index 페이지 입니다. <br>
	
	<a href="/projectData/showInfo">showInfo</a><br>
	<a href="/projectData/showInfoMV">showInfoMV</a><br>
	
	<p>현재 시간 : ${serverTime}</p>
	
	<a href="<c:url value='/bookInfoView1' />">도서 정보 보기 1 (Model)</a><br>
    <a href="<c:url value='/bookInfoView2' />">도서 정보 보기 2 (ModelAndView)</a>
</body>
</html>