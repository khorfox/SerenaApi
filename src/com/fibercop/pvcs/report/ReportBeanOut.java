package com.fibercop.pvcs.report;

public class ReportBeanOut extends ReportBean {

	protected String related;
	
	@Override
	public String toString() {
		return "ReportBeanOut [related=" + related + ", id=" + id + "]";
	}

	public String getRelated() {
		return related;
	}

	public void setRelated(String related) {
		this.related = related;
	}

	public ReportBeanOut() {
	}

	public ReportBeanOut(String id, String title, String actionDate, String creationDate, String updateDate,
			String category, String status, String type) {
		super(id, title, actionDate, creationDate, updateDate, category, status, type);
	}

	public ReportBeanOut(ReportBean bean) {
		id = bean.getId();
		title = bean.getId();
		actionDate = bean.getId();
		this.creationDate = bean.creationDate;
		this.updateDate = bean.updateDate;
		this.category = bean.category;
		this.status = bean.status;
		this.type = bean.type;
	}

}
