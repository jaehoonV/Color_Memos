package com.ColorMemos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ColorMemos.domain.MemoDTO;
import com.ColorMemos.service.MemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MemoController {

	@Autowired
	MemoService memoService;

	// memo 생성
	@RequestMapping(value = "/memoRegist", method = RequestMethod.POST)
	public void makeProject(MemoDTO memoDTO, @RequestParam("mname") String mname, @RequestParam("memo_text") String memo_text, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("mname >>>>> " + mname);
		System.out.println("mdescription >>>>> " + memo_text);
		
		// 세션 생성
		HttpSession session = request.getSession();

		// 세션 가져와서 memoDTO에 저장
		String email = (String) session.getAttribute("email");
		memoDTO.setRegid(email);
		
		// 메모
		memoDTO.setMname(mname);
		memoDTO.setMdescription(memo_text);
		
		// 메모 색상
		if (memoDTO.getMcolor() == null) {
			memoDTO.setMcolor("Default");
		}

		// 메모 생성
		memoService.memoRegister(memoDTO);

		response.getWriter().print(true);
	}

}
