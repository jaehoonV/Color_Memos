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
	
	// 메모 숨김
	@Override
	public void memoHide(String mno) throws Exception {
		memoMapper.memoHide(mno);
	}
	
	// 메모 숨김 구분값
	@Override
	public int selectHideGB(String mno) throws Exception {
		return memoMapper.selectHideGB(mno);
	}
	
	// 메모 숨김 취소
	@Override
	public void memoHideCancel(String mno) throws Exception {
		memoMapper.memoHideCancel(mno);
	}
	
	// 메모 즐겨찾기 구분값
	@Override
	public int selectFavGB(String mno) throws Exception {
		return memoMapper.selectFavGB(mno);
	}
	
	// 메모 즐겨찾기
	@Override
	public void memoFav(String mno) throws Exception {
		memoMapper.memoFav(mno);
	}

	// 메모 즐겨찾기 취소
	@Override
	public void memoFavCancel(String mno) throws Exception {
		memoMapper.memoFavCancel(mno);
	}
	
	// 메모 숨김제외 리스트
	@Override
	public List<MemoDTO> memoList_h(String email) throws Exception {
		return memoMapper.memoList_h(email);
	}
	
	// 메모 수정
	@Override
	public MemoDTO modifyMemo_mno(int mno) throws Exception {
		return memoMapper.modifyMemo_mno(mno);
	}

	@Override
	public void modifyMemo(MemoDTO memoDTO) throws Exception {
		memoMapper.modifyMemo(memoDTO);
	}

}
