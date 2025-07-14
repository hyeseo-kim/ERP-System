package com.algorizo.erp.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "co.algorizo.erp.boardMapper";
	
	@Override
	public void register(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".register", boardDTO);
	}

	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".list");
	}

	@Override
	public BoardDTO detail(int b_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".detail", b_id);
	}

	@Override
	public void delete(int b_id) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE + ".delete", b_id);
	}

	@Override
	public void update(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE + ".update", boardDTO);
	}

	@Override
	public List<BoardDTO> listThree() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".listThree");
	}

	
	

}
