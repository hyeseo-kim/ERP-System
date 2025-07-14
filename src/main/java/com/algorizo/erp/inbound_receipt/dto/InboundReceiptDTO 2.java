package com.algorizo.erp.inbound_receipt.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class InboundReceiptDTO {
	private int inre_id;
	private LocalDateTime inre_regdate;
	private long inre_totalprice;
	
//	조인할거
	private int inbound_in_id;
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

//	입고
	private int in_quantity;
	private LocalDateTime in_date;
	
	
	
	public InboundReceiptDTO() {
	}



	public InboundReceiptDTO(int inre_id, LocalDateTime inre_regdate, long inre_totalprice, int inbound_in_id,
			String arc_arc_id, String p_code, String p_name, int p_price, String cp_name, String cp_ctg,
			String cp_manager, String cp_fax, String cp_addr, String arc_name, String arc_ctg, String arc_ceo,
			String arc_fax, String arc_addr, int in_quantity, LocalDateTime in_date) {
		this.inre_id = inre_id;
		this.inre_regdate = inre_regdate;
		this.inre_totalprice = inre_totalprice;
		this.inbound_in_id = inbound_in_id;
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
		this.in_quantity = in_quantity;
		this.in_date = in_date;
	}



	public int getInre_id() {
		return inre_id;
	}



	public void setInre_id(int inre_id) {
		this.inre_id = inre_id;
	}



	public LocalDateTime getInre_regdate() {
		return inre_regdate;
	}



	public void setInre_regdate(LocalDateTime inre_regdate) {
		this.inre_regdate = inre_regdate;
	}



	public long getInre_totalprice() {
		return inre_totalprice;
	}



	public void setInre_totalprice(long inre_totalprice) {
		this.inre_totalprice = inre_totalprice;
	}



	public int getInbound_in_id() {
		return inbound_in_id;
	}



	public void setInbound_in_id(int inbound_in_id) {
		this.inbound_in_id = inbound_in_id;
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



	public int getIn_quantity() {
		return in_quantity;
	}



	public void setIn_quantity(int in_quantity) {
		this.in_quantity = in_quantity;
	}

	

	public LocalDateTime getIn_date() {
		return in_date;
	}



	public void setIn_date(LocalDateTime in_date) {
		this.in_date = in_date;
	}

	public Date getInDateAsDate() {
        if (in_date == null) return null;
        return Date.from(in_date.atZone(ZoneId.systemDefault()).toInstant());
    }

	@Override
	public String toString() {
		return "InboundReceiptDTO [inre_id=" + inre_id + ", inre_regdate=" + inre_regdate + ", inre_totalprice="
				+ inre_totalprice + ", inbound_in_id=" + inbound_in_id + ", arc_arc_id=" + arc_arc_id + ", p_code="
				+ p_code + ", p_name=" + p_name + ", p_price=" + p_price + ", cp_name=" + cp_name + ", cp_ctg=" + cp_ctg
				+ ", cp_manager=" + cp_manager + ", cp_fax=" + cp_fax + ", cp_addr=" + cp_addr + ", arc_name="
				+ arc_name + ", arc_ctg=" + arc_ctg + ", arc_ceo=" + arc_ceo + ", arc_fax=" + arc_fax + ", arc_addr="
				+ arc_addr + ", in_quantity=" + in_quantity + "]";
	}
	

}
