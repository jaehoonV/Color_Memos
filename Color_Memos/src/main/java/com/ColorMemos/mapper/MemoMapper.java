package com.ColorMemos.mapper;

import java.util.List;

import com.ColorMemos.domain.MemoDTO;

public interface MemoMapper {

	// 메모 생성
	public void memoRegister(MemoDTO memoDTO) throws Exception;
	
	// 메모 리스트
	public List<MemoDTO> memoList(String email) throws Exception;


}
