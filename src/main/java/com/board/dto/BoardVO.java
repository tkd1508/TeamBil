package com.board.dto;

import lombok.Data;

@Data
public class BoardVO {

	private int bno;
	private String title;
	private String content;
	private String writer;
	private String regdate; // simpleDateFormate 비슷한 것 같다.
	private String updateDate; // simpleDateFormate 비슷한 것 같다.
	private int replycnt;
	
}
