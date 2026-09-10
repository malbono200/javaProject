package com.spring_mvc.projectData;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewController {

	//http://localhost:8080/projectData
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	//컨트롤러에서 처리해서 구성한 데이터를 view 페이지인 showInfo.jsp로 전달
	//전달관리는 frontcontroller가 진행
	//showInfo 메소드 : 객체 주입(DI) -> Model 인터페이스가 참조할 수 있는 구현객체 주입
	@RequestMapping("/showInfo")
	public String showInfo(Model model) {
		model.addAttribute("name","홍길동");
		model.addAttribute("age", 30);
		//return될 때 model객체도 자동으로 프론트컨트롤러에 전달됨 -> 뷰쪽으로 model을 포워딩
		return "showInfo";
	}
	
	//ModelAndView 객체 통해서 data와 view를 프론트컨트롤러에게 반환
	@RequestMapping("/showInfoMV")
	public ModelAndView showInfo2(ModelAndView mv) {
		mv.addObject("name","이몽룡");
		mv.addObject("address", "서울");
		mv.setViewName("showInfoMV"); //showInfoMV.jsp
		return mv;
	}
}
