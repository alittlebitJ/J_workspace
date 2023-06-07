package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/") // get/post 구분 안 함
	public String mainForward(Model model) {		
		// Spring MVC : /webapp/WEB-INF/views/common/main.jsp
		// Spring Boot(+thymeleaf 템플릿 엔진) : src/main/resources/templates/common/main.html 
		
		return "common/main";
	}

}
