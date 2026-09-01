<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.* , exam.beans.ProductVO"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	ProductVO p1 = new ProductVO("001", "마우스", 30000, "A");
	ProductVO p2 = new ProductVO("002", "키보드", 50000, "B");
	ArrayList<ProductVO> productList = new ArrayList<>();
	productList.add(p1);
	productList.add(p2);
	
	request.setAttribute("productList", productList);
%>
<jsp:forward page="c_forEach_ArrayList_result_ex.jsp"/>