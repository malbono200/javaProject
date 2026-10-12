<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>주문내역</title>
  <c:import url="/WEB-INF/views/layout/head.jsp"></c:import>
</head>
<body>
  <c:import url="/WEB-INF/views/layout/top.jsp"></c:import>

  <section class="inner">
    <h2 class="pageTitle">주문내역</h2>

    <c:if test="${empty orderList}">
      <p class="emptyMsg">아직 주문한 상품이 없어요.</p>
    </c:if>

    <c:if test="${not empty orderList}">
      <table class="adminTable">
        <tr><th>주문일</th><th>주문번호</th><th>상품</th><th>결제 금액</th><th>배송 상태</th></tr>
        <c:forEach var="ord" items="${orderList}">
          <tr>
            <td><fmt:formatDate value="${ord.ordDate}" pattern="yyyy-MM-dd HH:mm"/></td>
            <td>${ord.ordNo}</td>
            <td class="left">${ord.orderItems}</td>
            <td><fmt:formatNumber value="${ord.totalPrice}" pattern="#,###"/>원</td>
            <td><span class="status ${ord.ordStatus == '배송완료' ? 'done' : (ord.ordStatus == '배송중' ? 'ing' : '')}">${ord.ordStatus}</span></td>
          </tr>
        </c:forEach>
      </table>
    </c:if>

    <div class="cartBtns listBtns">
      <a class="btnLine" href="<c:url value='/member/mypage'/>">마이페이지</a>
      <a class="btnFill" href="<c:url value='/'/>">쇼핑 계속하기</a>
    </div>
  </section>

  <c:import url="/WEB-INF/views/layout/bottom.jsp"></c:import>
</body>
</html>