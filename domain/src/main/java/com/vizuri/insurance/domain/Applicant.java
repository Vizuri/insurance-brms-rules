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
	@Override
	public String toString() {
		return "Applicant [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", fraud=" + fraud + ", email="
				+ email + ", phone=" + phone + ", anyPreviousInsuranceDenials="
				+ anyPreviousInsuranceDenials + ", filedForBankruptcy="
				+ filedForBankruptcy + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (anyPreviousInsuranceDenials ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (filedForBankruptcy ? 1231 : 1237);
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (fraud ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Applicant other = (Applicant) obj;
		if (anyPreviousInsuranceDenials != other.anyPreviousInsuranceDenials)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (filedForBankruptcy != other.filedForBankruptcy)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (fraud != other.fraud)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	
	

}
