package org.zerock.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice // 예외처리목적
@Log4j2
public class CommonExceptionAdvice {
	// mvc에서 예외처리를 담당하는 공통적인 지원 클래스

	@ExceptionHandler(Exception.class) // 내장된 예외처리 객체로 사용시 
	public String except(Exception ex, Model model) {
	//                   예외처리용 통로 , 스프링의 데이터관리용 객체 통로
		
		log.error("CommonExceptionAdvice.except() .....");
		model.addAttribute("exception", ex); // 예외발생값을 모델 객체로 보냄
		log.error("예외 발생 : " + ex.getMessage()); // 콘솔에 찍히는 에러
		log.error(model); // 모델에 저장된 예외문구 처리
		return "error_page";
	} // 예외처리도 스프링이 관리를 해야 한다. servlet-context.xml에 scan을 해야 한다.
	
}
