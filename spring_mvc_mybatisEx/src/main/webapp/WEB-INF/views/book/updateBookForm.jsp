<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 수정</title>
</head>
<body>
    <h3>도서 수정</h3>
    <img src="<c:url value='/resources/images/apple.png'/>" width="120" height="120"><br><br>
    <form action="<c:url value='/book/updateBook'/>" method="post">
        도서번호: ${book.bookNo}
        <input type="hidden" name="bookNo" value="${book.bookNo}"><br>
        도서명: <input type="text" name="bookName" value="${book.bookName}"><br>
        저자: <input type="text" name="bookAuthor" value="${book.bookAuthor}"><br>
        가격: <input type="number" name="bookPrice" value="${book.bookPrice}"><br>
        재고: <input type="number" name="bookStock" value="${book.bookStock}"><br>
        출간일: <input type="date" name="bookDate" value="<fmt:formatDate value='${book.bookDate}' pattern='yyyy-MM-dd'/>"><br>
        출판사번호: <input type="text" name="pubNo" value="${book.pubNo}"><br><br>
        <input type="submit" value="수정">
    </form>
    <a href="<c:url value='/book/detailViewBook/${book.bookNo}'/>">취소</a>
</body>
</html>