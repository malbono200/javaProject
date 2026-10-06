<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>마이페이지</title>
	<c:import url="/WEB-INF/views/layout/head.jsp"/>
	<script src="https://t1.kakaocdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="<c:url value='/js/searchZip.js'/>"></script>
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/views/layout/top.jsp"/>
		<section>
			<h1 id="title">마이페이지</h1>
			
			<!-- (1) 회원정보 : 본인정보 확인 + 수정 -->
			<h3>회원정보</h3>
			<!-- 저장된 휴대폰 번호(010-1234-5678)를 3칸으로 분리 -->
			<c:set var="hp" value="${fn:split(mem.memHp, '-')}"/>
			<form method="post" action="<c:url value='/member/updateMember'/>">
				<table border="1" width="600">
					<tr><th>ID</th><td>${mem.memId}</td></tr>
					<tr><th>가입일</th><td><fmt:formatDate value="${mem.memJoinDate}" pattern="yyyy-MM-dd"/></td></tr>
					<tr><th>성명</th>
						<td><input type="text" name="memName" value="${mem.memName}"></td></tr>
					<tr><th>비밀번호</th>
						<td><input type="password" name="memPwd" placeholder="변경할 때만 입력" autocomplete="new-password"></td></tr>
					<tr><th>휴대폰 번호</th>
						<td><input type="text" name="memHp1" size="3" value="${hp[0]}">
							- <input type="text" name="memHp2" size="4" value="${hp[1]}">
							- <input type="text" name="memHp3" size="4" value="${hp[2]}"></td></tr>
					<tr><th>이메일</th>
						<td><input type="email" name="memEmail" value="${mem.memEmail}"></td></tr>
					<tr><th>주소</th>
						<td><input type="text" id="memZipcode" name="memZipcode" size="5" value="${mem.memZipcode}" readonly>
							<input type="button" id="searchZipBtn" value="우편번호 찾기"><br>
							<input type="text" id="memAddress1" name="memAddress1" size="40" value="${mem.memAddress1}" readonly>
							<input type="text" id="memAddress2" name="memAddress2" value="${mem.memAddress2}" placeholder="상세 주소 입력"></td></tr>
				</table><br>
				<input type="submit" value="회원정보 수정">
				<input type="reset" value="되돌리기">
			</form>
			<br>
			
			<!-- (2) 회원 탈퇴 : 확인창에서 [확인]을 눌렀을 때만 전송 -->
			<form method="post" action="<c:url value='/member/deleteMember'/>"
				  onsubmit="return confirm('정말 탈퇴하시겠습니까?\n장바구니와 주문내역도 모두 삭제됩니다.');">
				<input type="submit" value="회원 탈퇴">
			</form>
			<br><br>
			
			<!-- (3) 주문내역 -->
			<h3>주문내역</h3>
			<button type="button" onclick="location.href='<c:url value="/order/orderListView"/>'">주문내역 보기</button>
		</section>
		<c:import url="/WEB-INF/views/layout/bottom.jsp"/>
	</div>
</body>
</html>