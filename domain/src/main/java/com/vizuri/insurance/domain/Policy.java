package com.vizuri.insurance.domain;

import java.util.Calendar;

public class Policy {
	private Integer id;
	private Calendar beginDate;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Calendar beginDate) {
		this.beginDate = beginDate;
	}
	
	
	
}
