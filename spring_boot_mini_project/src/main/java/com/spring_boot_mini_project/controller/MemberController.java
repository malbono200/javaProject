package com.spring_boot_mini_project.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot_mini_project.dto.MemberDTO;
import com.spring_boot_mini_project.service.IMemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	@Qualifier("MemberService")
	IMemberService memService;
	
	//로그인 폼 요청
	@GetMapping("/member/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	//로그인 처리
	@ResponseBody
	@PostMapping("/member/login")
	public String loginCheck(@RequestParam HashMap<String, Object> param, HttpSession session) {
		String result = memService.loginCheck(param);
		//로그인 성공시 session 속성 추가->로그인 유지
		if("success".equals(result)) {
			System.out.println((String)param.get("id"));
			session.setAttribute("sid", param.get("id"));
			MemberDTO mem = memService.selectMember((String)param.get("id"));
			session.setAttribute("srole", mem.getMemRole());
		}
		return result;
	}
	
	@GetMapping("/member/logout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//회원가입 폼
	@GetMapping("/member/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	//id 중복 체크
	@ResponseBody
	@PostMapping("/member/idCheck")
	public int idCheck(@RequestParam String id) {
		String id_res = memService.idCheck(id);
		int result=0;
		if(id_res != null) { 
			result=1;
		}
		return result;
	}
	
	//회원가입
	@PostMapping("/member/join")
	public String join(MemberDTO dto, @RequestParam("memHp1") String memHp1, @RequestParam("memHp2") String memHp2, @RequestParam("memHp3") String memHp3) {
		String memHp = memHp1 + "-" + memHp2 + "-" + memHp3;
		dto.setMemHp(memHp);
		memService.insertMember(dto); 
		return "redirect:/member/loginForm"; 
	}
	
	//마이페이지
	@GetMapping("/member/mypage")
	public String myPage(HttpSession session, Model model) {
		String memId = (String)session.getAttribute("sid");
		if(memId == null) return "redirect:/member/loginForm";
		model.addAttribute("mem", memService.selectMember(memId));
		return "member/mypage";
	}
	
	//회원정보 수정
	@PostMapping("/member/updateMember")
	public String updateMember(MemberDTO dto, @RequestParam("memHp1") String memHp1, @RequestParam("memHp2") String memHp2, @RequestParam("memHp3") String memHp3, HttpSession session) {
		String memId = (String)session.getAttribute("sid");
		if(memId == null) return "redirect:/member/loginForm";
		dto.setMemId(memId); 
		dto.setMemHp(memHp1 + "-" + memHp2 + "-" + memHp3);
		memService.updateMember(dto);
		return "redirect:/member/mypage";
	}
	
	//회원 탈퇴
	@PostMapping("/member/deleteMember")
	public String deleteMember(HttpSession session) {
		String memId = (String)session.getAttribute("sid");
		if(memId == null) return "redirect:/member/loginForm";
		memService.deleteMember(memId);
		session.invalidate(); 
		return "redirect:/";
	}
}
