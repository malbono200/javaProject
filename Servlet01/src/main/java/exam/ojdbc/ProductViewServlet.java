package exam.ojdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unchecked")
@WebServlet("/productView2")
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ArrayList<ProductVO> productList = (ArrayList<ProductVO>)request.getAttribute("productList");
		
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgray'>");
		out.print("<td>상품번호</td><td>상품명</td><td>가격</td><td>재고</td><td>삭제</td></tr>");
		
		for(int i=0; i<productList.size(); i++) {
			ProductVO vo = productList.get(i);
			String productNo = vo.getProductNo();
			String productName = vo.getProductName();
			int price = vo.getPrice();
			int stock = vo.getStock();
			
			out.print("<tr><td>" + productNo + "</td><td>" +
								   productName + "</td><td>" +
								   price + "</td><td>" +
								   stock + "</td><td>" +
								   "<a href='/Servlet01/productDelete?productNo=" + productNo + "'>삭제</a></td></tr>"
					);
		}			
		out.print("</table></body></html>");
	}
}
