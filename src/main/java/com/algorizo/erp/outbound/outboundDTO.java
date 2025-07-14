package com.algorizo.erp.outbound;

import java.sql.Date;

import co.algorizo.erp.company.CompanyDTO;
import com.algorizo.erp.outinspection.OutInspectionDTO;
import co.algorizo.erp.product.ProductDTO;
import com.algorizo.erp.register.dto.MemberDTO;
import co.algorizo.erp.stock.stockDTO;

public class outboundDTO {

	private int out_id;
	private Date out_date;
	private Date update_date;
	private String out_status;
	private int out_quantity;
	private String etc;
	private int del;
	private int product_p_id;
	private int company_cp_id;
	private String member_m_id;
	private int oi_quantity;
	private int oi_defective_quantity;
	private int s_quantity;
	
	
	private MemberDTO member;
	private CompanyDTO company;
	private ProductDTO product;
	private stockDTO stock;
	private OutInspectionDTO outinspection;

	public outboundDTO() {

	}

	public outboundDTO(int out_id, Date out_date, Date update_date, String out_status, int out_quantity, String etc,
			int del, int product_p_id, int company_cp_id, String member_m_id, int oi_quantity,
			int oi_defective_quantity, int s_quantity, MemberDTO member, CompanyDTO company, ProductDTO product,
			stockDTO stock, OutInspectionDTO outinspection) {
		super();
		this.out_id = out_id;
		this.out_date = out_date;
		this.update_date = update_date;
		this.out_status = out_status;
		this.out_quantity = out_quantity;
		this.etc = etc;
		this.del = del;
		this.product_p_id = product_p_id;
		this.company_cp_id = company_cp_id;
		this.member_m_id = member_m_id;
		this.oi_quantity = oi_quantity;
		this.oi_defective_quantity = oi_defective_quantity;
		this.s_quantity = s_quantity;
		this.member = member;
		this.company = company;
		this.product = product;
		this.stock = stock;
		this.outinspection = outinspection;
	}

	public int getOut_id() {
		return out_id;
	}

	public void setOut_id(int out_id) {
		this.out_id = out_id;
	}

	public Date getOut_date() {
		return out_date;
	}

	public void setOut_date(Date out_date) {
		this.out_date = out_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getOut_status() {
		return out_status;
	}

	public void setOut_status(String out_status) {
		this.out_status = out_status;
	}

	public int getOut_quantity() {
		return out_quantity;
	}

	public void setOut_quantity(int out_quantity) {
		this.out_quantity = out_quantity;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getProduct_p_id() {
		return product_p_id;
	}

	public void setProduct_p_id(int product_p_id) {
		this.product_p_id = product_p_id;
	}

	public int getCompany_cp_id() {
		return company_cp_id;
	}

	public void setCompany_cp_id(int company_cp_id) {
		this.company_cp_id = company_cp_id;
	}

	public String getMember_m_id() {
		return member_m_id;
	}

	public void setMember_m_id(String member_m_id) {
		this.member_m_id = member_m_id;
	}

	public int getOi_quantity() {
		return oi_quantity;
	}

	public void setOi_quantity(int oi_quantity) {
		this.oi_quantity = oi_quantity;
	}

	public int getOi_defective_quantity() {
		return oi_defective_quantity;
	}

	public void setOi_defective_quantity(int oi_defective_quantity) {
		this.oi_defective_quantity = oi_defective_quantity;
	}

	public int getS_quantity() {
		return s_quantity;
	}

	public void setS_quantity(int s_quantity) {
		this.s_quantity = s_quantity;
	}

	public MemberDTO getMember() {
		return member;
	}

	public void setMember(MemberDTO member) {
		this.member = member;
	}

	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public stockDTO getStock() {
		return stock;
	}

	public void setStock(stockDTO stock) {
		this.stock = stock;
	}

	public OutInspectionDTO getOutinspection() {
		return outinspection;
	}

	public void setOutinspection(OutInspectionDTO outinspection) {
		this.outinspection = outinspection;
	}

	@Override
	public String toString() {
		return "outboundDTO [out_id=" + out_id + ", out_date=" + out_date + ", update_date=" + update_date
				+ ", out_status=" + out_status + ", out_quantity=" + out_quantity + ", etc=" + etc + ", del=" + del
				+ ", product_p_id=" + product_p_id + ", company_cp_id=" + company_cp_id + ", member_m_id=" + member_m_id
				+ ", oi_quantity=" + oi_quantity + ", oi_defective_quantity=" + oi_defective_quantity + ", s_quantity="
				+ s_quantity + ", member=" + member + ", company=" + company + ", product=" + product + ", stock="
				+ stock + ", outinspection=" + outinspection + "]";
	}
	
}