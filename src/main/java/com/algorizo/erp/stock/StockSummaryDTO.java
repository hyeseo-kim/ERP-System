package com.algorizo.erp.stock;


public class StockSummaryDTO {
	
	private String p_name;       
	private int s_quantity;
	private int i_quantity;
	private int p_id;
	private String p_code;
	private int i_defective_quantity;
	private String i_inspector;
	private int in_quantity;
	private int oi_quantity;

	
	public StockSummaryDTO(){
		
	}

	public StockSummaryDTO(String p_name, int s_quantity, int i_quantity, int p_id, String p_code,
			int i_defective_quantity, String i_inspector, int in_quantity, int oi_quantity) {
		super();
		this.p_name = p_name;
		this.s_quantity = s_quantity;
		this.i_quantity = i_quantity;
		this.p_id = p_id;
		this.p_code = p_code;
		this.i_defective_quantity = i_defective_quantity;
		this.i_inspector = i_inspector;
		this.in_quantity = in_quantity;
		this.oi_quantity = oi_quantity;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getS_quantity() {
		return s_quantity;
	}

	public void setS_quantity(int s_quantity) {
		this.s_quantity = s_quantity;
	}

	public int getI_quantity() {
		return i_quantity;
	}

	public void setI_quantity(int i_quantity) {
		this.i_quantity = i_quantity;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public int getI_defective_quantity() {
		return i_defective_quantity;
	}

	public void setI_defective_quantity(int i_defective_quantity) {
		this.i_defective_quantity = i_defective_quantity;
	}

	public String getI_inspector() {
		return i_inspector;
	}

	public void setI_inspector(String i_inspector) {
		this.i_inspector = i_inspector;
	}

	public int getIn_quantity() {
		return in_quantity;
	}

	public void setIn_quantity(int in_quantity) {
		this.in_quantity = in_quantity;
	}

	public int getOi_quantity() {
		return oi_quantity;
	}

	public void setOi_quantity(int oi_quantity) {
		this.oi_quantity = oi_quantity;
	}

	@Override
	public String toString() {
		return "StockSummaryDTO [p_name=" + p_name + ", s_quantity=" + s_quantity + ", i_quantity=" + i_quantity
				+ ", p_id=" + p_id + ", p_code=" + p_code + ", i_defective_quantity=" + i_defective_quantity
				+ ", i_inspector=" + i_inspector + ", in_quantity=" + in_quantity + ", oi_quantity=" + oi_quantity
				+ "]";
	}

}
