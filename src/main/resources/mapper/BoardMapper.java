package org.mbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mbc.domain.BoardVO;

public interface BoardMapper {  // 인터페이스는 클래스와 다르게 메서드가 추상화처럼 표시
	// 추상 메서드는 시그니처만 있으며 {} 안에 실행문이 없다
	
	@Select("SELECT * FROM tbl_board WHERE bon > 0")  // bon > 0: pk로 선언되어 인덱싱으로 빠른 추출 가능
	public List<BoardVO> getList();  // 추상 메서드

}
