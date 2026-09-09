<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false" 
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>    
<html>
<head>
   <meta charset="UTF-8">
   <title>상품 정보 출력창</title>
<style>
     .cls1 {
       font-size:40px;
       text-align:center;
     }
    
     .cls2 {
       font-size:20px;
       text-align:center;
     }
  </style>
</head>
<body>
 <p class="cls1">상품정보</p>
   <table align="center" border="1" >
      <tr align="center" bgcolor="lightgreen">
         <td width="7%"><b>상품번호</b></td>
         <td width="7%"><b>상품명</b></td>
         <td width="7%"><b>가격</b></td>
         <td width="7%"><b>재고</b></td>
   	  </tr>
   	  <c:choose>
   	  	<c:when test="${empty productList}">
   	  		<tr>
				<td colspan=4>
					<b>등록된 상품이 없습니다</b>
				</td>
			</tr>
   	  	</c:when>
   	  	<c:when test="${!empty productList}">
   	  		<c:forEach var="prd" items="${productList}">
	   	  		<tr>
					<td>
						${prd.prdNo}
					</td>
					<td>
						${prd.prdName}
					</td>
					<td>
						${prd.price}
					</td>
					<td>
						${prd.stock}
					</td>
				</tr>
			</c:forEach>
   	  	</c:when>
   	  </c:choose>
   	 </table>
   	 <a href="${contextPath}/product/productForm.do"><p class="cls2">상품 등록하기</p></a>
</body>
</html>