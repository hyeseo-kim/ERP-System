package com.algorizo.erp.inbound;

import java.util.List;

public interface inboundDAO {
	
	//입고 전체 조회
	List<inboundDTO> list() throws Exception;
	
	//입고 상세보기
	List<inboundDTO> detail(int in_id) throws Exception;
	
	//입고 등록
	void register(inboundDTO dto)throws Exception; 
	
	//입고 수정
	void update(inboundDTO dto)throws Exception;
	
	//입고 삭제
	int delete(int in_id) throws Exception;
	
	//입고 상태 수정
	void updateInboundStatus(String in_id, String in_status) throws Exception;
	
	//재고수량 수정
	void stockupdate(int s_quantity,int s_id) throws Exception;
	
}
