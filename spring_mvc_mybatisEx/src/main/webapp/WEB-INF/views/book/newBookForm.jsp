<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookForm</title>
</head>
<body>
    <h3>도서 등록</h3>
    <form method="post" action="<c:url value='/book/insertBook'/>">
        도서번호: <input type="text" name="bookNo"><br>
        도서명: <input type="text" name="bookName"><br>
        저자: <input type="text" name="bookAuthor"><br>
        가격: <input type="number" name="bookPrice"><br>
        재고: <input type="number" name="bookStock"><br>
        출간일: <input type="date" name="bookDate"><br>
        출판사번호: <input type="text" name="pubNo"><br><br>
        <input type="submit" value="등록">
    </form>
    <a href="<c:url value='/book/listAllBook'/>">목록으로</a>
</body>
</html>