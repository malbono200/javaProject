package exam.binding;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductBindingServlet
 */
@WebServlet("/productBind")
public class ProductBindingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductVO vo1 = new ProductVO("0001", "마우스", 100000, 5);
		ProductVO vo2 = new ProductVO("0002", "키보드", 200000, 10);
		ProductVO vo3 = new ProductVO("0003", "모니터", 300000, 15);
		
		ArrayList<ProductVO> productList = new ArrayList<>();
		productList.add(vo1);
		productList.add(vo2);
		productList.add(vo3);

		request.setAttribute("productList", productList);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("productView");
		dispatch.forward(request, response);
	}
}
