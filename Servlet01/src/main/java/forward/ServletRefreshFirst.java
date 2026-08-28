package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first02")
public class ServletRefreshFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * refresh 통한 포워딩
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("addHeader()를 이용한 refresh 포워딩전 내용");
		out.println("</body></html>");
		//Refresh 속성 : 시간(초);url=맵핑이름
		response.addHeader("Refresh", "10;url=sec02");
	}

}
