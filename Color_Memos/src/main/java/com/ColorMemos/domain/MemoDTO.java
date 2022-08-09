package com.ColorMemos.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemoDTO {
	private int mNo; // 메모번호
	private String mName; // 메모 제목
	private String mDescription; // 메모
	private Date regDay; // 메모 작성일
	private String regID; // 작성자
	private String mColor; // 메모 색상
}
