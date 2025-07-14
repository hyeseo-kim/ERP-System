package com.algorizo.erp.procurement_plan.DTO;

import java.util.List;

public class PlanDTO {
	private int plan_id;
	private String plan_code;
	private String plan_title;
	private String plan_writer;
	private String plan_regdate;
	private String plan_moddate;
	private String plan_moduser;
	
	private List<PlanProductDTO> products;
	
	public PlanDTO() {
		
	}

	public PlanDTO(int plan_id, String plan_code, String plan_title, String plan_writer, String plan_regdate,
			String plan_moddate, String plan_moduser, List<PlanProductDTO> products) {
		super();
		this.plan_id = plan_id;
		this.plan_code = plan_code;
		this.plan_title = plan_title;
		this.plan_writer = plan_writer;
		this.plan_regdate = plan_regdate;
		this.plan_moddate = plan_moddate;
		this.plan_moduser = plan_moduser;
		this.products = products;
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

	public List<PlanProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<PlanProductDTO> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "PlanDTO [plan_id=" + plan_id + ", plan_code=" + plan_code + ", plan_title=" + plan_title
				+ ", plan_writer=" + plan_writer + ", plan_regdate=" + plan_regdate + ", plan_moddate=" + plan_moddate
				+ ", plan_moduser=" + plan_moduser + ", products=" + products + "]";
	}

}
