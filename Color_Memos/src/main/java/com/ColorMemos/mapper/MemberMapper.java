package com.ColorMemos.mapper;

import com.ColorMemos.domain.MemberDTO;

public interface MemberMapper {
	
	// 이메일 중복 체크
	public int emailCheck(String email);
	
	// 회원가입
	public void register(MemberDTO memberDTO) throws Exception;
	
	// 로그인
	public int login(String email, String password) throws Exception;
	
	// 회원 정보
	public MemberDTO MemberInfo(String email) throws Exception;

}
