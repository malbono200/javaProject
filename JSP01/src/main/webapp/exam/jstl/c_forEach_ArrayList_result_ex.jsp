<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ArrayList EL forEach 표현</title>
	</head>
	<body>
		<table border="1" align="center">
			<tr align="center" bgcolor="#99ccff">
				<td width="20%"><b>상품번호</b></td>
				<td width="20%"><b>상품명</b></td>
				<td width="20%"><b>가격</b></td>
				<td width="20%"><b>제조사</b></td>
			</tr>
			<c:forEach var="data" items="${productList}">
			<tr align="center">
				<td>${data.prdNo}</td>
				<td>${data.prdName}</td>
				<td>${data.prdPrice}</td>
				<td>${data.prdCompany}</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>