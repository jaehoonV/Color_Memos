package com.ColorMemos.service;

import com.ColorMemos.domain.MemoDTO;

public interface MemoService {

	// 메모 생성
	public void memoRegister(MemoDTO memoDTO) throws Exception;

}
