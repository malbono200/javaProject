package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductDAO;
import model.ProductVO;


@WebServlet("/product")
public class ProductControllerFront extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO productDAO;
	
	public void init() {
		productDAO = new ProductDAO(); // 초기화 메소드에서 DAO 생성
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null; // forward 시킬 location 저장
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String loginId = (String) request.getSession().getAttribute("loginId");
	    if (loginId == null) {
	        request.setAttribute("msg", "로그인이 필요합니다");
	        request.getRequestDispatcher("/main/main.jsp").forward(request, response);
	        return;
	    }
		
		String action = request.getPathInfo();
		System.out.println("action : " + action);

		if (action == null || action.equals("/listProducts.do")) {
			List<ProductVO> productList = productDAO.listProducts();
			request.setAttribute("productList", productList);
			nextPage = "/view/listProducts.jsp"; // 포워딩될 url
		} else if (action.equals("/productForm.do")) {
			nextPage = "/view/productForm.jsp";

		} else if (action.equals("/addProduct.do")) { 
			String prdNo = request.getParameter("prdNo");
			String prdName = request.getParameter("prdName");
			int price = Integer.parseInt(request.getParameter("price"));
			int stock = Integer.parseInt(request.getParameter("stock"));
			ProductVO prdVO = new ProductVO(prdNo, prdName, price, stock);
			productDAO.addProduct(prdVO); 

			request.setAttribute("msg", "addProduct");

			nextPage = "/product/listProducts.do";
			
		} else if (action.equals("/modProductForm.do")) { 
			String prdNo = request.getParameter("prdNo");
			ProductVO prdInfo = productDAO.findProduct(prdNo); 
			request.setAttribute("prdInfo", prdInfo);
			nextPage = "/view/modProductForm.jsp";
			
		} else if (action.equals("/modProduct.do")) {
			String prdNo = request.getParameter("prdNo");
			String prdName = request.getParameter("prdName");
			int price = Integer.parseInt(request.getParameter("price"));
			int stock = Integer.parseInt(request.getParameter("stock"));
			ProductVO prdVO = new ProductVO(prdNo, prdName, price, stock);
			productDAO.modProduct(prdVO);

			request.setAttribute("msg", "modified");
			nextPage = "/product/listProducts.do";
			
		} else if (action.equals("/delProduct.do")) {
			String prdNo = request.getParameter("prdNo");
			productDAO.delProduct(prdNo);
			request.setAttribute("msg", "deleted");
			nextPage = "/product/listProducts.do";
			
		} else {
			List<ProductVO> productList = productDAO.listProducts();
			request.setAttribute("productList", productList);
			nextPage = "/view/listProducts.jsp";
		}

		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);

	}
}
