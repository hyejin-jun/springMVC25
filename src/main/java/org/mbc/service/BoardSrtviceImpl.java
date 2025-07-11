package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;
import org.mbc.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2  // 로깅 처리용
@Service  // 이 클래스는 서비스 계층임을 명시
@AllArgsConstructor  // 생성자 자동 주입 (BoardSrtviceImpl < 이거 자동 생성)
public class BoardSrtviceImpl implements BoardService {
	// 조원이 실행문을 생성하는 용도로 활용: implements BoardService 필수 (구현 클래스)
	
	private BoardMapper mapper;  // 디비 쿼리용 객체 (CRUD)
	
	@Override
	public void register(BoardVO board) {  // 객체가 넘어오면 매퍼를 이용해서 데이터베이스엗 등록
		
		log.info("BOardServiceImpl.register 메서드 실행...............");
		
		mapper.insertSelectKey(board);
		log.info("정상 등록 후 리스트 출력 테스트....................");
		mapper.getList2();
	}

	@Override
	public BoardVO get(Long bno) {  // 게시물에 번호가 들어가면 매퍼의 select문이 동작
		
		log.info("BOardServiceImpl.get 메서드 실행...............");
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {  // 프론트에서 객체가 넘어오면 매터를 통해서 update 쿼리 실행
		
		log.info("BOardServiceImpl.modify 메서드 실행...............");
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {  // 프론트에서 번호가 넘어오면 매퍼를 통해서 delete 쿼리 실행
		
		log.info("BOardServiceImpl.remove 메서드 실행...............");
		return mapper.delete(bno)  == 1;
	}

	@Override
	public List<BoardVO> getList() {  // getList()가 호출되면 매퍼에 getList2()를 호출
		
		log.info("BoardServiceImpl.getList 메서드 실행..................");
		return mapper.getList2();
	}  
	
	
	

}
