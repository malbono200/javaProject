<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>쇼핑몰 이름</title>
  <c:import url="/WEB-INF/views/layout/head.jsp"></c:import>
</head>
<body>
  <c:import url="/WEB-INF/views/layout/top.jsp"></c:import>

  <section class="inner">

    <!-- 슬라이드 배너 -->
    <article id="slideShow">
      <div id="slidePanel">
        <div class="slide slide1">
          <div class="slideText">
            <span class="tag">태그</span>
            <h2>배너 제목 1</h2>
            <p>배너 설명 문구</p>
            <a href="#" class="btnMain">보러 가기</a>
          </div>
        </div>
        <div class="slide slide2">
          <div class="slideText">
            <span class="tag">태그</span>
            <h2>배너 제목 2</h2>
            <p>배너 설명 문구</p>
            <a href="#" class="btnMain">보러 가기</a>
          </div>
        </div>
        <div class="slide slide3">
          <div class="slideText">
            <span class="tag">태그</span>
            <h2>배너 제목 3</h2>
            <p>배너 설명 문구</p>
            <a href="#" class="btnMain">보러 가기</a>
          </div>
        </div>
      </div>
      <button id="prevBtn"><i class="ti ti-chevron-left"></i></button>
      <button id="nextBtn"><i class="ti ti-chevron-right"></i></button>
      <div id="slideDots">
        <span class="dot on"></span><span class="dot"></span><span class="dot"></span>
      </div>
    </article>

    <!-- 인원 선택 -->
    <article id="playerBox">
      <div>
        <h3>오늘은 몇 명이서 하세요?</h3>
        <p>인원을 고르면 맞는 게임만 보여드려요</p>
      </div>
      <div id="playerBtns">
        <a href="#"><i class="ti ti-user"></i> 혼자</a>
        <a href="#"><i class="ti ti-users"></i> 2인</a>
        <a href="#">3~4인</a>
        <a href="#">5인 이상</a>
      </div>
    </article>

    <!-- 인기 게임 -->
    <div class="sectionTitle">
      <h3>이번 주 인기 게임</h3>
      <a href="#">더보기 <i class="ti ti-chevron-right"></i></a>
    </div>
    <ul class="prdList">
      <li class="prdItem">
        <a href="#">
          <div class="prdImg"></div>
          <p class="prdName">보드게임 1</p>
          <p class="prdPrice">0원</p>
          <div class="prdTags"><span class="tag">0~0인</span><span class="tag">0분</span></div>
        </a>
      </li>
      <li class="prdItem">
        <a href="#">
          <div class="prdImg"></div>
          <p class="prdName">보드게임 2</p>
          <p class="prdPrice">0원</p>
          <div class="prdTags"><span class="tag">0~0인</span><span class="tag">0분</span></div>
        </a>
      </li>
      <li class="prdItem">
        <a href="#">
          <div class="prdImg"></div>
          <p class="prdName">보드게임 3</p>
          <p class="prdPrice">0원</p>
          <div class="prdTags"><span class="tag">0~0인</span><span class="tag">0분</span></div>
        </a>
      </li>
      <li class="prdItem">
        <a href="#">
          <div class="prdImg"></div>
          <p class="prdName">보드게임 4</p>
          <p class="prdPrice">0원</p>
          <div class="prdTags"><span class="tag">0~0인</span><span class="tag">0분</span></div>
        </a>
      </li>
    </ul>

    <!-- 카테고리 바로가기 -->
    <div class="sectionTitle"><h3>카테고리별 둘러보기</h3></div>
    <ul class="ctgList">
      <li><a href="<c:url value='/product/productListCtg/1'/>"><i class="ti ti-confetti"></i>파티게임</a></li>
      <li><a href="<c:url value='/product/productListCtg/2'/>"><i class="ti ti-chess"></i>전략게임</a></li>
      <li><a href="<c:url value='/product/productListCtg/3'/>"><i class="ti ti-users-group"></i>협력게임</a></li>
      <li><a href="<c:url value='/product/productListCtg/4'/>"><i class="ti ti-spy"></i>추리게임</a></li>
      <li><a href="<c:url value='/product/productListCtg/5'/>"><i class="ti ti-cards"></i>카드게임</a></li>
    </ul>
  </section>

  <c:import url="/WEB-INF/views/layout/bottom.jsp"></c:import>

  <script src="<c:url value='/js/script.js'/>"></script>
</body>
</html>