<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 관리자 바 : 관리자(ADMIN) 로그인 시에만 표시 -->
<c:if test="${sessionScope.srole == 'ADMIN'}">
  <div id="adminBar">
    <div class="inner">
      <span><i class="ti ti-shield-lock"></i> 관리자 모드</span>
      <ul>
        <li><a href="#">상품 등록</a></li>
        <li><a href="#">상품 목록·수정</a></li>
        <li><a href="#">재고 관리</a></li>
        <li><a href="#">주문 관리</a></li>
        <li><a href="#">회원 관리</a></li>
      </ul>
    </div>
  </div>
</c:if>

<header>
  <div class="inner" id="headerBox">
    <div id="logoBox"><a href="<c:url value='/'/>">LOGO</a></div>

    <form id="searchBox">
      <input type="text" placeholder="어떤 게임을 찾으세요?">
      <button type="button"><i class="ti ti-search"></i></button>
    </form>

    <div id="topMenuBox">
      <!-- 로그인 안 된 경우 -->
      <c:if test="${empty sessionScope.sid}">
        <a href="<c:url value='/member/loginForm'/>">로그인</a>
        <a href="<c:url value='/member/joinForm'/>">회원가입</a>
      </c:if>
      <!-- 로그인 된 경우 -->
      <c:if test="${not empty sessionScope.sid}">
        <span>${sessionScope.sid}님</span>
        <a href="<c:url value='/member/logout'/>">로그아웃</a>
        <a href="<c:url value='/member/mypage'/>">마이페이지</a>
      </c:if>
      <a href="<c:url value='/product/cartList'/>"><i class="ti ti-shopping-cart"></i></a>
    </div>
  </div>
</header>

<nav id="mainMenu">
  <div class="inner">
    <ul>
      <li><a href="<c:url value='/product/productListCtg/1'/>">카테고리 1</a></li>
      <li><a href="<c:url value='/product/productListCtg/2'/>">카테고리 2</a></li>
      <li><a href="<c:url value='/product/productListCtg/3'/>">카테고리 3</a></li>
      <li><a href="<c:url value='/product/productListCtg/4'/>">카테고리 4</a></li>
      <li><a href="<c:url value='/product/productListCtg/5'/>">카테고리 5</a></li>
      <li class="event"><a href="#">이벤트</a></li>
    </ul>
  </div>
</nav>