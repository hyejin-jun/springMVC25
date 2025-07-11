package org.mbc.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mbc.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardServiceTests {
	
	@Setter(onMethod_ =@Autowired)
	private BoardService service;  // 인터페이스를 필드로 선언 (인터페이스에 연결된 구현 클래스 자동 연동: BoardSrtviceImpl)
	
	@Test
	public void testExist() {
		
		log.info("============================================");
		log.info(service);  //  빈 객체가 아님을 테스트
		assertNotNull(service);
		
		// org.mbc.service.BoardSrtviceImpl@3c78e551: 인터페이스를 호출했는데 구현 클래스가 호출됨을 확인함
		// 구현클래스에 구현 메서드를 실행문에 작성하면 동작함
	}
	
	@Test
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		board.setTitle("서비스에서 만든 제목");
		board.setContent("서비스에서 만든 내용");
		board.setWriter("서비스 님");
		
		service.register(board);
		
		log.info("============================================");
		log.info("생성된 게시물의 번호: " + board.getBno());
	}
	
	@Test
	public void testGetList() {
		
		log.info("============================================");
		service.getList().forEach(Board -> log.info(Board));
		
	}
	
	@Test
	public void testGet() {
		
		log.info(service.get(8L));
	}

	@Test
	public void testDelete() {
		
		log.info("삭제된 결과: " + service.remove(2L));
	}
	
	public void testUpdate() {
		
		BoardVO board = service.get(5L);
		
		if(board == null) {
			log.info("찾는 게시물이 없습니당");
			return;
		}
		
		board.setTitle("서비스에서 수정된 제목");
		log.info("삭제된 결과: " + service.modify(board));
	}
	
	
	
}




