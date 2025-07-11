package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;

public interface BoardService {  // 인터페이스는 단독으로 사용할 수 없는 객체
	// 여기에서 선언한 메서드는 무조건 추상 메서드로 사용 (실행문 없이 끝: ; 이렇게 끝)
	// 인터페이스를 사용하려면 구현 클래스를 만들고 실행문 삽입
	// 인터페이시를 사용하는 이유: 조장이 메서드명을 강제로 세팅
	
	public void register(BoardVO board);  // 조장이 만든 메서드명 (시그니처): 게시판 등록용 메서드
	
	public BoardVO get(Long bno);  // 번호를 넣으면 객체가 나와야 한다: 게시글 자세히 보기
	
	public boolean modify(BoardVO board);  // 객체가 들어가서 수정이 됐는지 T/F로 나옴: 게시글 수정
	
	public boolean remove(Long bno);  // 객체가 들어가서 삭제됐는지 T/F로 나옴: 게시글 삭제
	
	public List<BoardVO> getList();  // 이 메서드가 호출되면 리스트 타입으로 BoardVO 객체들이 넘어옴
	// List: 동적 리스트 / <>  제네릭: 강제로 객체 타입 정함

}
