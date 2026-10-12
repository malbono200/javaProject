<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>주문 완료</title>
  <c:import url="/WEB-INF/views/layout/head.jsp"></c:import>
</head>
<body>
  <c:import url="/WEB-INF/views/layout/top.jsp"></c:import>

  <section class="inner">
    <div class="orderDone">
      <i class="ti ti-circle-check"></i>
      <h2>주문이 완료되었어요</h2>
      <p>주문번호 <b>${ordNo}</b></p>
      <div class="cartBtns">
        <a class="btnLine" href="<c:url value='/member/mypage'/>">마이페이지</a>
        <a class="btnFill" href="<c:url value='/'/>">쇼핑 계속하기</a>
      </div>
    </div>
  </section>

  <c:import url="/WEB-INF/views/layout/bottom.jsp"></c:import>
</body>
</html>