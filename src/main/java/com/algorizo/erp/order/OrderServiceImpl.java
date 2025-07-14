package com.algorizo.erp.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Inject 
	private OrderDAO orderDAO;
	
	@Override
	public List<OrderDTO> getAllOrders() {
		// TODO Auto-generated method stub
		return orderDAO.getAllOrders();
	}

	@Override
	public void register(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		orderDAO.register(orderDTO);
	}

	@Override
	public OrderDTO getOrderDetail(String o_code) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderDetail(o_code);
	}

	@Override
	public void updateOrder(Map<String, Object> map) {
		// TODO Auto-generated method stub
		orderDAO.updateOrder(map);
		
	}



	@Override
	public String generateNextOrderCode() {
		// TODO Auto-generated method stub
		String lastOrderCode = orderDAO.getLastOrderCode();
        String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if (lastOrderCode == null || !lastOrderCode.startsWith("PO-" + today)) {
            return "PO-" + today + "-001";
        }
        int lastNumber = Integer.parseInt(lastOrderCode.substring(12));
        return String.format("PO-%s-%03d", today, lastNumber + 1);
    }

	@Override
	public void deleteOrder(String o_code) {
		// TODO Auto-generated method stub
		 orderDAO.deleteOrder(o_code);
	}

	
	
	
	
}
