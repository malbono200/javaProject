<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>장바구니</title>
  <c:import url="/WEB-INF/views/layout/head.jsp"></c:import>
  <script src="<c:url value='/js/cartListView.js'/>"></script>
</head>
<body>
  <c:import url="/WEB-INF/views/layout/top.jsp"></c:import>

  <section class="inner">
    <h2 class="pageTitle">장바구니</h2>

    <!-- 비어 있을 때 -->
    <c:if test="${empty cartList}">
      <p class="emptyMsg">장바구니가 비어 있어요.</p>
      <div class="cartBtns">
        <a class="btnFill" href="<c:url value='/'/>">쇼핑 계속하기</a>
      </div>
    </c:if>

    <!-- 상품이 있을 때 -->
    <c:if test="${not empty cartList}">
      <form method="post" action="<c:url value='/product/orderForm'/>">
        <div class="cartTop">
          <label><input type="checkbox" id="allCheck"> 전체 선택</label>
          <input type="button" id="deleteCartBtn" value="선택 삭제">
        </div>

        <ul class="cartList">
          <c:forEach var="prd" items="${cartList}">
            <li>
              <input type="checkbox" class="chkDelete" value="${prd.cartNo}">
              <a class="cartThumb" href="<c:url value='/product/detailViewProduct/${prd.prdNo}'/>"><i class="ti ti-dice-5"></i></a>
              <a class="cartName" href="<c:url value='/product/detailViewProduct/${prd.prdNo}'/>">${prd.prdName}</a>
              <span class="cartPrice">
                <span class="price" data-price="${prd.prdPrice}"><fmt:formatNumber value="${prd.prdPrice}" pattern="#,###"/></span>원
              </span>
              <div>
                <input type="number" class="cartQty" name="cartQty" value="${prd.cartQty}" min="1" max="${prd.prdStock}">
                <input type="hidden" name="cartNo" value="${prd.cartNo}">
              </div>
              <span class="cartAmount">
                <c:set var="amount" value="${prd.prdPrice * prd.cartQty}"/>
                <c:set var="sum" value="${sum + amount}"/>
                <span class="amount" data-amount="${amount}"><fmt:formatNumber value="${amount}" pattern="#,###"/></span>원
              </span>
            </li>
          </c:forEach>
        </ul>                  

        <div class="cartSummary">
          <span>총 구매 예정 금액</span>
          <strong><span id="total"><fmt:formatNumber value="${sum}" pattern="#,###"/></span>원</strong>
        </div>

        <div class="cartBtns">
          <a class="btnLine" href="<c:url value='/'/>">쇼핑 계속하기</a>
          <input type="submit" class="btnFill" value="주문하기">
        </div>
      </form>
    </c:if>
  </section>

  <c:import url="/WEB-INF/views/layout/bottom.jsp"></c:import>
</body>
</html>