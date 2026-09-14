<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>
</head>
<body>
	<h3>MyBatis 사용 DB 연동</h3>
	<h4>상품 관리 시스템</h4>
	<br>
	<a href="<c:url value='/product/listAllProduct'/>">전체상품조회</a><br>
	<a href="<c:url value='/product/newProductForm'/>">상품 등록</a>
</body>
</html>