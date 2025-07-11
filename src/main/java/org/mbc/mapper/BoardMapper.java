package org.mbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mbc.domain.BoardVO;

public interface BoardMapper {
	// interface는 클래스와 다르게 메서드가 추상화처럼 되어 있다.
	// 추상메서드는 시그니쳐만 있으며 {실행문이 없다.} 그래서 ; 끝난다.
	
	
	// 어노테이션으로 간단한 쿼리문은 가능하나 복잡한 쿼리문은 버그가 있다
	@Select("SELECT * FROM tbl_board WHERE bno > 0") // bno > 0 pk로 선언되어있어서 인덱싱으로 빠른 추출
	public List<BoardVO> getList(); // 추상메서드

	
	// 그래서 xml을 이용하여 sql 처리를 진행
	// xml을 이용하려면 src/main/resources/org/mbc/mapper 폴더를 생성 후 인터페이스 이름과 같은 xml 파일 생성
	// 이것이 마이바이트 사용법
	
	public List<BoardVO> getList2();  // xml을 이용한 쿼리 처리문
	
	// c: insert 데이터를 삽입하는 쿼리문
	// insert 처리 후에 결과를 int로 받거나 pk를 먼저 생성 후 insert가 되는 방법
	public void insert (BoardVO board);  // xml에서 쿼리 작성
	
	public void insertSelectKey(BoardVO board);  // xml에서 쿼리 작성
	
	public BoardVO read(Long bno);  // xml 쿼리 작성 (번호가 들어가면 객체로 나옴)
	
	public int delete(long bno);  // 번호가 들어가면 삭제 후 몇 개가 삭제됐는지 리턴
	
	public int update(BoardVO board);  // 번호가 들어가면 필드 수정 후 몇 개가 수정됐는지 리턴
}
