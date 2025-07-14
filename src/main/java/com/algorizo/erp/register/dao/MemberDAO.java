package com.algorizo.erp.register.dao;

import java.util.List;

import com.algorizo.erp.register.dto.MemberDTO;

public interface MemberDAO {
//	사원 추가
	public void insertMember(MemberDTO dto);
	
//	사원선택
	public MemberDTO selectMember(String m_id);
	
//	사원 전체조회
	public List<MemberDTO> memberList();
	
//	사원 상세정보
	public MemberDTO memberDetail(String m_id);
	
//	사원 삭제
	public void deleteMember(String m_id);
	
	public MemberDTO updateMember(MemberDTO member);
	
}
