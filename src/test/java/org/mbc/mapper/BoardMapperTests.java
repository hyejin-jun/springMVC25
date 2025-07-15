package org.mbc.mapper;

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
public class BoardMapperTests {
	// board에서 사용하는 데이터베이스 테스트용!!!
	
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;  // 인터페이스로 만든 객체를 세터로 연결
	
	@Test // import org.junit.Test; (메서드 단위로 테스트)
	public void testGetList() {
		
		mapper.getList().forEach(board -> log.info(board) );
		// 인터페이스.메서드.for문   결과객체 
		//                             -> 람다식(인터페이스용)
		//                                log.info 콘솔에 출력(board.toString)
	}
	
	
	@Test // import org.junit.Test; (메서드 단위로 테스트)
	public void testGetListXML() {
		
		mapper.getList2().forEach(board -> log.info(board) );
		// 인터페이스.메서드.for문   결과객체 
		//                             -> 람다식(인터페이스용)
		//                                log.info 콘솔에 출력(board.toString)
	}
	
	
	
	@Test
	public void testInsert() {
		
		BoardVO board = new BoardVO(); 
		board.setTitle("제발 오류없어라");
		board.setContent("이번엔 누구냐!!!");
		board.setWriter("김기원");
		
		mapper.insert(board);
		
		log.info(board);
		
	}
	
	
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		board.setTitle("이번엔 제발!!!! 번호나와롸");
		board.setContent("내 게시물에 번호는? ");
		board.setWriter("김기원");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
		log.info("내가만든 게시물의 번호는 : " + board.getBno());
		
	}
	
	@Test
	public void testRead() {
		
		BoardVO board = mapper.read(1L); // 1번 게시물을 read 메서드로 보내고 객체로 받는다.
		
		log.info(board);
		
	}
	
	
	@Test
	public void testDelete() {
		
		int count = mapper.delete(3L);
		log.info("삭제된 갯수 출력 : " + count + "건");
	}
	
	
	
	@Test
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		board.setBno(5L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("김수정");
		
		int count = mapper.update(board);
		log.info("수정된 갯수 : " + count + "건");
		log.info("수정된 객체 출력 :" + board);
		
		
		
		
		
	}
}
