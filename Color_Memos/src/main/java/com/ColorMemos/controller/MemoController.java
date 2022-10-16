package com.ColorMemos.controller;

import java.util.ArrayList;
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

	@RequestMapping(value = "/memoList", method = RequestMethod.GET)
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

	// 메모 숨김제외 리스트
	@RequestMapping(value = "/memoList_h", method = RequestMethod.GET)
	@ResponseBody
	public List<MemoDTO> memoList_h(Model model, HttpServletRequest request, MemoDTO memoDTO) throws Exception {
		System.out.println("memo list hide!!");

		List<MemoDTO> memolist = new ArrayList<>();

		// 세션 생성
		HttpSession session = request.getSession();

		// email 세션 가져옴
		String email = (String) session.getAttribute("email");

		// memoList
		memolist.addAll(memoService.memoList_h(email));

		return memolist;
	}

	@RequestMapping(value = "/delt_memoList", method = RequestMethod.GET)
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

	// memo 숨김
	@RequestMapping(value = "/memoHide", method = RequestMethod.POST)
	public void memoHide(@RequestParam("mno") String mno, HttpServletResponse response) throws Exception {
		System.out.println("mno >>>>> " + mno);
		int hide_gb = memoService.selectHideGB(mno);

		// 메모 숨김
		if (hide_gb == 0) {
			memoService.memoHide(mno);
		} else {
			memoService.memoHideCancel(mno);
		}

		response.getWriter().print(true);
	}

	// memo 즐겨찾기
	@RequestMapping(value = "/memoFav", method = RequestMethod.POST)
	public void memoFav(@RequestParam("mno") String mno, HttpServletResponse response) throws Exception {
		System.out.println("mno >>>>> " + mno);
		int fav_gb = memoService.selectFavGB(mno);

		// 메모 숨김
		if (fav_gb == 0) {
			memoService.memoFav(mno);
		} else {
			memoService.memoFavCancel(mno);
		}

		response.getWriter().print(true);
	}

	// 메모 수정 검색
	@ResponseBody
	@RequestMapping(value = "/modifyMemo_mno", method = RequestMethod.POST)
	public MemoDTO modifyMemo_mno(@RequestParam("mno") int mno) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>modifyMemo_mno<<<<<<<<<<<");
		// 글 검색
		return memoService.modifyMemo_mno(mno);
	}

	// 매모 수정
	@ResponseBody
	@RequestMapping(value = "/modifyMemo", method = RequestMethod.POST)
	public void modifyMemo(MemoDTO memoDTO, @RequestParam("mname") String mname,
			@RequestParam("mdescription") String mdescription, @RequestParam("mno") int mno,
			HttpServletResponse response) throws Exception {
		System.out.println(">>>>>>>>>modifyMemo<<<<<<<<<<");

		// 메모
		memoDTO.setMno(mno);
		memoDTO.setMname(mname);
		memoDTO.setMdescription(mdescription);
		System.out.println(memoDTO);

		// 메모 수정
		memoService.modifyMemo(memoDTO);

		response.getWriter().print(true);
	}

}
