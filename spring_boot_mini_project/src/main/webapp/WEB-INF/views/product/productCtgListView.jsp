<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>${ctgName}</title>
  <c:import url="/WEB-INF/views/layout/head.jsp"></c:import>
</head>
<body>
  <c:import url="/WEB-INF/views/layout/top.jsp"></c:import>

  <section class="inner">
    <h2 class="pageTitle">${ctgName}</h2>
    <p class="pageSub">총 ${prdList.size()}개의 상품</p>

    <c:if test="${empty prdList}">
      <p class="emptyMsg">등록된 상품이 없어요.</p>
    </c:if>

    <ul class="prdList">
      <c:forEach var="prd" items="${prdList}">
        <li class="prdItem">
          <a href="<c:url value='/product/detailViewProduct/${prd.prdNo}'/>">
            <div class="prdImg"><i class="ti ti-dice-5"></i></div>
            <p class="prdName">${prd.prdName}</p>
            <p class="prdPrice"><fmt:formatNumber value="${prd.prdPrice}" pattern="#,###"/>원</p>
            <div class="prdTags">
              <span class="tag">${prd.minPlayer}~${prd.maxPlayer}인</span>
              <span class="tag">${prd.playTime}분</span>
            </div>
          </a>
        </li>
      </c:forEach>
    </ul>
  </section>

  <c:import url="/WEB-INF/views/layout/bottom.jsp"></c:import>
</body>
</html>