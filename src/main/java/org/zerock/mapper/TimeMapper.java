package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {  // 인터페이스는 추상 메서드를 사용 (추상화: 메서드명만 존재하고 실행문 없음)
	// 사용하려면 class에 implements 인터페이스명을 사용
	
	@Select("SELECT sysDate FROM dual")  // 주의사항: ;(세미콜론) 없이 삽입
	public String getTime();  // 인터페이스에 선언된 메서드는 추상 메서드로 실행문이 없다
	// 관례: sql 쿼리문은 대문자

	public String getTime2();  // 추상 메서드로 실행문 없음
	// 이 메서드가 호출되면 마이바티스에서 xml을 찾음 (src/main/resources/org/zerock/mapper/TimgMapper.xml을 활용
  	
}
