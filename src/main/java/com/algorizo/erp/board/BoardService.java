package com.algorizo.erp.board;

import java.util.List;

public interface BoardService {

	public void register(BoardDTO boardDTO);
	
	public List<BoardDTO> list();
	
	public BoardDTO detail(int b_id);
	
	public void delete(int b_id);
	
	public void update(BoardDTO boardDTO);
	
	public List<BoardDTO> listThree();
	
}
