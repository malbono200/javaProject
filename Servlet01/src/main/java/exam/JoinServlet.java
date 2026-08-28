package exam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String phone1 = request.getParameter("phone1");
        String phone2 = request.getParameter("phone2");
        String phone3 = request.getParameter("phone3");
        String grade = request.getParameter("grade");
        String[] interests = request.getParameterValues("interest");
        String major = request.getParameter("major");
        
        System.out.println("성명 : " + name);
        System.out.println("ID : " + id);
        System.out.println("비밀번호 : " + pwd);
        System.out.println("휴대폰 번호 : " + phone1 + "-" + phone2 + "-" + phone3);
        System.out.println("학년 : " + grade);
        
        System.out.print("관심분야 : ");
        if (interests != null) {
            for (String interest : interests) {
                System.out.print(interest + " ");
            }
        }
        
        System.out.println();
        System.out.println("학과 : " + major);
	}

}
