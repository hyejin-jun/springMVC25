package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component  // spring이 의존성 처리해 줘!!!
@Data  // import lombok.Data;: DTO 처리용 (게터/세터, toString, equals 등 자동 생성)

public class Chef {
	
	private String name;
	private int age;

}
