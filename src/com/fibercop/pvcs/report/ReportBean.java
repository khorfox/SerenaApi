package com.fibercop.pvcs.report;

public class ReportBean {

	// ID,"Title","Action Date","Creation Date","Update Date","Category","Status","Type"
	protected String id;
	protected String title;
	protected String actionDate;
	protected String creationDate;
	protected String updateDate;
	protected String category;
	protected String status;
	protected String type;


	public ReportBean() {
	}
	
	public ReportBean(String id, String title, String actionDate, String creationDate, String updateDate,
			String category, String status, String type) {
		super();
		this.id = id;
		this.title = title;
		this.actionDate = actionDate;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.category = category;
		this.status = status;
		this.type = type;
	}

	public ReportBean(String linea) {
		String[] campi = linea.split(",");
		id = removeFirstandLast(campi[0]);
		title = removeFirstandLast(campi[1]);
		actionDate = removeFirstandLast(campi[2]);
		creationDate = removeFirstandLast(campi[3]);
		updateDate = removeFirstandLast(campi[4]);
		category = removeFirstandLast(campi[5]);
		status = removeFirstandLast(campi[6]);
		type = removeFirstandLast(campi[7]);
	}

    static String removeFirstandLast(String str) {
        str = str.substring(1, str.length() - 1);
        return str;
    }

    public boolean isRequest() {
    	switch(this.type) {
    		case "SM": 	
    			return true;
    		case "RU": 	
    			return true;
    		default:
    			return false;
    	}
    }
    
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActionDate() {
		return actionDate;
	}

	public void setActionDate(String actionDate) {
		this.actionDate = actionDate;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ReportBean [id=" + id + ", title=" + title + ", actionDate=" + actionDate + ", creationDate="
				+ creationDate + ", updateDate=" + updateDate + ", category=" + category + ", status=" + status
				+ ", type=" + type + "]";
	}

}
