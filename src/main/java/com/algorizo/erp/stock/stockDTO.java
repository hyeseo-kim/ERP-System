package com.algorizo.erp.stock;

import java.math.BigDecimal;
import java.sql.Date;

import com.algorizo.erp.company.CompanyDTO;
import com.algorizo.erp.inbound.inboundDTO;
import com.algorizo.erp.inspection.DTO.InspectionDTO;
import com.algorizo.erp.outbound.outboundDTO;
import com.algorizo.erp.product.ProductDTO;
import com.algorizo.erp.register.dto.MemberDTO;

public class stockDTO {

	private int s_id;
	private int s_quantity;
	private String s_status;
	private int del;
	private String etc;
	private int product_p_id;
	private ProductDTO product;
	private Date in_date;
	private Date update_date;
	private InspectionDTO inspection;
	private int i_quantity;
	private String i_inspector;
	private int i_defective_quantity;
	private String p_code;
	private String p_name;
	private int p_price;
	/*
	 * private MemberDTO member; private CompanyDTO company;
	 */

	public stockDTO() {

	}
	public stockDTO(int s_id, int s_quantity, String s_status, int del, String etc, int product_p_id,
			ProductDTO product, Date in_date, Date update_date, InspectionDTO inspection, int i_quantity,
			String i_inspector, int i_defective_quantity, String p_code, String p_name, int p_price) {
		super();
		this.s_id = s_id;
		this.s_quantity = s_quantity;
		this.s_status = s_status;
		this.del = del;
		this.etc = etc;
		this.product_p_id = product_p_id;
		this.product = product;
		this.in_date = in_date;
		this.update_date = update_date;
		this.inspection = inspection;
		this.i_quantity = i_quantity;
		this.i_inspector = i_inspector;
		this.i_defective_quantity = i_defective_quantity;
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_price = p_price;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getS_quantity() {
		return s_quantity;
	}
	public void setS_quantity(int s_quantity) {
		this.s_quantity = s_quantity;
	}
	public String getS_status() {
		return s_status;
	}
	public void setS_status(String s_status) {
		this.s_status = s_status;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public int getProduct_p_id() {
		return product_p_id;
	}
	public void setProduct_p_id(int product_p_id) {
		this.product_p_id = product_p_id;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public Date getIn_date() {
		return in_date;
	}
	public void setIn_date(Date in_date) {
		this.in_date = in_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public InspectionDTO getInspection() {
		return inspection;
	}
	public void setInspection(InspectionDTO inspection) {
		this.inspection = inspection;
	}
	public int getI_quantity() {
		return i_quantity;
	}
	public void setI_quantity(int i_quantity) {
		this.i_quantity = i_quantity;
	}
	public String getI_inspector() {
		return i_inspector;
	}
	public void setI_inspector(String i_inspector) {
		this.i_inspector = i_inspector;
	}
	public int getI_defective_quantity() {
		return i_defective_quantity;
	}
	public void setI_defective_quantity(int i_defective_quantity) {
		this.i_defective_quantity = i_defective_quantity;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
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
	@Override
	public String toString() {
		return "stockDTO [s_id=" + s_id + ", s_quantity=" + s_quantity + ", s_status=" + s_status + ", del=" + del
				+ ", etc=" + etc + ", product_p_id=" + product_p_id + ", product=" + product + ", in_date=" + in_date
				+ ", update_date=" + update_date + ", inspection=" + inspection + ", i_quantity=" + i_quantity
				+ ", i_inspector=" + i_inspector + ", i_defective_quantity=" + i_defective_quantity + ", p_code="
				+ p_code + ", p_name=" + p_name + ", p_price=" + p_price + "]";
	}
	
}