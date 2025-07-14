package com.algorizo.erp.company;

public class CompanyDTO {
	
	private int cp_id;
	private String cp_name;
	private String cp_ctg;
	private String cp_manager;
	private String cp_pno;
	private String cp_mail;
	private String cp_fax;
	private String cp_addr;
	private String cp_regdate;
	private String cp_moddate;
	private String m_name;
	private int del;
	private String member_m_id;
	
	public CompanyDTO() {}

	public CompanyDTO(int cp_id, String cp_name, String cp_ctg, String cp_manager, String cp_pno, String cp_mail,
			String cp_fax, String cp_addr, String cp_regdate, String cp_moddate, String m_name, int del,
			String member_m_id) {
		super();
		this.cp_id = cp_id;
		this.cp_name = cp_name;
		this.cp_ctg = cp_ctg;
		this.cp_manager = cp_manager;
		this.cp_pno = cp_pno;
		this.cp_mail = cp_mail;
		this.cp_fax = cp_fax;
		this.cp_addr = cp_addr;
		this.cp_regdate = cp_regdate;
		this.cp_moddate = cp_moddate;
		this.m_name = m_name;
		this.del = del;
		this.member_m_id = member_m_id;
	}

	public int getCp_id() {
		return cp_id;
	}

	public void setCp_id(int cp_id) {
		this.cp_id = cp_id;
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

	public String getCp_pno() {
		return cp_pno;
	}

	public void setCp_pno(String cp_pno) {
		this.cp_pno = cp_pno;
	}

	public String getCp_mail() {
		return cp_mail;
	}

	public void setCp_mail(String cp_mail) {
		this.cp_mail = cp_mail;
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

	public String getCp_regdate() {
		return cp_regdate;
	}

	public void setCp_regdate(String cp_regdate) {
		this.cp_regdate = cp_regdate;
	}

	public String getCp_moddate() {
		return cp_moddate;
	}

	public void setCp_moddate(String cp_moddate) {
		this.cp_moddate = cp_moddate;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public String getMember_m_id() {
		return member_m_id;
	}

	public void setMember_m_id(String member_m_id) {
		this.member_m_id = member_m_id;
	}

	@Override
	public String toString() {
		return "CompanyDTO [cp_id=" + cp_id + ", cp_name=" + cp_name + ", cp_ctg=" + cp_ctg + ", cp_manager="
				+ cp_manager + ", cp_pno=" + cp_pno + ", cp_mail=" + cp_mail + ", cp_fax=" + cp_fax + ", cp_addr="
				+ cp_addr + ", cp_regdate=" + cp_regdate + ", cp_moddate=" + cp_moddate + ", m_name=" + m_name
				+ ", del=" + del + ", member_m_id=" + member_m_id + "]";
	}

	
	

}
