package com.algorizo.erp.inspection.DTO;

public class DefectReasonDTO {
	private String reason_code;
	private String reason_name;
	
	public DefectReasonDTO () {
		
	}
	
	public DefectReasonDTO(String reason_code, String reason_name) {
		super();
		this.reason_code = reason_code;
		this.reason_name = reason_name;
	}

	public String getReason_code() {
		return reason_code;
	}

	public void setReason_code(String reason_code) {
		this.reason_code = reason_code;
	}

	public String getReason_name() {
		return reason_name;
	}

	public void setReason_name(String reason_name) {
		this.reason_name = reason_name;
	}

	@Override
	public String toString() {
		return "DefectReasonDTO [reason_code=" + reason_code + ", reason_name=" + reason_name + "]";
	}
	
}
