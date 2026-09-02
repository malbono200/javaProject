<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품정보</title>
		<style>
			.cls1{
				font-size:40px;
				text-align:center;
			}

			.cls2{
				font-size:20px;
				text-align:center;
			}
		</style>
	</head>
	<body>
		<p class="cls1">상품정보</p>
		<table align="center" border="1" >
		   <tr align="center" bgcolor="lightgreen">
		         <td width="20%" ><b>상품번호</b></td>
		         <td width="20%" ><b>상품명</b></td>
		         <td width="20%"><b>가격</b></td>
		         <td width="20%" ><b>재고</b></td>
		   </tr>
		   <c:choose>
		   		<c:when test="${productList==null}">
		   			<tr>
		   				<td colspan=4><b>등록된 상품이 없습니다</b></td>
		   			</tr>
		   		</c:when>
		   		<c:when test="${productList!=null}">
		   			<c:forEach var= "product" items="${productList}">
		   			<tr>
		   				<td>${product.prdNo}</td>
		   				<td>${product.prdName}</td>
		   				<td>${product.price}</td>
		   				<td>${product.stock}</td>
		   			</tr>
		   			</c:forEach>
		   		</c:when>
		   </c:choose>
		</table>
	</body>
</html>