package com.ColorMemos.mapper;

import com.ColorMemos.domain.MemberDTO;

public interface MemberMapper {
	
	// 이메일 중복 체크
	public int emailCheck(String email);
	
	// 회원가입
	public void register(MemberDTO memberDTO) throws Exception;

}
