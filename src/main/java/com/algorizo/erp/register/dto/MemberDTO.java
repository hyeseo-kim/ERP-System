package com.algorizo.erp.register.dto;

import java.util.Date;

import co.algorizo.erp.dept.dto.DeptDTO;

public class MemberDTO {
	private String m_id;
	private String m_name;
	private String m_password;
	private String m_addr;
	private String m_email;
	private String role;
	private String m_pno;
	private String birth;
	private Date regdate;
	private int del;
	private int dept_d_id;
	private DeptDTO dto;
	private String m_photo;
	
	public MemberDTO() {
		this.role = "user";
	}

	public MemberDTO(String m_id, String m_name, String m_password, String m_addr, String m_email,
			String role, String m_pno, String birth, Date regdate,int del, int dept_d_id, DeptDTO dto, String m_photo) {
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_password = m_password;
		this.m_addr = m_addr;
		this.m_email = m_email;
		this.role = (role == null || role.isEmpty() ? "user" : role);
		this.m_pno = m_pno;
		this.birth = birth;
		this.regdate = regdate;
		this.del = del;
		this.dept_d_id = dept_d_id;
		this.dto = dto;
		this.m_photo = m_photo;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getDel() {
		return del;
	}

	public void setDto(DeptDTO dto) {
		this.dto = dto;
	}

	public DeptDTO getDto() {
		return dto;
	}

	public String getM_id() {
		return m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public String getM_password() {
		return m_password;
	}

	public String getM_addr() {
		return m_addr;
	}

	public String getM_email() {
		return m_email;
	}

	public String getRole() {
		return role;
	}

	public String getM_pno() {
		return m_pno;
	}

	public String getBirth() {
		return birth;
	}

	public Date getRegdate() {
		return regdate;
	}

	public int getDept_d_id() {
		return dept_d_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setM_pno(String m_pno) {
		this.m_pno = m_pno;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public void setDept_d_id(int dept_d_id) {
		this.dept_d_id = dept_d_id;
	}
	

	public String getM_photo() {
		return m_photo;
	}

	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}

	@Override
	public String toString() {
		return "MemberDTO [m_id=" + m_id + ", m_name=" + m_name + ", m_password=" + m_password + ", m_addr=" + m_addr
				+ ", m_email=" + m_email + ", role=" + role + ", m_pno=" + m_pno + ", birth=" + birth + ", regdate="
				+ regdate + ", del=" + del + ", dept_d_id=" + dept_d_id + ", dto=" + dto + ", m_photo=" + m_photo + "]";
	}

	
	
}
