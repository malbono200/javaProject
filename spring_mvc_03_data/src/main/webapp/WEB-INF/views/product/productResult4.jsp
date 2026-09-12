<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Result</title>
</head>
<body>
	상품번호 : ${productInfo.prdNo}<br>
    상품명 : ${productInfo.prdName}<br>
    가격 : ${productInfo.price}<br>
    제조회사 : ${productInfo.company}<br>
    제조일 : ${productInfo.prdDate}<br>
    재고 : ${productInfo.stock}<br>
</body>
</html>