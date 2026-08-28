package exam.forward;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/refresh01")
public class ServletFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String encodedName = (name != null) ? URLEncoder.encode(name, "utf-8") : "";
		
		response.setContentType("text/html;charset=utf-8");
		response.addHeader("Refresh", "1;url=refresh02?name=" + encodedName + "&id=" + id);
	}

}
