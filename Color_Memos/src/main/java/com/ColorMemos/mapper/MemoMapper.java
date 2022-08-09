package com.ColorMemos.mapper;

import com.ColorMemos.domain.MemoDTO;

public interface MemoMapper {

	// 메모 생성
	public void memoRegister(MemoDTO memoDTO) throws Exception;


}
