package com.algorizo.erp.register.service;

import java.util.List;

import co.algorizo.erp.register.dto.MemberDTO;

public interface MemberService {
//	사원 추가
	public void insertMember(MemberDTO dto);
	
//	사원 선택
	public MemberDTO selectMember(String m_id);
	
//	사원 전체조회
	public List<MemberDTO> memberList();
	
//	사원 선택조회
	public MemberDTO memberDetail(String m_id);
	
//	사원 삭제
	public void deleteMember(String m_id);
	
//	사원 수정
	public MemberDTO updateMember(MemberDTO member);
}
