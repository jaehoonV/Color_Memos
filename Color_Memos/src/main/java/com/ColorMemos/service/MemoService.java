package com.ColorMemos.service;

import java.util.Collection;
import java.util.List;

import com.ColorMemos.domain.MemoDTO;

public interface MemoService {

	// 메모 생성
	public void memoRegister(MemoDTO memoDTO) throws Exception;

	// 메모 리스트
	public List<MemoDTO> memoList(String email) throws Exception;
	
	// 메모 삭제
	public void memoDelete(String mno) throws Exception;
	
	// 삭제된 메모 리스트
	public List<MemoDTO> delt_memoList(String email) throws Exception;
	
	// 메모 복구
	public void memoRestore(String mno) throws Exception;
	
	// 메모 숨김
	public void memoHide(String mno) throws Exception;
	
	// 메모 숨김 구분값
	public int selectHideGB(String mno) throws Exception;
	
	// 메모 숨김 취소
	public void memoHideCancel(String mno) throws Exception;
	
	// 메모 즐겨찾기 구분값
	public int selectFavGB(String mno) throws Exception;
	
	// 메모 즐겨찾기
	public void memoFav(String mno) throws Exception;
	
	// 메모 즐겨찾기 취소
	public void memoFavCancel(String mno) throws Exception;
	
	// 메모 숨김제외 리스트
	public List<MemoDTO> memoList_h(String email) throws Exception;
	
	// 메모 수정
	public MemoDTO modifyMemo_mno(int mno) throws Exception;

}
