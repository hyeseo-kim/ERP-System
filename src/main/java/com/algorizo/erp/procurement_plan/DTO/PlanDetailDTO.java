package com.algorizo.erp.procurement_plan.DTO;

public class PlanDetailDTO {
//	procurement_plan 테이블
	private int plan_id;
	private String plan_code;
	private String plan_title;
	private String plan_writer;
	private String plan_regdate;
	private String plan_moddate;
	private String plan_moduser;
//	plan_product 테이블
	private int pp_id;
	private int p_id;
	private int pp_quantity;
	private String pp_delivery_date;
	private int pp_total_price;
//	product 테이블 후에 수정
	private String p_name;
	private int p_price;
	private String p_category;
	
	public PlanDetailDTO() {
		
	}

	public PlanDetailDTO(int plan_id, String plan_code, String plan_title, String plan_writer, String plan_regdate,
			String plan_moddate, String plan_moduser, int pp_id, int p_id, int pp_quantity, String pp_delivery_date,
			int pp_total_price, String p_name, int p_price, String p_category) {
		super();
		this.plan_id = plan_id;
		this.plan_code = plan_code;
		this.plan_title = plan_title;
		this.plan_writer = plan_writer;
		this.plan_regdate = plan_regdate;
		this.plan_moddate = plan_moddate;
		this.plan_moduser = plan_moduser;
		this.pp_id = pp_id;
		this.p_id = p_id;
		this.pp_quantity = pp_quantity;
		this.pp_delivery_date = pp_delivery_date;
		this.pp_total_price = pp_total_price;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_category = p_category;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public String getPlan_code() {
		return plan_code;
	}

	public void setPlan_code(String plan_code) {
		this.plan_code = plan_code;
	}

	public String getPlan_title() {
		return plan_title;
	}

	public void setPlan_title(String plan_title) {
		this.plan_title = plan_title;
	}

	public String getPlan_writer() {
		return plan_writer;
	}

	public void setPlan_writer(String plan_writer) {
		this.plan_writer = plan_writer;
	}

	public String getPlan_regdate() {
		return plan_regdate;
	}

	public void setPlan_regdate(String plan_regdate) {
		this.plan_regdate = plan_regdate;
	}

	public String getPlan_moddate() {
		return plan_moddate;
	}

	public void setPlan_moddate(String plan_moddate) {
		this.plan_moddate = plan_moddate;
	}

	public String getPlan_moduser() {
		return plan_moduser;
	}

	public void setPlan_moduser(String plan_moduser) {
		this.plan_moduser = plan_moduser;
	}

	public int getPp_id() {
		return pp_id;
	}

	public void setPp_id(int pp_id) {
		this.pp_id = pp_id;
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

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_category() {
		return p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
	}

	@Override
	public String toString() {
		return "PlanDetailDTO [plan_id=" + plan_id + ", plan_code=" + plan_code + ", plan_title=" + plan_title
				+ ", plan_writer=" + plan_writer + ", plan_regdate=" + plan_regdate + ", plan_moddate=" + plan_moddate
				+ ", plan_moduser=" + plan_moduser + ", pp_id=" + pp_id + ", p_id=" + p_id + ", pp_quantity="
				+ pp_quantity + ", pp_delivery_date=" + pp_delivery_date + ", pp_total_price=" + pp_total_price
				+ ", p_name=" + p_name + ", p_price=" + p_price + ", p_category=" + p_category + "]";
	}

}
