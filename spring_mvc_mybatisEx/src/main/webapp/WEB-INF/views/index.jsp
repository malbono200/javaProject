<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
</head>
<body>
    <h3>MyBatis 사용 DB 연동</h3>
    <h4>도서 관리 시스템<img src="<c:url value='/resources/image/apple.png'/>"/></h4>
    <br>
    <a href="<c:url value='/book/listAllBook'/>">전체도서조회</a><br>
    <a href="<c:url value='/book/newBookForm'/>">도서 등록</a><br>
    <a href="<c:url value='/book/bookSearchForm1'/>">도서 검색1</a><br>
	<a href="<c:url value='/book/bookSearchForm2'/>">도서 검색2</a><br>
	<a href="<c:url value='/book/bookSearchForm3'/>">도서 검색3</a><br>
</body>
</html>