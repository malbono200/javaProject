<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <c:set var="isUpdate" value="${not empty prd}"/>
  <title>${isUpdate ? '상품 수정' : '상품 등록'}</title>
  <c:import url="/WEB-INF/views/layout/head.jsp"></c:import>
  <script>
    function checkPlayer() {
      let min = parseInt(document.getElementById('minPlayer').value);
      let max = parseInt(document.getElementById('maxPlayer').value);
      if (max < min) {
        alert('최대 인원은 최소 인원보다 작을 수 없어요.');
        return false;
      }
      return true;
    }
  </script>
</head>
<body>
  <c:import url="/WEB-INF/views/layout/top.jsp"></c:import>

  <section class="inner" id="adminForm">
    <h2 class="pageTitle">${isUpdate ? '상품 수정' : '상품 등록'}</h2>

    <form method="post" onsubmit="return checkPlayer();"
          action="<c:url value='${isUpdate ? "/admin/updateProduct" : "/admin/insertProduct"}'/>">

      <c:if test="${isUpdate}">
        <input type="hidden" name="prdNo" value="${prd.prdNo}">
      </c:if>

      <table class="orderTable">
        <c:if test="${isUpdate}">
          <tr><th>상품번호</th><td>${prd.prdNo}</td></tr>
        </c:if>
        <tr>
          <th>상품명</th>
          <td><input type="text" name="prdName" value="${prd.prdName}" required></td>
        </tr>
        <tr>
          <th>카테고리</th>
          <td>
            <select name="ctgId">
              <option value="1" ${prd.ctgId == '1' ? 'selected' : ''}>파티게임</option>
              <option value="2" ${prd.ctgId == '2' ? 'selected' : ''}>전략게임</option>
              <option value="3" ${prd.ctgId == '3' ? 'selected' : ''}>협력게임</option>
              <option value="4" ${prd.ctgId == '4' ? 'selected' : ''}>추리게임</option>
              <option value="5" ${prd.ctgId == '5' ? 'selected' : ''}>카드게임</option>
            </select>
          </td>
        </tr>
        <tr>
          <th>가격</th>
          <td><input type="number" name="prdPrice" value="${prd.prdPrice}" min="0" required> 원</td>
        </tr>
        <tr>
          <th>재고</th>
          <td><input type="number" name="prdStock" value="${prd.prdStock}" min="0" required> 개 (0이면 품절)</td>
        </tr>
        <tr>
          <th>제조사</th>
          <td><input type="text" name="prdCompany" value="${prd.prdCompany}"></td>
        </tr>
        <tr>
          <th>인원</th>
          <td>
            <input type="number" id="minPlayer" name="minPlayer" value="${prd.minPlayer}" min="1" required> ~
            <input type="number" id="maxPlayer" name="maxPlayer" value="${prd.maxPlayer}" min="1" required> 인
          </td>
        </tr>
        <tr>
          <th>플레이 시간</th>
          <td><input type="number" name="playTime" value="${prd.playTime}" min="1" required> 분</td>
        </tr>
        <tr>
          <th>난이도</th>
          <td>
            <select name="difficulty">
              <option value="1" ${prd.difficulty == 1 ? 'selected' : ''}>하</option>
              <option value="2" ${prd.difficulty == 2 ? 'selected' : ''}>중</option>
              <option value="3" ${prd.difficulty == 3 ? 'selected' : ''}>상</option>
            </select>
          </td>
        </tr>
        <tr>
          <th>상품 설명</th>
          <td><textarea name="prdDescript">${prd.prdDescript}</textarea></td>
        </tr>
      </table>

      <div class="cartBtns">
        <a class="btnLine" href="<c:url value='/admin/productList'/>">목록으로</a>
        <input type="submit" class="btnFill" value="${isUpdate ? '수정하기' : '등록하기'}">
      </div>
    </form>
  </section>

  <c:import url="/WEB-INF/views/layout/bottom.jsp"></c:import>
</body>
</html>