package com.ColorMemos.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ColorMemos.domain.MemberDTO;
import com.ColorMemos.mapper.MemberMapper;

import com.ColorMemos.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberMapper memberMapper;
	
	// 이메일 중복 체크
	@Override
	public int emailCheck(String email) throws Exception {
		return memberMapper.emailCheck(email);
	}
	
	// 회원가입
	@Override
	public void register(MemberDTO memberDTO) throws Exception {
		memberMapper.register(memberDTO);
		
	}
	
	// 로그인
	@Override
	public boolean login(String email, String password) throws Exception {
		if(memberMapper.login(email, password) > 0) {
			return true;
		}
		return false;
	}
	
	// 회원 정보
	@Override
	public MemberDTO MemberInfo(String email) throws Exception {
		return memberMapper.MemberInfo(email);
	}

}
