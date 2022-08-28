package com.ColorMemos.domain;

import lombok.Data;

@Data
public class MemoDTO {
	private int mno; // 메모번호
	private String mname; // 메모 제목
	private String mdescription; // 메모
	private String regday; // 메모 작성일
	private String regid; // 작성자
	private String mcolor; // 메모 색상
	private String hide_gb; // 숨김 구분
	private String favorite_gb; // 즐겨찾기 구분
	private String delete_gb; // 삭제 구분
}
