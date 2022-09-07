package com.ColorMemos.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.ColorMemos.domain.MemoDTO;
import com.ColorMemos.mapper.MemoMapper;
import com.ColorMemos.service.MemoService;

@Service
public class MemoServiceImpl implements MemoService{
	
	@Inject
	MemoMapper memoMapper;
	
	// 메모 생성
	@Override
	public void memoRegister(MemoDTO memoDTO) throws Exception {
		System.out.println(">>>>>>>>>>>> MemoServiceImpl!! <<<<<<<<<<<< " + memoDTO);
		memoMapper.memoRegister(memoDTO);
		
	}
	
	// 메모 리스트
	@Override
	public List<MemoDTO> memoList(String email) throws Exception {
		return memoMapper.memoList(email);
	}
	
	// 메모 삭제
	@Override
	public void memoDelete(String mno) throws Exception {
		memoMapper.memoDelete(mno);
	}
	
	// 삭제된 메모 리스트
	@Override
	public List<MemoDTO> delt_memoList(String email) throws Exception {
		return memoMapper.delt_memoList(email);
	}
	
	// 메모 복구
	@Override
	public void memoRestore(String mno) throws Exception {
		memoMapper.memoRestore(mno);
	}

}
