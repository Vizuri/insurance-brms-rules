package com.vizuri.insurance.domain;


public class Applicant {
	private Integer id;
	private String firstName;
	private String lastName;
	private boolean fraud;
	private String email;
	private String phone;
	private boolean anyPreviousInsuranceDenials;
	private boolean filedForBankruptcy;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isFraud() {
		return fraud;
	}
	public void setFraud(boolean fraud) {
		this.fraud = fraud;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isAnyPreviousInsuranceDenials() {
		return anyPreviousInsuranceDenials;
	}
	public void setAnyPreviousInsuranceDenials(boolean anyPreviousInsuranceDenials) {
		this.anyPreviousInsuranceDenials = anyPreviousInsuranceDenials;
	}
	public boolean isFiledForBankruptcy() {
		return filedForBankruptcy;
	}
	public void setFiledForBankruptcy(boolean filedForBankruptcy) {
		this.filedForBankruptcy = filedForBankruptcy;
	}
	
	

}
