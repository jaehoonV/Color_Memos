package com.ColorMemos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ColorMemos.domain.MemoDTO;
import com.ColorMemos.service.MemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MemoController {
	
	@Autowired
	MemoService memoService;
	
	// project 생성
		@RequestMapping(value = "/memoRegist", method = RequestMethod.POST)
		public String makeProject(MemoDTO memoDTO, HttpServletRequest request, RedirectAttributes rttr)
				throws Exception {
			System.out.println("mName >>>>> " + memoDTO.getMName());
			System.out.println("mDescription >>>>> " + memoDTO.getMDescription());

			// 세션 생성
			HttpSession session = request.getSession();

			// memberInfo 세션 가져와서 memberDTO에 저장
			String email = (String) session.getAttribute("email");

			// memberDTO에서 이메일 가져오기
			memoDTO.setRegID(email);
			if(memoDTO.getMColor() == null) {
				memoDTO.setMColor("Default");
			}

			// 프로젝트 생성, 프로젝트 회원 등록
			memoService.memoRegister(memoDTO);

			rttr.addFlashAttribute("makeMemoResult", "success");

			return "jsp/mainPage";
		}

}
