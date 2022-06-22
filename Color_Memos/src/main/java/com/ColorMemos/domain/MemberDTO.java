package com.ColorMemos.domain;

import com.ColorMemos.domain.MemberDTO;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String email; // 회원 이메일
	private String password; // 회원 비밀번호
	private String username; // 회원 이름

}
