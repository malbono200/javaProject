<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false" 
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var= "contextPath" value= "${pageContext.request.contextPath}"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>쇼핑몰</title>
	</head>
	<body>	
		<a href="${contextPath}/member">회원관리</a>
		<a href="${contextPath}/product/listProducts.do">상품관리</a>
		
		<c:choose>
		    <c:when test="${empty loginId}">
		        <h1>로그인</h1>
		        <c:if test="${not empty msg}"><p style="color:red">${msg}</p></c:if>
		        <form method="post" action="${contextPath}/member/login.do">
		            아이디: <input type="text" name="id"><br>
		            비밀번호: <input type="password" name="pwd"><br>
		            <input type="submit" value="로그인">
		        </form>
		    </c:when>
		    <c:otherwise>
		        <h1>${loginId}님 환영합니다</h1>
		        <a href="${contextPath}/member/listMembers.do">회원관리</a>
		        <a href="${contextPath}/product/listProducts.do">상품관리</a>
		    </c:otherwise>
		</c:choose>
		
	</body>
</html>
