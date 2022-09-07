package com.ColorMemos.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ColorMemos.domain.MemberDTO;
import com.ColorMemos.domain.MemoDTO;
import com.ColorMemos.service.MemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MemoController {

	@Autowired
	MemoService memoService;

	// memo 생성
	@RequestMapping(value = "/memoRegist", method = RequestMethod.POST)
	public void makeProject(MemoDTO memoDTO, @RequestParam("mname") String mname,
			@RequestParam("memo_text") String memo_text, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
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

	@RequestMapping(value = "/memoList", method = RequestMethod.POST)
	@ResponseBody
	public List<MemoDTO> memoList(Model model, HttpServletRequest request, MemoDTO memoDTO) throws Exception {
		System.out.println("memo list!!");

		List<MemoDTO> memolist = new ArrayList<>();

		// 세션 생성
		HttpSession session = request.getSession();

		// email 세션 가져옴
		String email = (String) session.getAttribute("email");

		// memoList
		memolist.addAll(memoService.memoList(email));

		return memolist;
	}

	@RequestMapping(value = "/delt_memoList", method = RequestMethod.POST)
	@ResponseBody
	public List<MemoDTO> delt_memoList(Model model, HttpServletRequest request, MemoDTO memoDTO) throws Exception {
		System.out.println("delete memo list!!");

		List<MemoDTO> delt_memolist = new ArrayList<>();

		// 세션 생성
		HttpSession session = request.getSession();

		// email 세션 가져옴
		String email = (String) session.getAttribute("email");

		// memoList
		delt_memolist.addAll(memoService.delt_memoList(email));

		return delt_memolist;
	}

	// memo 삭제
	@RequestMapping(value = "/memoDelete", method = RequestMethod.POST)
	public void makeDelete(@RequestParam("mno") String mno, HttpServletResponse response) throws Exception {
		System.out.println("mno >>>>> " + mno);
		// 메모 삭제
		memoService.memoDelete(mno);

		response.getWriter().print(true);
	}

	// memo 복구
	@RequestMapping(value = "/memoRestore", method = RequestMethod.POST)
	public void memoRestore(@RequestParam("mno") String mno, HttpServletResponse response) throws Exception {
		System.out.println("mno >>>>> " + mno);
		// 메모 복구
		memoService.memoRestore(mno);

		response.getWriter().print(true);
	}

}
