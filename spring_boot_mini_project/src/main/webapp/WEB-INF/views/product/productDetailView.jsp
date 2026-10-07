<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>${prd.prdName}</title>
  <c:import url="/WEB-INF/views/layout/head.jsp"></c:import>
  <script src="<c:url value='/js/productDetail.js'/>"></script>
</head>
<body>
  <c:import url="/WEB-INF/views/layout/top.jsp"></c:import>

  <section class="inner">
    <div id="prdDetail">
      <!-- 왼쪽 : 아이콘 박스 -->
      <div class="detailImg"><i class="ti ti-dice-5"></i></div>

      <!-- 오른쪽 : 상품 정보 -->
      <div class="detailInfo">
        <a class="detailCtg" href="<c:url value='/product/productListCtg/${prd.ctgId}'/>">${ctgName}</a>
        <h2 class="detailName">${prd.prdName}</h2>
        <p class="detailCompany">${prd.prdCompany}</p>
        <p class="detailPrice">
          <span id="price" data-price="${prd.prdPrice}"><fmt:formatNumber value="${prd.prdPrice}" pattern="#,###"/></span>원
        </p>

        <!-- 게임 정보 : 인원 / 시간 / 난이도 -->
        <div class="gameInfo">
          <div><i class="ti ti-users"></i><p>인원</p><b>${prd.minPlayer}~${prd.maxPlayer}인</b></div>
          <div><i class="ti ti-clock"></i><p>플레이 시간</p><b>${prd.playTime}분</b></div>
          <div><i class="ti ti-flame"></i><p>난이도</p>
            <b>
              <c:choose>
                <c:when test="${prd.difficulty == 1}">하</c:when>
                <c:when test="${prd.difficulty == 2}">중</c:when>
                <c:otherwise>상</c:otherwise>
              </c:choose>
            </b>
          </div>
        </div>

        <p class="detailDesc">${prd.prdDescript}</p>

        <form method="post" action="<c:url value='/product/insertCart'/>">
          <input type="hidden" name="prdNo" value="${prd.prdNo}">

          <div class="qtyRow">
            <span>수량 (재고 <span id="stock" data-stock="${prd.prdStock}">${prd.prdStock}</span>개)</span>
            <div class="qtyBox">
              <input type="button" id="minusBtn" value="-">
              <input type="text" id="cartQty" name="cartQty" value="1" readonly>
              <input type="button" id="plusBtn" value="+">
            </div>
          </div>

          <div class="amountRow">
            <span>총 상품 금액</span>
            <strong><span id="amount"><fmt:formatNumber value="${prd.prdPrice}" pattern="#,###"/></span>원</strong>
          </div>

          <div class="detailBtns">
            <c:if test="${empty sessionScope.sid}">
              <a class="btnFill" href="<c:url value='/member/loginForm'/>">로그인 후 구매하기</a>
            </c:if>
            <c:if test="${not empty sessionScope.sid}">
              <input type="submit" class="btnLine" value="장바구니">
              <input type="submit" class="btnFill" value="바로 구매">
            </c:if>
          </div>
        </form>
      </div>
    </div>
  </section>

  <c:import url="/WEB-INF/views/layout/bottom.jsp"></c:import>
</body>
</html>