package exam;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@SuppressWarnings("serial")
@WebServlet("/bookInsert")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String bookNo = request.getParameter("bookNo");
        String bookTitle = request.getParameter("bookTitle");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String pubYear = request.getParameter("pubYear");
        String pubMonth = request.getParameter("pubMonth");
        String pubDay = request.getParameter("pubDay");
        String stock = request.getParameter("stock");
        String pubNo = request.getParameter("pubNo");
        
        System.out.println("도서번호 : " + bookNo);
        System.out.println("도서명 : " + bookTitle);
        System.out.println("저자 : " + author);
        System.out.println("가격 : " + price);
        System.out.println("발행일 : " + pubYear + "-" + pubMonth + "-" + pubDay);
        System.out.println("재고 : " + stock);
        System.out.println("출판사번호 : " + pubNo);
	}

}
