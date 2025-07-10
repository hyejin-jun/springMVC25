package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {

	private List<SampleDTO> list;  // DTO 객체를 가지고 있는 리스트
	
	public SampleDTOList() {  // 생성자
	
		list = new ArrayList<SampleDTO>();   // new SampleDTOList() >> 리스트에 DTO를 가지고 있는 객체 생성
		
	}
	
	
}
