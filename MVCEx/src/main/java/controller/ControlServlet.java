package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductDAO;
import model.ProductDTO;


@WebServlet("/productSelect")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비지니스로직처리 요청
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductDTO> productList = dao.productSelect();
		//처리된 결과를 view로 전달 바인딩
		request.setAttribute("productList", productList);
		//포워딩되는 url은 jsp view
		RequestDispatcher dispatch = request.getRequestDispatcher("view/ProductListView.jsp");
		dispatch.forward(request, response); //request단의 attribute memList 전송됨
	}

}
