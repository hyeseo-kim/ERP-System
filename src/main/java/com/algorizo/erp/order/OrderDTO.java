package com.algorizo.erp.order;


import com.algorizo.erp.company.CompanyDTO;
import co.algorizo.erp.dept.dto.DeptDTO;
import com.algorizo.erp.product.ProductDTO;
import com.algorizo.erp.register.dto.MemberDTO;
import com.algorizo.erp.stock.stockDTO;

public class OrderDTO {
	
	private int o_no;
	private String o_regdate;
	private String o_code;
	private String o_state;
	private String o_moddate;
	private int o_qty;
	private String member_m_id; 
	private int product_p_id; 
	private Integer stock_s_id; 
	private int dept_d_id; 
	private int company_cp_id;
	private String o_delivery;
	
	private MemberDTO member;
	private ProductDTO product;
	private CompanyDTO company;
	private stockDTO stock;
	private DeptDTO dept;
	
	public OrderDTO(){
		
	}

	public OrderDTO(int o_no, String o_regdate, String o_code, String o_state, String o_moddate, int o_qty,
			String member_m_id, int product_p_id, Integer stock_s_id, int dept_d_id, int company_cp_id,
			String o_delivery, MemberDTO member, ProductDTO product, CompanyDTO company, stockDTO stock, DeptDTO dept) {
		super();
		this.o_no = o_no;
		this.o_regdate = o_regdate;
		this.o_code = o_code;
		this.o_state = o_state;
		this.o_moddate = o_moddate;
		this.o_qty = o_qty;
		this.member_m_id = member_m_id;
		this.product_p_id = product_p_id;
		this.stock_s_id = stock_s_id;
		this.dept_d_id = dept_d_id;
		this.company_cp_id = company_cp_id;
		this.o_delivery = o_delivery;
		this.member = member;
		this.product = product;
		this.company = company;
		this.stock = stock;
		this.dept = dept;
	}

	public int getO_no() {
		return o_no;
	}

	public void setO_no(int o_no) {
		this.o_no = o_no;
	}

	public String getO_regdate() {
		return o_regdate;
	}

	public void setO_regdate(String o_regdate) {
		this.o_regdate = o_regdate;
	}

	public String getO_code() {
		return o_code;
	}

	public void setO_code(String o_code) {
		this.o_code = o_code;
	}

	public String getO_state() {
		return o_state;
	}

	public void setO_state(String o_state) {
		this.o_state = o_state;
	}

	public String getO_moddate() {
		return o_moddate;
	}

	public void setO_moddate(String o_moddate) {
		this.o_moddate = o_moddate;
	}

	public int getO_qty() {
		return o_qty;
	}

	public void setO_qty(int o_qty) {
		this.o_qty = o_qty;
	}

	public String getMember_m_id() {
		return member_m_id;
	}

	public void setMember_m_id(String member_m_id) {
		this.member_m_id = member_m_id;
	}

	public int getProduct_p_id() {
		return product_p_id;
	}

	public void setProduct_p_id(int product_p_id) {
		this.product_p_id = product_p_id;
	}

	public Integer getStock_s_id() {
		return stock_s_id;
	}

	public void setStock_s_id(Integer stock_s_id) {
		this.stock_s_id = stock_s_id;
	}

	public int getDept_d_id() {
		return dept_d_id;
	}

	public void setDept_d_id(int dept_d_id) {
		this.dept_d_id = dept_d_id;
	}

	public int getCompany_cp_id() {
		return company_cp_id;
	}

	public void setCompany_cp_id(int company_cp_id) {
		this.company_cp_id = company_cp_id;
	}

	public String getO_delivery() {
		return o_delivery;
	}

	public void setO_delivery(String o_delivery) {
		this.o_delivery = o_delivery;
	}

	public MemberDTO getMember() {
		return member;
	}

	public void setMember(MemberDTO member) {
		this.member = member;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	public stockDTO getStock() {
		return stock;
	}

	public void setStock(stockDTO stock) {
		this.stock = stock;
	}

	public DeptDTO getDept() {
		return dept;
	}

	public void setDept(DeptDTO dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "OrderDTO [o_no=" + o_no + ", o_regdate=" + o_regdate + ", o_code=" + o_code + ", o_state=" + o_state
				+ ", o_moddate=" + o_moddate + ", o_qty=" + o_qty + ", member_m_id=" + member_m_id + ", product_p_id="
				+ product_p_id + ", stock_s_id=" + stock_s_id + ", dept_d_id=" + dept_d_id + ", company_cp_id="
				+ company_cp_id + ", o_delivery=" + o_delivery + ", member=" + member + ", product=" + product
				+ ", company=" + company + ", stock=" + stock + ", dept=" + dept + "]";
	}

	
	
	
	
	

}
