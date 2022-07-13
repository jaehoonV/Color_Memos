package com.ColorMemos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	// 로그인 post방식
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Login(HttpServletRequest request, @RequestParam("email") String email,
			@RequestParam("password") String password, HttpServletResponse response) throws Exception {

		// 세션 생성
		HttpSession session = request.getSession();

		if (memberService.login(email, password)) {
			session.setAttribute("email", email);
		} else {
			return "index";
		}

		return "redirect:/mainPage";
	}

	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	public String projectMain(Model model, HttpServletRequest request, MemberDTO memberDTO) throws Exception {
		// 세션 생성
		HttpSession session = request.getSession();

		// email 세션 가져옴
		String email = (String) session.getAttribute("email");

		// 회원 로그인 정보 가져옴
		/* memberDTO = memberService.MemberInfo(email); */
		// 모델에 회원 정보 set
		/* model.addAttribute("memberInfo", memberDTO); */

		return "jsp/mainPage";
	}

	// 로그인 post방식
	@RequestMapping(value = "/th_login", method = RequestMethod.POST)
	public String th_Login(HttpServletRequest request, @RequestParam("email") String email,
			@RequestParam("password") String password, HttpServletResponse response) throws Exception {

		// 세션 생성
		HttpSession session = request.getSession();

		if (memberService.login(email, password)) {
			session.setAttribute("email", email);
		} else {
			return "index";
		}

		return "redirect:/th_mainPage";
	}

	@RequestMapping(value = "/th_mainPage", method = RequestMethod.GET)
	public String th_projectMain(Model model, HttpServletRequest request, MemberDTO memberDTO) throws Exception {
		// 세션 생성
		HttpSession session = request.getSession();

		// email 세션 가져옴
		String email = (String) session.getAttribute("email");

		// 회원 로그인 정보 가져옴
		/* memberDTO = memberService.MemberInfo(email); */
		// 모델에 회원 정보 set
		/* model.addAttribute("memberInfo", memberDTO); */

		return "th_mainPage";
	}

}
