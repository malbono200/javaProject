<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Result</title>
</head>
<body>
	상품번호 : ${prdNo }<br>
    상품명 : ${prdName }<br>
    가격 : ${Price }<br>
    제조회사 : ${Company }<br>
    제조일 : ${prdDate }<br>
    재고 : ${Stock }<br>
    
    <a href="<c:url value='/product/detail/${prdName}' />">상품명 전달 상세 링크</a><br>
    <a href="<c:url value='/product/detail/${prdName}/${Stock}/${prdNo}' />">상품명/재고/상품번호 전달 상세 링크</a><br>
    
</body>
</html>