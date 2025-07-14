package com.algorizo.erp.calendar;

public class CalendarDTO {
	private String title;
    private String start;
    private String color;
    private String type;
    private String relatedId;
    private String renderedTitle;
    
    public CalendarDTO() {
    	
    }

	public CalendarDTO(String title, String start, String color, String type, String relatedId, String renderedTitle) {
		super();
		this.title = title;
		this.start = start;
		this.color = color;
		this.type = type;
		this.relatedId = relatedId;
		this.renderedTitle = renderedTitle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRelatedId() {
		return relatedId;
	}

	public void setRelatedId(String relatedId) {
		this.relatedId = relatedId;
	}

	public String getRenderedTitle() {
		return renderedTitle;
	}

	public void setRenderedTitle(String renderedTitle) {
		this.renderedTitle = renderedTitle;
	}

	@Override
	public String toString() {
		return "CalendarDTO [title=" + title + ", start=" + start + ", color=" + color + ", type=" + type
				+ ", relatedId=" + relatedId + ", renderedTitle=" + renderedTitle + "]";
	}

}
