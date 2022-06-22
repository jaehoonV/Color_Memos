package com.ColorMemos.service;

import com.ColorMemos.domain.MemberDTO;

public interface MemberService {

	// 이메일 중복 체크
	public int emailCheck(String email) throws Exception;
	
	// 회원가입
	public void register(MemberDTO memberDTO) throws Exception;

}
