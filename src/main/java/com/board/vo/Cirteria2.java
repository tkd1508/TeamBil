package com.board.vo;

import lombok.Data;

@Data
public class Cirteria {
	
	/* 총 페이지 수 */
	private int pageNum;
	/**/
	private int amuont;
	/* 검색타입 */
	private String type;
	/* 검색어 키워드 */
	private String keyword;
	/* 검색 타입 배열 */
	private String[] typeArr;
	
}
