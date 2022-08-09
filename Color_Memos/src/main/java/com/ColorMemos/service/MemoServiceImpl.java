package com.ColorMemos.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.ColorMemos.domain.MemoDTO;
import com.ColorMemos.mapper.MemoMapper;
import com.ColorMemos.service.MemoService;

@Service
public class MemoServiceImpl implements MemoService{
	
	@Inject
	MemoMapper memoMapper;

	@Override
	public void memoRegister(MemoDTO memoDTO) throws Exception {
		System.out.println(">>>>>>>>>>>> MemoServiceImpl!! <<<<<<<<<<<< " + memoDTO);
		// 프로젝트 생성
		memoMapper.memoRegister(memoDTO);
		
	}

}
