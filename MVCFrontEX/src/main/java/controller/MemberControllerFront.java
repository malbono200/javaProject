package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

/*
 *  /member/로 시작하는 모든 uri(servlet path)
 *  /member/abc, member/list...
 *  
 */
@WebServlet("/member/*")
public class MemberControllerFront extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;

	public void init() {
		memberDAO = new MemberDAO(); //초기화 메소드에서 DAO 생성
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null; //forward 시킬 location 저장
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action : " + action);
		// /member/list로 요청했다면 action에는 /List를 저장하게됨
		
		// /member/listMembers.do 또는 /member -> 회원목록
		if(action == null || action.equals("/listMembers.do")) {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/view/listMembers.jsp"; //포워딩될 url
		} else if(action.equals("/memberForm.do")) {
			nextPage = "/view/memberForm.jsp";
			
		} else if(action.equals("/addmember.do")) { //회원가입 진행 후
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memVO = new MemberVO(id, pwd, name, email);
			memberDAO.addMember(memVO); //회원가입 완료
			
			request.setAttribute("msf", "addMember");
			
			//금방 가입된 결과를 포함하는 회원 목록을 확인
			nextPage = "/member/listMembers.do";
		} else if(action.equals("/modMemberForm.do")) { //회원정보 수정
			String id = request.getParameter("id");
			MemberVO memInfo = memberDAO.findMember(id); //수정한다고 하는 회원 정보 데이터를 반환
			request.setAttribute("memInfo", memInfo);
			nextPage="/view/modMemberForm.jsp";
		} else if(action.equals("/modMember.do")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memVO = new MemberVO(id, pwd, name, email);
			memberDAO.modMember(memVO);
			
			request.setAttribute("msg", "modified");
			nextPage="/member/listMembers.do";
		} else if(action.equals("/deLMember.do")) {
			String id = request.getParameter("id");
			memberDAO.delMember(id);
			request.setAttribute("msg", "deleted");
			nextPage="/member/listMembers.do";
			
		} else if (action.equals("/login.do")) {
		    String id = request.getParameter("id");
		    String pwd = request.getParameter("pwd");
		    MemberVO memInfo = memberDAO.findMember(id);   

		    if (memInfo != null && memInfo.getPwd().equals(pwd)) {   // pwd는 자바 코드에서 직접 비교
		        request.getSession().setAttribute("loginId", memInfo.getId());
		        nextPage = "/main/main.jsp";
		    } else {
		        request.setAttribute("msg", "로그인 실패");
		        nextPage = "/main/main.jsp";
		    } 
		} else {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/view/listMembers.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
		
	}
}
