package com.algorizo.erp.board;

public class BoardDTO {

	private int b_id; 
	private String b_content; 
	private String b_regdate; 
	private String b_title; 
	private String b_etc; 
	private int del;
	private String b_writer;
	private String b_moddate;
	private String b_team;
	
	public BoardDTO() {
		
	}

	public BoardDTO(int b_id, String b_content, String b_regdate, String b_title, String b_etc, int del,
			String b_writer, String b_moddate, String b_team) {
		super();
		this.b_id = b_id;
		this.b_content = b_content;
		this.b_regdate = b_regdate;
		this.b_title = b_title;
		this.b_etc = b_etc;
		this.del = del;
		this.b_writer = b_writer;
		this.b_moddate = b_moddate;
		this.b_team = b_team;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_regdate() {
		return b_regdate;
	}

	public void setB_regdate(String b_regdate) {
		this.b_regdate = b_regdate;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_etc() {
		return b_etc;
	}

	public void setB_etc(String b_etc) {
		this.b_etc = b_etc;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public String getB_writer() {
		return b_writer;
	}

	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	public String getB_moddate() {
		return b_moddate;
	}

	public void setB_moddate(String b_moddate) {
		this.b_moddate = b_moddate;
	}

	public String getB_team() {
		return b_team;
	}

	public void setB_team(String b_team) {
		this.b_team = b_team;
	}

	
		
	
	
}
