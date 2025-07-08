package org.zerock.sample;

import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Configuration
@ToString
@Getter
// @AllArgsConstructor  // 모든 필드값을 이용하여 생성자 주입
@RequiredArgsConstructor  // @NonNull만 생성자 넣음
public class SampleHotel {  // 묵시적 자동 주입 / 스프링의 의존성 주입은 생성자 수입과 세터 주입을 자주 사용
	// 생성자 주입: lombok이 알아서 파라미터를 생성 (객체 생성시 의존성 주입이 필요하므로 조금 더 엄격하게 의존성 주입을 체크)
	// 세터 주입: 값을 저장할 때 자동으로 객체를  생성 @Setter(onMethod_ =@Autowired)

	@NonNull
	private Chef chef;  // 필드

	private Restaurant restaurant;

	private String name;
	
}
