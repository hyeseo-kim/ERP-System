package com.algorizo.erp.stock;

import java.util.List;

public interface stockDAO {
	
	//재고 전체 조회
	List<stockDTO> list() throws Exception;

	//재고 상세보기
	stockDTO detail(int s_id) throws Exception;

	//재고 등록
	void register(stockDTO dto) throws Exception; 

	//재고 수정
	void update(stockDTO dto) throws Exception;

	//재고 삭제
	int delete(int s_id) throws Exception;

	//입,출,재고 수량 view
	List<StockSummaryDTO> summary() throws Exception;
	
	//재고 상태 수정
	void updateStockStatus(stockDTO stockdto) throws Exception; 
}
