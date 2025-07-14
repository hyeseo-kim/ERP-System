package com.algorizo.erp.register.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.algorizo.erp.register.dto.MemberDTO;

@Repository
public class MemberDAOimpl implements MemberDAO{
	private static final String NAMESPACE = "co.algorizo.erp.memberMapper";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".insertMember", dto);
		
	}

	@Override
	public MemberDTO selectMember(String m_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE +".selectMember", m_id);
	}

	@Override
	public List<MemberDTO> memberList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".memberList");
	}

	@Override
	public MemberDTO memberDetail(String m_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".selectMember", m_id);
	}

	@Override
	public void deleteMember(String m_id) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".deleteMember", m_id);
	}

	@Override
	public MemberDTO updateMember(MemberDTO member) {
		// TODO Auto-generated method stub
		int res = sqlSession.update(NAMESPACE+".updateMember", member);
		if(res > 0) {
			return sqlSession.selectOne(NAMESPACE+".selectMember", member.getM_id());
		}
		
		return null;
	}

	
	
	
	

}
