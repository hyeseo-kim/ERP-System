package com.algorizo.erp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void register(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		boardDAO.register(boardDTO);
	}

	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return boardDAO.list();
	}

	@Override
	public BoardDTO detail(int b_id) {
		// TODO Auto-generated method stub
		return boardDAO.detail(b_id);
	}

	@Override
	public void delete(int b_id) {
		// TODO Auto-generated method stub
		
		boardDAO.delete(b_id);
	}

	@Override
	public void update(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		boardDAO.update(boardDTO);
	}

	@Override
	public List<BoardDTO> listThree() {
		// TODO Auto-generated method stub
		return boardDAO.listThree();
	}
	
	

}
