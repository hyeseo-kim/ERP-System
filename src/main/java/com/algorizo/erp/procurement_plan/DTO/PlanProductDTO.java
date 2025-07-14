package com.algorizo.erp.procurement_plan.DTO;

public class PlanProductDTO {
	private int pp_id;
	private int plan_id;
	private int p_id;
	private int pp_quantity;
	private String pp_delivery_date;
	private int pp_total_price;
	
	public PlanProductDTO() {
		
	}
	
	public PlanProductDTO(int pp_id, int plan_id, int p_id, int pp_quantity, String pp_delivery_date,
			int pp_total_price) {
		super();
		this.pp_id = pp_id;
		this.plan_id = plan_id;
		this.p_id = p_id;
		this.pp_quantity = pp_quantity;
		this.pp_delivery_date = pp_delivery_date;
		this.pp_total_price = pp_total_price;
	}

	public int getPp_id() {
		return pp_id;
	}

	public void setPp_id(int pp_id) {
		this.pp_id = pp_id;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getPp_quantity() {
		return pp_quantity;
	}

	public void setPp_quantity(int pp_quantity) {
		this.pp_quantity = pp_quantity;
	}

	public String getPp_delivery_date() {
		return pp_delivery_date;
	}

	public void setPp_delivery_date(String pp_delivery_date) {
		this.pp_delivery_date = pp_delivery_date;
	}

	public int getPp_total_price() {
		return pp_total_price;
	}

	public void setPp_total_price(int pp_total_price) {
		this.pp_total_price = pp_total_price;
	}

	@Override
	public String toString() {
		return "PlanProductDTO [pp_id=" + pp_id + ", plan_id=" + plan_id + ", p_id=" + p_id + ", pp_quantity="
				+ pp_quantity + ", pp_delivery_date=" + pp_delivery_date + ", pp_total_price=" + pp_total_price + "]";
	}
	
}
