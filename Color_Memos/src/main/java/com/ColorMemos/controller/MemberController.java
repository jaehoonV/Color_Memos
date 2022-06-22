package com.ColorMemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ColorMemos.domain.MemberDTO;
import com.ColorMemos.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MemberController {

	@Autowired
	MemberService memberService;

	// 이메일 중복 체크
	@RequestMapping(value = "/userEmailChk", method = RequestMethod.POST)
	@ResponseBody
	public boolean userEmailChk(String email) throws Exception {

		// emailCheck 중복 이메일 존재하면 1 반환
		int result = memberService.emailCheck(email);

		System.out.println("emailCheck 결과값 = " + result);

		if (result != 0) {
			return false; // 중복 이메일이 존재
		} else {
			return true; // 중복 이메일 x
		}
	} // userEmailChk() 종료

	// 회원가입 POST
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String postRegister(MemberDTO memberDTO) throws Exception {
		System.out.println("email >>>>> " + memberDTO.getEmail());
		System.out.println("name >>>>> " + memberDTO.getUsername());
		System.out.println("password >>>>> " + memberDTO.getPassword());
		memberService.register(memberDTO);
		return "index";
	}

}
