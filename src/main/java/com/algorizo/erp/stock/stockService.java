package com.algorizo.erp.stock;

import java.util.List;

import com.algorizo.erp.inbound.inboundDTO;
import com.algorizo.erp.outbound.outboundDTO;
import co.algorizo.erp.stock.stockDTO;

public interface stockService {
	
		//재고 전체 조회
		List<stockDTO> list() throws Exception;

		//재고 상세보기
		stockDTO detail(int s_id) throws Exception;
		
		//입/출/재고 수량
		List<StockSummaryDTO> summary() throws Exception;
		
		//재고 상태 수정
		void updateStockStatus(stockDTO stockdto) throws Exception; 

}
