package com.algorizo.erp.product;

import co.algorizo.erp.company.CompanyDTO;
import co.algorizo.erp.dept.dto.DeptDTO;

public class ProductDTO {
    private int p_id;
    private String p_lctg;
    private String p_mctg;
    private String p_sctg;
    private String p_code;
    private String p_name;
    private int p_price;
    private String p_content;
    private String p_regdate;
    private String p_moddate;
    private int del;
    private String member_m_id;
    private String member_m_name; // 로그인된 사용자 이름
    private DeptDTO dept; // 부서 정보 (DeptDTO 객체)
    private int dept_d_id;
    private String dept_team; // 부서 이름 (팀명)
    private int stock_s_id;
    private String modifier_m_id;    // 수정자 ID
    private String modifier_m_name;  // 수정자 이름
    
    private int company_cp_id;
    private String cp_name;
    private String cp_ctg;
    
	public ProductDTO() {}

	public ProductDTO(int p_id, String p_lctg, String p_mctg, String p_sctg, String p_code, String p_name, int p_price,
			String p_content, String p_regdate, String p_moddate, int del, String member_m_id, String member_m_name,
			DeptDTO dept, int dept_d_id, String dept_team, int stock_s_id, String modifier_m_id, String modifier_m_name,
			int company_cp_id, String cp_name, String cp_ctg) {
		super();
		this.p_id = p_id;
		this.p_lctg = p_lctg;
		this.p_mctg = p_mctg;
		this.p_sctg = p_sctg;
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_content = p_content;
		this.p_regdate = p_regdate;
		this.p_moddate = p_moddate;
		this.del = del;
		this.member_m_id = member_m_id;
		this.member_m_name = member_m_name;
		this.dept = dept;
		this.dept_d_id = dept_d_id;
		this.dept_team = dept_team;
		this.stock_s_id = stock_s_id;
		this.modifier_m_id = modifier_m_id;
		this.modifier_m_name = modifier_m_name;
		this.company_cp_id = company_cp_id;
		this.cp_name = cp_name;
		this.cp_ctg = cp_ctg;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_lctg() {
		return p_lctg;
	}

	public void setP_lctg(String p_lctg) {
		this.p_lctg = p_lctg;
	}

	public String getP_mctg() {
		return p_mctg;
	}

	public void setP_mctg(String p_mctg) {
		this.p_mctg = p_mctg;
	}

	public String getP_sctg() {
		return p_sctg;
	}

	public void setP_sctg(String p_sctg) {
		this.p_sctg = p_sctg;
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

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public String getP_regdate() {
		return p_regdate;
	}

	public void setP_regdate(String p_regdate) {
		this.p_regdate = p_regdate;
	}

	public String getP_moddate() {
		return p_moddate;
	}

	public void setP_moddate(String p_moddate) {
		this.p_moddate = p_moddate;
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

	public String getMember_m_name() {
		return member_m_name;
	}

	public void setMember_m_name(String member_m_name) {
		this.member_m_name = member_m_name;
	}

	public DeptDTO getDept() {
		return dept;
	}

	public void setDept(DeptDTO dept) {
		this.dept = dept;
	}

	public int getDept_d_id() {
		return dept_d_id;
	}

	public void setDept_d_id(int dept_d_id) {
		this.dept_d_id = dept_d_id;
	}

	public String getDept_team() {
		return dept_team;
	}

	public void setDept_team(String dept_team) {
		this.dept_team = dept_team;
	}

	public int getStock_s_id() {
		return stock_s_id;
	}

	public void setStock_s_id(int stock_s_id) {
		this.stock_s_id = stock_s_id;
	}

	public String getModifier_m_id() {
		return modifier_m_id;
	}

	public void setModifier_m_id(String modifier_m_id) {
		this.modifier_m_id = modifier_m_id;
	}

	public String getModifier_m_name() {
		return modifier_m_name;
	}

	public void setModifier_m_name(String modifier_m_name) {
		this.modifier_m_name = modifier_m_name;
	}

	public int getCompany_cp_id() {
		return company_cp_id;
	}

	public void setCompany_cp_id(int company_cp_id) {
		this.company_cp_id = company_cp_id;
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

	@Override
	public String toString() {
		return "ProductDTO [p_id=" + p_id + ", p_lctg=" + p_lctg + ", p_mctg=" + p_mctg + ", p_sctg=" + p_sctg
				+ ", p_code=" + p_code + ", p_name=" + p_name + ", p_price=" + p_price + ", p_content=" + p_content
				+ ", p_regdate=" + p_regdate + ", p_moddate=" + p_moddate + ", del=" + del + ", member_m_id="
				+ member_m_id + ", member_m_name=" + member_m_name + ", dept=" + dept + ", dept_d_id=" + dept_d_id
				+ ", dept_team=" + dept_team + ", stock_s_id=" + stock_s_id + ", modifier_m_id=" + modifier_m_id
				+ ", modifier_m_name=" + modifier_m_name + ", company_cp_id=" + company_cp_id + ", cp_name=" + cp_name
				+ ", cp_ctg=" + cp_ctg + "]";
	}

	
	

}
