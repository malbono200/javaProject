<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>주문서 작성</title>
  <c:import url="/WEB-INF/views/layout/head.jsp"></c:import>
  <script src="https://t1.kakaocdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script src="<c:url value='/js/searchZip.js'/>"></script>
</head>
<body>
  <c:import url="/WEB-INF/views/layout/top.jsp"></c:import>

  <section class="inner">
    <h2 class="pageTitle">주문서 작성</h2>
    <c:set var="hp" value="${fn:split(mem.memHp, '-')}"/>

    <form method="post" action="<c:url value='/product/orderComplete'/>">

      <!-- 1. 주문 상품 -->
      <h3 class="orderSub">주문 상품</h3>
      <ul class="cartList orderList">
        <c:forEach var="prd" items="${cartList}">
          <li>
            <span class="cartThumb"><i class="ti ti-dice-5"></i></span>
            <span class="cartName">${prd.prdName}</span>
            <span class="cartPrice"><fmt:formatNumber value="${prd.prdPrice}" pattern="#,###"/>원</span>
            <span>${prd.cartQty}개</span>
            <span class="cartAmount">
              <c:set var="amount" value="${prd.prdPrice * prd.cartQty}"/>
              <c:set var="sum" value="${sum + amount}"/>
              <fmt:formatNumber value="${amount}" pattern="#,###"/>원
            </span>
          </li>
        </c:forEach>
      </ul>
      <div class="cartSummary">
        <span>총 결제 금액</span>
        <strong><fmt:formatNumber value="${sum}" pattern="#,###"/>원</strong>
      </div>

      <!-- 2. 배송 정보 (회원 정보가 기본값, 수정 가능) -->
      <h3 class="orderSub">배송 정보</h3>
      <table class="orderTable">
        <tr>
          <th>받는 사람</th>
          <td><input type="text" name="ordReceiver" value="${mem.memName}" required></td>
        </tr>
        <tr>
          <th>연락처</th>
          <td>
            <input type="text" name="hp1" value="${hp[0]}" class="hp" required> -
            <input type="text" name="hp2" value="${hp[1]}" class="hp" required> -
            <input type="text" name="hp3" value="${hp[2]}" class="hp" required>
          </td>
        </tr>
        <tr>
          <th>배송지</th>
          <td>
            <input type="text" id="memZipcode" name="ordRcvZipcode" value="${mem.memZipcode}" placeholder="우편번호" readonly>
            <input type="button" id="searchZipBtn" value="우편번호 찾기"><br>
            <input type="text" id="memAddress1" name="ordRcvAddress1" value="${mem.memAddress1}" placeholder="주소" class="wide" readonly><br>
            <input type="text" id="memAddress2" name="ordRcvAddress2" value="${mem.memAddress2}" placeholder="상세 주소" class="wide">
          </td>
        </tr>
      </table>

      <div class="cartBtns">
        <a class="btnLine" href="<c:url value='/product/cartList'/>">장바구니로</a>
        <input type="submit" class="btnFill" value="주문 완료">
      </div>
    </form>
  </section>

  <c:import url="/WEB-INF/views/layout/bottom.jsp"></c:import>
</body>
</html>