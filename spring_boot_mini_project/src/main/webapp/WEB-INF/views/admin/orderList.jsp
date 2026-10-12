<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>주문 관리</title>
  <c:import url="/WEB-INF/views/layout/head.jsp"></c:import>
</head>
<body>
  <c:import url="/WEB-INF/views/layout/top.jsp"></c:import>

  <section class="inner">
    <c:if test="${not empty msg}"><script>alert('${msg}');</script></c:if>

    <h2 class="pageTitle">주문 관리</h2>
    <p class="pageSub">총 ${orderList.size()}건의 주문</p>

    <table class="adminTable">
      <tr>
        <th>주문번호 / 주문일</th><th>주문자</th><th>받는 사람</th><th>배송지</th>
        <th>상품</th><th>금액</th><th>배송 상태</th>
      </tr>
      <c:forEach var="ord" items="${orderList}">
        <tr>
          <td>${ord.ordNo}<br><small><fmt:formatDate value="${ord.ordDate}" pattern="yyyy-MM-dd HH:mm"/></small></td>
          <td>${ord.memId}</td>
          <td>${ord.ordReceiver}<br><small>${ord.ordRcvPhone}</small></td>
          <td class="left">${ord.ordRcvAddress1} ${ord.ordRcvAddress2}</td>
          <td class="left">${ord.orderItems}</td>
          <td><fmt:formatNumber value="${ord.totalPrice}" pattern="#,###"/>원</td>
          <td>
            <form method="post" action="<c:url value='/admin/updateOrderStatus'/>" class="statusForm">
              <input type="hidden" name="ordNo" value="${ord.ordNo}">
              <select name="ordStatus">
                <option ${ord.ordStatus == '주문완료' ? 'selected' : ''}>주문완료</option>
                <option ${ord.ordStatus == '배송중' ? 'selected' : ''}>배송중</option>
                <option ${ord.ordStatus == '배송완료' ? 'selected' : ''}>배송완료</option>
              </select>
              <button type="submit">변경</button>
            </form>
          </td>
        </tr>
      </c:forEach>
    </table>
  </section>

  <c:import url="/WEB-INF/views/layout/bottom.jsp"></c:import>
</body>
</html>