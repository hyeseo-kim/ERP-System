package com.algorizo.erp.outbound_receipt.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class OutboundReceiptDTO {
	private int outre_id;
	private LocalDateTime outre_regdate;
	private long outre_totalprice;
	
//	조인할거
	private int outbound_out_id;
	private String arc_arc_id;
	
//	추가적으로 조회할거
	
//	상품
	private String p_code;
	private String p_name;
	private int p_price;
	
//	거래처
	private String cp_name;
	private String cp_ctg;
	private String cp_manager;
	private String cp_fax;
	private String cp_addr;
	
//	자사
	private String arc_name;
	private String arc_ctg;
	private String arc_ceo;
	private String arc_fax;
	private String arc_addr;

//	출고
	private int out_quantity;
	private LocalDateTime out_date;
	
	public OutboundReceiptDTO() {}

	public OutboundReceiptDTO(int outre_id, LocalDateTime outre_regdate, long outre_totalprice, int outbound_out_id,
			String arc_arc_id, String p_code, String p_name, int p_price, String cp_name, String cp_ctg,
			String cp_manager, String cp_fax, String cp_addr, String arc_name, String arc_ctg, String arc_ceo,
			String arc_fax, String arc_addr, int out_quantity, LocalDateTime out_date) {
		this.outre_id = outre_id;
		this.outre_regdate = outre_regdate;
		this.outre_totalprice = outre_totalprice;
		this.outbound_out_id = outbound_out_id;
		this.arc_arc_id = arc_arc_id;
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_price = p_price;
		this.cp_name = cp_name;
		this.cp_ctg = cp_ctg;
		this.cp_manager = cp_manager;
		this.cp_fax = cp_fax;
		this.cp_addr = cp_addr;
		this.arc_name = arc_name;
		this.arc_ctg = arc_ctg;
		this.arc_ceo = arc_ceo;
		this.arc_fax = arc_fax;
		this.arc_addr = arc_addr;
		this.out_quantity = out_quantity;
		this.out_date = out_date;
	}

	public int getOutre_id() {
		return outre_id;
	}

	public void setOutre_id(int outre_id) {
		this.outre_id = outre_id;
	}

	public LocalDateTime getOutre_regdate() {
		return outre_regdate;
	}

	public void setOutre_regdate(LocalDateTime outre_regdate) {
		this.outre_regdate = outre_regdate;
	}

	public long getOutre_totalprice() {
		return outre_totalprice;
	}

	public void setOutre_totalprice(long outre_totalprice) {
		this.outre_totalprice = outre_totalprice;
	}

	public int getOutbound_out_id() {
		return outbound_out_id;
	}

	public void setOutbound_out_id(int outbound_out_id) {
		this.outbound_out_id = outbound_out_id;
	}

	public String getArc_arc_id() {
		return arc_arc_id;
	}

	public void setArc_arc_id(String arc_arc_id) {
		this.arc_arc_id = arc_arc_id;
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

	public String getCp_name() {
		return cp_name;
	}

	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}

	public String getCp_ctg() {
		return cp_ctg;
	}

	public void setCp_ctg(String cp_ctg) {
		this.cp_ctg = cp_ctg;
	}

	public String getCp_manager() {
		return cp_manager;
	}

	public void setCp_manager(String cp_manager) {
		this.cp_manager = cp_manager;
	}

	public String getCp_fax() {
		return cp_fax;
	}

	public void setCp_fax(String cp_fax) {
		this.cp_fax = cp_fax;
	}

	public String getCp_addr() {
		return cp_addr;
	}

	public void setCp_addr(String cp_addr) {
		this.cp_addr = cp_addr;
	}

	public String getArc_name() {
		return arc_name;
	}

	public void setArc_name(String arc_name) {
		this.arc_name = arc_name;
	}

	public String getArc_ctg() {
		return arc_ctg;
	}

	public void setArc_ctg(String arc_ctg) {
		this.arc_ctg = arc_ctg;
	}

	public String getArc_ceo() {
		return arc_ceo;
	}

	public void setArc_ceo(String arc_ceo) {
		this.arc_ceo = arc_ceo;
	}

	public String getArc_fax() {
		return arc_fax;
	}

	public void setArc_fax(String arc_fax) {
		this.arc_fax = arc_fax;
	}

	public String getArc_addr() {
		return arc_addr;
	}

	public void setArc_addr(String arc_addr) {
		this.arc_addr = arc_addr;
	}

	public int getOut_quantity() {
		return out_quantity;
	}

	public void setOut_quantity(int out_quantity) {
		this.out_quantity = out_quantity;
	}
	

	public LocalDateTime getOut_date() {
		return out_date;
	}

	public void setOut_date(LocalDateTime out_date) {
		this.out_date = out_date;
	}
    public Date getOutDateAsDate() {
        if (out_date == null) return null;
        return Date.from(out_date.atZone(ZoneId.systemDefault()).toInstant());
    }	

	@Override
	public String toString() {
		return "OutboundReceiptDTO [outre_id=" + outre_id + ", outre_regdate=" + outre_regdate + ", outre_totalprice="
				+ outre_totalprice + ", outbound_out_id=" + outbound_out_id + ", arc_arc_id=" + arc_arc_id + ", p_code="
				+ p_code + ", p_name=" + p_name + ", p_price=" + p_price + ", cp_name=" + cp_name + ", cp_ctg=" + cp_ctg
				+ ", cp_manager=" + cp_manager + ", cp_fax=" + cp_fax + ", cp_addr=" + cp_addr + ", arc_name="
				+ arc_name + ", arc_ctg=" + arc_ctg + ", arc_ceo=" + arc_ceo + ", arc_fax=" + arc_fax + ", arc_addr="
				+ arc_addr + ", out_quantity=" + out_quantity + "]";
	}
	
	
	
}
