package com.algorizo.erp.inbound;

import co.algorizo.erp.company.CompanyDTO;
import com.algorizo.erp.product.ProductDTO;
import co.algorizo.erp.stock.stockDTO;

public class inboundDetailDTO {
    
    private String p_code;
    private String p_name;
    private int s_quantity;
    private String i_inspector;
    private int i_quantity;
    private int i_defective_quantity;
    private int in_quantity;
    private int in_id;  // �߰��� �ʵ�

    public inboundDetailDTO(){
        
    }

	public inboundDetailDTO(String p_code, String p_name, int s_quantity, String i_inspector, int i_quantity,
			int i_defective_quantity, int in_quantity, int in_id) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
		this.s_quantity = s_quantity;
		this.i_inspector = i_inspector;
		this.i_quantity = i_quantity;
		this.i_defective_quantity = i_defective_quantity;
		this.in_quantity = in_quantity;
		this.in_id = in_id;
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

	public int getS_quantity() {
		return s_quantity;
	}

	public void setS_quantity(int s_quantity) {
		this.s_quantity = s_quantity;
	}

	public String getI_inspector() {
		return i_inspector;
	}

	public void setI_inspector(String i_inspector) {
		this.i_inspector = i_inspector;
	}

	public int getI_quantity() {
		return i_quantity;
	}

	public void setI_quantity(int i_quantity) {
		this.i_quantity = i_quantity;
	}

	public int getI_defective_quantity() {
		return i_defective_quantity;
	}

	public void setI_defective_quantity(int i_defective_quantity) {
		this.i_defective_quantity = i_defective_quantity;
	}

	public int getIn_quantity() {
		return in_quantity;
	}

	public void setIn_quantity(int in_quantity) {
		this.in_quantity = in_quantity;
	}

	public int getIn_id() {
		return in_id;
	}

	public void setIn_id(int in_id) {
		this.in_id = in_id;
	}

	@Override
	public String toString() {
		return "inboundDetailDTO [p_code=" + p_code + ", p_name=" + p_name + ", s_quantity=" + s_quantity
				+ ", i_inspector=" + i_inspector + ", i_quantity=" + i_quantity + ", i_defective_quantity="
				+ i_defective_quantity + ", in_quantity=" + in_quantity + ", in_id=" + in_id + "]";
	}
    
}
