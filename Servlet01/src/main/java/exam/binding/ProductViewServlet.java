package exam.binding;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductViewServlet
 */
@SuppressWarnings("unchecked")
@WebServlet("/productView")
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 바인딩된 데이터 추출
		ArrayList<ProductVO> productList = (ArrayList<ProductVO>)request.getAttribute("productList");
		
		// 응답처리
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgray'>");
		out.print("<td>상품번호</td><td>상품명</td><td>가격</td><td>재고</td></tr>");

		for(int i=0; i<productList.size(); i++) {
			ProductVO vo = productList.get(i);
			String productNo = vo.getProductNo();
			String productName = vo.getProductName();
			int price = vo.getPrice();
			int stock = vo.getStock();
			
			out.print("<tr><td>" + productNo + "</td><td>" + productName + "</td><td>" 
			+ price + "</td><td>" + stock + "</td><td>"
			+ "<a href='/Servlet01/productDelete?productNo=" + productNo + "'>삭제</a></td></tr>");
		}
		
		out.print("</table></body></html>");
	}
}
