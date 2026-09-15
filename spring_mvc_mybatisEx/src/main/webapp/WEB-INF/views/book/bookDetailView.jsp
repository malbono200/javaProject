<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세 조회</title>
	<script>
		function deleteCheck() {
			let answer = confirm("삭제하시겠습니까?");
			if(answer==true) {
				location.href="<c:url value='/product/deleteProduct/${dto.prdNo}'/>";
			}
		}
	</script>
</head>
<body>
    <h3>도서 상세 조회</h3>
    <table border="1" width="300">
        <tr><th>도서번호</th><td>${book.bookNo}</td></tr>
        <tr><th>도서명</th><td>${book.bookName}</td></tr>
        <tr><th>저자</th><td>${book.bookAuthor}</td></tr>
        <tr><th>가격</th><td>${book.bookPrice}</td></tr>
        <tr><th>재고</th><td>${book.bookStock}</td></tr>
        <tr><th>출간일</th><td><fmt:formatDate value="${book.bookDate}" pattern="yyyy-MM-dd" /></td></tr>
        <tr><th>출판사번호</th><td>${book.pubNo}</td></tr>
    </table><br>
    <a href="<c:url value='/book/updateBookForm/${book.bookNo}'/>">[수정]</a>
    <a href="<c:url value='/book/deleteBook/${book.bookNo}'/>">[삭제]</a>
    <a href="<c:url value='/'/>">[홈으로 이동]</a>
</body>
</html>