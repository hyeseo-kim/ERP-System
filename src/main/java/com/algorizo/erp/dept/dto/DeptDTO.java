package com.algorizo.erp.dept.dto;

public class DeptDTO {
	
	private Integer d_id;
	private String team;
	
	public DeptDTO() {}

	public DeptDTO(Integer d_id, String team) {
		super();
		this.d_id = d_id;
		this.team = team;
	}

	public Integer getD_id() {
		return d_id;
	}

	public String getTeam() {
		return team;
	}

	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "DeptDTO [d_id=" + d_id + ", team=" + team + "]";
	}
	
	
	
}
