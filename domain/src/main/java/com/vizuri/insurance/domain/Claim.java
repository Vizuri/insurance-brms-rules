package com.vizuri.insurance.domain;

import java.util.Calendar;

public class Claim {

	private Integer id;
	private Calendar claimDate;
	private double claimAmount;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Calendar getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(Calendar claimDate) {
		this.claimDate = claimDate;
	}
	public double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	
	
}
