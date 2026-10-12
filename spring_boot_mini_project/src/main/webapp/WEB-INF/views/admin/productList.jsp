<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>상품 관리</title>
  <c:import url="/WEB-INF/views/layout/head.jsp"></c:import>
</head>
<body>
  <c:import url="/WEB-INF/views/layout/top.jsp"></c:import>

  <section class="inner">
    <c:if test="${not empty msg}"><script>alert('${msg}');</script></c:if>

    <div class="adminHead">
      <h2 class="pageTitle">상품 관리</h2>
      <a class="btnFill" href="<c:url value='/admin/productForm'/>">+ 상품 등록</a>
    </div>
    <p class="pageSub">총 ${prdList.size()}개의 상품</p>

    <table class="adminTable">
      <tr>
        <th>번호</th><th>카테고리</th><th>상품명</th><th>가격</th><th>재고</th>
        <th>인원</th><th>시간</th><th>난이도</th><th>등록일</th><th>관리</th>
      </tr>
      <c:forEach var="prd" items="${prdList}">
        <tr>
          <td>${prd.prdNo}</td>
          <td>${ctgNames[prd.ctgId]}</td>
          <td class="left"><a href="<c:url value='/product/detailViewProduct/${prd.prdNo}'/>">${prd.prdName}</a></td>
          <td><fmt:formatNumber value="${prd.prdPrice}" pattern="#,###"/>원</td>
          <td>
            <c:choose>
              <c:when test="${prd.prdStock == 0}"><span class="soldOut">품절</span></c:when>
              <c:otherwise>${prd.prdStock}</c:otherwise>
            </c:choose>
          </td>
          <td>${prd.minPlayer}~${prd.maxPlayer}인</td>
          <td>${prd.playTime}분</td>
          <td>
            <c:choose>
              <c:when test="${prd.difficulty == 1}">하</c:when>
              <c:when test="${prd.difficulty == 2}">중</c:when>
              <c:otherwise>상</c:otherwise>
            </c:choose>
          </td>
          <td><fmt:formatDate value="${prd.prdDate}" pattern="yyyy-MM-dd"/></td>
          <td>
            <div class="rowBtns">
              <a href="<c:url value='/admin/productUpdateForm/${prd.prdNo}'/>">수정</a>
              <form method="post" action="<c:url value='/admin/deleteProduct/${prd.prdNo}'/>"
                    onsubmit="return confirm('${prd.prdName} 상품을 삭제할까요?');">
                <button type="submit">삭제</button>
              </form>
            </div>
          </td>
        </tr>
      </c:forEach>
    </table>
  </section>

  <c:import url="/WEB-INF/views/layout/bottom.jsp"></c:import>
</body>
</html>