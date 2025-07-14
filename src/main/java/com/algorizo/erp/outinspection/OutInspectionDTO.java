package com.algorizo.erp.outinspection;

import co.algorizo.erp.inspection.DTO.DefectReasonDTO;
import co.algorizo.erp.outbound.outboundDTO;
import co.algorizo.erp.product.ProductDTO;

public class OutInspectionDTO {
	private int oi_id; // 검수 ID
	private int out_id; // 출고 ID
	private String oi_code;
	private String oi_date; // 검수일자
	private int oi_quantity; // 검수수량
	private int oi_defective_quantity; // 불량수량
	private String defect_reason_code;
	private String oi_custom_reason;
	private double oi_defect_rate;
	private String oi_result; // 검수 결과
	private String oi_inspector; // 검수자
	private String oi_moduser; // 검수 수정자
	private String oi_moddate; // 검수 수정일
	private String oi_etc; // 비고
	
	private outboundDTO outboundDTO;
	private ProductDTO productDTO;
	private DefectReasonDTO defectReasonDTO;
	
	public OutInspectionDTO() {}

	public OutInspectionDTO(int oi_id, int out_id, String oi_code, String oi_date, int oi_quantity,
			int oi_defective_quantity, String defect_reason_code, String oi_custom_reason, double oi_defect_rate,
			String oi_result, String oi_inspector, String oi_moduser, String oi_moddate, String oi_etc,
			co.algorizo.erp.outbound.outboundDTO outboundDTO, ProductDTO productDTO, DefectReasonDTO defectReasonDTO) {
		super();
		this.oi_id = oi_id;
		this.out_id = out_id;
		this.oi_code = oi_code;
		this.oi_date = oi_date;
		this.oi_quantity = oi_quantity;
		this.oi_defective_quantity = oi_defective_quantity;
		this.defect_reason_code = defect_reason_code;
		this.oi_custom_reason = oi_custom_reason;
		this.oi_defect_rate = oi_defect_rate;
		this.oi_result = oi_result;
		this.oi_inspector = oi_inspector;
		this.oi_moduser = oi_moduser;
		this.oi_moddate = oi_moddate;
		this.oi_etc = oi_etc;
		this.outboundDTO = outboundDTO;
		this.productDTO = productDTO;
		this.defectReasonDTO = defectReasonDTO;
	}

	public int getOi_id() {
		return oi_id;
	}

	public void setOi_id(int oi_id) {
		this.oi_id = oi_id;
	}

	public int getOut_id() {
		return out_id;
	}

	public void setOut_id(int out_id) {
		this.out_id = out_id;
	}

	public String getOi_code() {
		return oi_code;
	}

	public void setOi_code(String oi_code) {
		this.oi_code = oi_code;
	}

	public String getOi_date() {
		return oi_date;
	}

	public void setOi_date(String oi_date) {
		this.oi_date = oi_date;
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

	public String getDefect_reason_code() {
		return defect_reason_code;
	}

	public void setDefect_reason_code(String defect_reason_code) {
		this.defect_reason_code = defect_reason_code;
	}

	public String getOi_custom_reason() {
		return oi_custom_reason;
	}

	public void setOi_custom_reason(String oi_custom_reason) {
		this.oi_custom_reason = oi_custom_reason;
	}

	public double getOi_defect_rate() {
		return oi_defect_rate;
	}

	public void setOi_defect_rate(double oi_defect_rate) {
		this.oi_defect_rate = oi_defect_rate;
	}

	public String getOi_result() {
		return oi_result;
	}

	public void setOi_result(String oi_result) {
		this.oi_result = oi_result;
	}

	public String getOi_inspector() {
		return oi_inspector;
	}

	public void setOi_inspector(String oi_inspector) {
		this.oi_inspector = oi_inspector;
	}

	public String getOi_moduser() {
		return oi_moduser;
	}

	public void setOi_moduser(String oi_moduser) {
		this.oi_moduser = oi_moduser;
	}

	public String getOi_moddate() {
		return oi_moddate;
	}

	public void setOi_moddate(String oi_moddate) {
		this.oi_moddate = oi_moddate;
	}

	public String getOi_etc() {
		return oi_etc;
	}

	public void setOi_etc(String oi_etc) {
		this.oi_etc = oi_etc;
	}

	public outboundDTO getOutboundDTO() {
		return outboundDTO;
	}

	public void setOutboundDTO(outboundDTO outboundDTO) {
		this.outboundDTO = outboundDTO;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public DefectReasonDTO getDefectReasonDTO() {
		return defectReasonDTO;
	}

	public void setDefectReasonDTO(DefectReasonDTO defectReasonDTO) {
		this.defectReasonDTO = defectReasonDTO;
	}

	@Override
	public String toString() {
		return "OutInspectionDTO [oi_id=" + oi_id + ", out_id=" + out_id + ", oi_code=" + oi_code + ", oi_date="
				+ oi_date + ", oi_quantity=" + oi_quantity + ", oi_defective_quantity=" + oi_defective_quantity
				+ ", defect_reason_code=" + defect_reason_code + ", oi_custom_reason=" + oi_custom_reason
				+ ", oi_defect_rate=" + oi_defect_rate + ", oi_result=" + oi_result + ", oi_inspector=" + oi_inspector
				+ ", oi_moduser=" + oi_moduser + ", oi_moddate=" + oi_moddate + ", oi_etc=" + oi_etc + ", outboundDTO="
				+ outboundDTO + ", productDTO=" + productDTO + ", defectReasonDTO=" + defectReasonDTO + "]";
	}

}
