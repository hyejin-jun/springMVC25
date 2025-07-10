package org.zerock.inception;

import org.apache.ibatis.javassist.compiler.NoFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class commonExceptionAdvice {  // MVC에서 예외 처리를 담당하는 공통적인 지원 클래스
	
	@ExceptionHandler(Exception.class)  // 내장된 예외처리 객체로 사용
	public String except(Exception ex, Model model) {
		//           예외 처리용 통로, 스프링의 데이터 관리용 객체 통로
		
		log.error("CommonExcertionAdvice.except()......");
		model.addAttribute("exception", ex);  // 예외 발생 값을 모델로 보냄
		log.error("예외 발생: " + ex.getMessage());  // 콘솔에 찍히는 에러
		log.error(model);  // 모델에 저장된 예외 문구 처리
		return "error_page";
	}  // 예외 처리도 스프링이 관리를 해야 함. servlet-context.xml에 scan을 해야 함

	
	@ExceptionHandler(NoFieldException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)  // 404 오류에 대한 핸들링
	public String handle404(NoHandlerFoundException ex) {
		return "custom404";  // custom.jsp로 감
	}
	
}
