package com.algorizo.erp.board;

import java.util.List;

import com.algorizo.erp.company.CompanyDTO;

public interface BoardDAO {

	public void register(BoardDTO boardDTO);
	
	public List<BoardDTO> list();
	
	public BoardDTO detail(int b_id);
	
	public void delete(int b_id);
	
	public void update(BoardDTO boardDTO);
	
	public List<BoardDTO> listThree();
	
}
