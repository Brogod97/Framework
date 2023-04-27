package edu.kh.comm.main.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
//	@ExceptionHandler(SQLEc.class)
//	public String exceptionHandler(Exception e, Model model) {
//		e.printStackTrace();
//		
//		model.addAttribute("errorMessage", "서비스 이용 중 문제가 발생했습니다.");
//		model.addAttribute("e", e);
//		
//		return "common/error"; 
//	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) { // ArgumentResolver가 있어서 매개변수로 사용 가능
		e.printStackTrace();
		
		model.addAttribute("errorMessage", "서비스 이용 중 문제가 발생했습니다.");
		model.addAttribute("e", e);
		
		return "common/error";
	}

}

