package com.algorizo.erp.outbound;

import java.util.List;

import com.algorizo.erp.outbound.outboundDTO;

public interface outboundDAO {
	
		//출고 전체 조회
		List<outboundDTO> list() throws Exception;
		
		//출고 상세보기
		List<outboundDTO> detail(int out_id) throws Exception;
		
		//출고 등록
		void register(outboundDTO dto)throws Exception; 
		
		//출고 수정
		void update(outboundDTO dto)throws Exception;
		
		//출고 수정
		int delete(int out_id) throws Exception;
		
		//재/출고 수량 비교
		int exceed(int product_p_id) throws Exception;
		
		//출고 상태 수정
		void updateOutboundStatus(String out_id, String out_status) throws Exception;
		
		//재고수량 수정
		void stockupdate(int s_quantity,int s_id) throws Exception;
}
