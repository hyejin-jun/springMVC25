package org.mbc.controller;

import org.mbc.domain.BoardVO;
import org.mbc.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*")  // http://192.168.111.104:80/board/* (모든 경로)
@AllArgsConstructor  // 생성자 자동 주입 (모든 필드를 보고 생성자 생성)
public class BoradController { 
	
	// 리스트와 CRUD를 담당하는 분기 설정 (URL)
	
	private BoardService service ;
	
	@GetMapping("/list")  // 리스트 보기
	public void list(Model model) {
	
	// 모델은 스프링에서 데이터 관리용 객체 (예전에는 request 영역, session 영억과 같은 의미)
	log.info("BoardController.list 메서드 실행..............");  // http://192.168.111.104:80/board/list
	model.addAttribute("list", service.getList());  // 프로트에서 ${list}로 활용 / (for문 사용)
	}
	
	@PostMapping("/register") // 등록
	public String register(BoardVO board, RedirectAttributes rttr) {  // edirectAttributes rttr: 성공 후 이동할 경로를 기입
		
		log.info("BoardController.register 메서드 실행..............");
		service.register(board);  // 객체 등록 성공??: 이동할 경로 배정
		rttr.addFlashAttribute("result", board.getBno());  // 일회용 값을 생성 > 이름: result (나중에 프론트에서 alert 용으로 활용)
		return "redirect:/board/list";  // 성공시 다음 페이지
	}
	
	@GetMapping("/get")  // 하나 보기
	public void get(@RequestParam("bno") Long bno, Model model) {  
		// url을 통해 넘어온 bno = 5 문자열은 long 타입으로 받음 / 모델 객체에 삽입
		
		log.info("BoardController.get 메서드 실행..............");
		model.addAttribute("board", service.get(bno));
		// 서비스에서 매퍼를 다녀와 객체를 가지고 온 것을 모델 객체에 삽입
		// 프론트에서 ${board.bno} ${board.title} ${board.content} 출력 가능
	}
	
	@PostMapping("/modify")  // 수정
	public String  modify(BoardVO board, RedirectAttributes rttr) {  
		// 프론트에서 수정된 boardVO가 넘어오면 update 쿼리가 실행 후 결과는 boolean으로 나옴
		
		log.info("BoardController.modify 메서드 실행..............");
		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");  // 성공시 프론트에 result라는 이름으로 success 값을 일회용으로 전송
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		// 프론트에서 삭제할 번호가 넘어오면 delete 쿼리가 실행되고 결과가 boolean으로 나옴
		
		log.info("BoardController.remove 메서드 실행..............");
		if(service.remove(bno)) {  // 서비스에 다녀온 결과가 true면 아래 실행문 실행
			rttr.addFlashAttribute("result", "success"); 
		}
		return "redirect:/board/list";  // 처리 후 실행 페이지
	}
	
}




