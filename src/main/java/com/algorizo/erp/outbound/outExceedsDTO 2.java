package com.algorizo.erp.outbound;

import co.algorizo.erp.product.ProductDTO;
import co.algorizo.erp.stock.stockDTO;

public class outExceedsDTO {
	
	private int s_quantity;
	private int out_quantity;
	private boolean exceeds;
	private int product_p_id;
	
	
	private stockDTO stock;
	private ProductDTO product;
	
	public outExceedsDTO() {
		
	}

	public outExceedsDTO(int s_quantity, int out_quantity, boolean exceeds, int product_p_id, stockDTO stock,
			ProductDTO product) {
		super();
		this.s_quantity = s_quantity;
		this.out_quantity = out_quantity;
		this.exceeds = exceeds;
		this.product_p_id = product_p_id;
		this.stock = stock;
		this.product = product;
	}

	public int getS_quantity() {
		return s_quantity;
	}

	public void setS_quantity(int s_quantity) {
		this.s_quantity = s_quantity;
	}

	public int getOut_quantity() {
		return out_quantity;
	}

	public void setOut_quantity(int out_quantity) {
		this.out_quantity = out_quantity;
	}

	public boolean isExceeds() {
		return exceeds;
	}

	public void setExceeds(boolean exceeds) {
		this.exceeds = exceeds;
	}

	public int getProduct_p_id() {
		return product_p_id;
	}

	public void setProduct_p_id(int product_p_id) {
		this.product_p_id = product_p_id;
	}

	public stockDTO getStock() {
		return stock;
	}

	public void setStock(stockDTO stock) {
		this.stock = stock;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "outExceedsDTO [s_quantity=" + s_quantity + ", out_quantity=" + out_quantity + ", exceeds=" + exceeds
				+ ", product_p_id=" + product_p_id + ", stock=" + stock + ", product=" + product + "]";
	}
	
}
