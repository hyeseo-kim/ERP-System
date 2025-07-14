package com.algorizo.erp.register.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.algorizo.erp.register.dao.MemberDAO;
import co.algorizo.erp.register.dto.MemberDTO;

@Service
public class MemberServiceimpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	
	@Override
	public void insertMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(dto.getM_password());
		dto.setM_password(encodedPassword);
		dao.insertMember(dto);
	}

	@Override
	public MemberDTO selectMember(String m_id) {
		// TODO Auto-generated method stub
		return dao.selectMember(m_id);
	}

	@Override
	public List<MemberDTO> memberList() {
		// TODO Auto-generated method stub
		return dao.memberList();
	}

	@Override
	public MemberDTO memberDetail(String m_id) {
		// TODO Auto-generated method stub
		return dao.memberDetail(m_id);
	}

	@Override
	public void deleteMember(String m_id) {
		dao.deleteMember(m_id);
		
	}

	@Override
	public MemberDTO updateMember(MemberDTO member) {
		// TODO Auto-generated method stub
		MemberDTO updatedMember = dao.updateMember(member);
		
		if(updatedMember == null) {
			throw new RuntimeException("사원 정보 수정 실패 : " + member.getM_id());
		}
		return updatedMember;
	}
	
}
