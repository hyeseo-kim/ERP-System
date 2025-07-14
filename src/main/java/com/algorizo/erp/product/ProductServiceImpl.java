package com.algorizo.erp.product;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.algorizo.erp.stock.stockDAO;
import co.algorizo.erp.stock.stockDTO;
import co.algorizo.erp.stock.stockService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private stockService stockservice;
	
	@Autowired
	private stockDAO stockdao;
	
	@Override
	public void productinsert(ProductDTO productDTO) {
		//int s_quantity = stockservice.getStockQuantity(productDTO.getStock_s_id());
		
		productDAO.productinsert(productDTO);
	}
	@Override
	public List<ProductDTO> productlist() {
		// TODO Auto-generated method stub
		return productDAO.productlist();
	}
	@Override
	public ProductDTO getProductCode(String p_code) {
		return productDAO.getProductCode(p_code);
	}
	@Override
	public void productupdate(ProductDTO productDTO) {
		productDAO.productupdate(productDTO);
	}
	@Override
	public void productdelete(int p_id) {
		productDAO.productdelete(p_id);
	}
	@Override
	public String generateNextProductCode() {
		String lastProductCode = productDAO.getLastProductCode();
        String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if (lastProductCode == null || !lastProductCode.startsWith("PD-" + today)) {
            return "PD-" + today + "-001";
        }
        int lastNumber = Integer.parseInt(lastProductCode.substring(12));
        return String.format("PD-%s-%03d", today, lastNumber + 1);
    }
	@Override
	public void insertProductWithStock(ProductDTO productDTO) throws Exception {
	    productDAO.productinsert(productDTO); // p_id 자동 생성됨

	    int p_id = productDTO.getP_id();  // MyBatis에서 useGeneratedKeys=true로 설정해야 함

	    stockDTO stockDTO = new stockDTO();
	    stockDTO.setProduct_p_id(p_id);
	    stockDTO.setS_quantity(0);
	    stockDTO.setS_status("재고없음");
	    stockDTO.setDel(0);
	    stockDTO.setEtc(null);

	    stockdao.register(stockDTO);
	}

	

	

}
