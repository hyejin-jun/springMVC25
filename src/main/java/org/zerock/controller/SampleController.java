package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j2;

@Controller  // servlet-context.xml에서 <context:component-scan base-package="org.zerock.controller" />용
@RequestMapping("/sample/*")  // http://192.168.111.104:80/controller/sample/모든 것에 반응
@Log4j2  // resorces 폴더에 log4j2.xml 필수

public class SampleController {
	
	@RequestMapping("")  //  http://192.168.111.104:80/controller/sample/""
	public void basic() {
		
		log.info("SampleController.basic()메서드 실행.....................................");
		log.info("리턴이 void이기 때문에 basic.jsp 파일을 찾습니다");
		log.info("현재 /WEB-INF/views/basic.jsp가 없음으로 크롬에는 오류가 납니다");  
		// 리턴이 void임:  파일 [WEB-INF/views/sample.jsp]를 찾을 수 없습니다.
		// 기본적으로 url 경로에 대한 jsp를 찾으려고 한다
	}  // basic() 종료

	
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})  
	// http://192.168.111.104:80/controller/sample/basic  >> get메서드와 post메서드에 동작
	public void basicGet() {
		
		log.info("SampleController.basicGet()메서드 실행.....................................");
		log.info("get 방식과 post 방식 둘 다 반응한다");
}  // basicGet() 종료
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		
		log.info("SampleController.basicGet2()메서드 실행.....................................");
		log.info("get 방식에 반응한다");
		
	}  // basicGet2() 종료
	
	@PatchMapping("/basicOnlyPost")
	public void basicPost2() {
		
		log.info("SampleController.basicPost2()메서드 실행.....................................");
		log.info("post 방식에 반응한다");

	}  // basicPost2() 종료
	
	@GetMapping("/ex01")  // http://192.168.111.104:80/controller/sample/ex01?name=kkkw&age=33
	public String ex01(SampleDTO dto) {  // SampleDTO dto = new sampleDTO();
		
		log.info("SampleController.ex01()메서드 실행.....................................");
		log.info("get 방식에 반응한다");
		log.info("입력 DTO 확인: " + dto);

		return "mbcex01";  // WEB-INF/views/ex01.jsp를 찾음  >> servlet-contex.xml이 하는 일
	
	}
	
	@GetMapping("/ex02")  // http://192.168.111.104:80/controller/sample/ex02
	public String ex02(@RequestParam("owner") String name, @RequestParam("age") int age) {  // SampleDTO dto = new sampleDTO();
		// 프론트 변수와 백엔드의 변수가 다를 때 쓴다 (되도록 쓰지 마라)
		
		log.info("name: " + name);
		log.info("age: " + age);

		return "ex02";  // WEB-INF/views/ex01.jsp를 찾음  >> servlet-contex.xml이 하는 일
	
	}
	
	@GetMapping("/ex02List")  // http://192.168.111.104:80/controller/sample/ex02List?ids=111&ids=222&ids=333
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {  // 리스트로 넘어오는 데이터 처리
		
		log.info("리스트로 넘어온 데이터 처리: " + ids);
		log.info("리스트로 2 번째 값 확인: " + ids.get(1));
		
		return "ex02List" ; 

	}
	
	@GetMapping("ex02Bean")
	public String ex02Bean(SampleDTOList list) {  // url 경로에 배열로 들어오는 파라미터
		// es02Bean?list[0].name=kkw&list[2].age=33
		
		log.info("list SampleDTOs: " + list);
		
		return "ex02Bean";

	}
	
	@GetMapping("/ex03")
	public String es03(TodoDTO todo) {
		
		log.info("todo: " +todo);
		
		return "ex03";
	}
	
	
	@GetMapping("/ex04")  // http://192.168.111.104:80/controller/sample/ex04
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {  // int page는 게시판에 페이징기법 예시
		// @ModelAttribute("page") 안 쓰면 백엔드에서는 전달이 되지만 프론트에는 전달 안 됨
		// 스프링에서 기본적으로 제공되는 model 객체를 사용하게 설정
		
		log.info("DTO: " + dto);  // name, age가 들어감
		log.info("PAGE: " + page);
		
		
		return "/sample/ex04";  // views/sample/ex04.jsp를 찾는다
		
	}
	
	@GetMapping("/ex05")
	public void ex05 () {
		
		log.info("SampleController.ex05 메서드 실행..........");  // 리턴이 void인 경우 자동으로 [/WEB-INF/views/sample/ex05.jsp]을 찾음
		// 초보자 사용 금지!!
		
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06 () {  // @ResponseBody SampleDTO: 응답 바디에 객체를 담아 리턴
		
		log.info("SampleController.ex06 메서드 실행.........");
		
		SampleDTO dto = new SampleDTO();
		dto.setName("kkw");
		dto.setAge(33);
		
		return dto;
		
	}
	

	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {  // @ResponsEntity<String> 응답 헤더 (200 ok, 404, 304를 만들어 리턴)
		
		log.info("SampleController.ex07 메서드 실행.........");
		
		String msg = "{\"name\":\"kkw\"}";  // json타입으로 {name: kkw} 
		
		HttpHeaders header = new HttpHeaders();
		header.add("COntent-Type", "application/json;charset=UTF-8");  // 헤더에 타입 추가용
		
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);  
		// msg에는 json 데이터, header에는 json 타입, 상태값 Ok면 200
		
		
		
	}
	
	
	
}






