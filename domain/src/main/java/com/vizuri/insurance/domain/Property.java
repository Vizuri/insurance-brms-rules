	package com.vizuri.insurance.domain;

import java.util.Calendar;
import java.util.List;
import java.util.Map;


public class Property {
	
	private Address address;
	private Calendar policyBeginDate;
	private Calendar purchaseDate;
	private int yearBuilt;
	private int livingArea;
	private int ageOfRoof;
	private boolean electrictSystemRenovated;
	private boolean homeSafetyDeviceInstalled;
	private List<String> homeSafetyDevices;
	private boolean previousClaims;
	private List claims;
	private boolean dogExists;
	private Map<Integer, String> dogs;
	private boolean childCareBusinessExists;
	private boolean childCareLiabilityCoverageRequired;
	private boolean childCareLiabilityAlreadyExists;
	private Integer applicantId;
	private Integer policyId;
	private Integer quoteId;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Calendar getPolicyBeginDate() {
		return policyBeginDate;
	}
	public void setPolicyBeginDate(Calendar policyBeginDate) {
		this.policyBeginDate = policyBeginDate;
	}
	public Calendar getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Calendar purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getYearBuilt() {
		return yearBuilt;
	}
	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	public int getLivingArea() {
		return livingArea;
	}
	public void setLivingArea(int livingArea) {
		this.livingArea = livingArea;
	}
	public int getAgeOfRoof() {
		return ageOfRoof;
	}
	public void setAgeOfRoof(int ageOfRoof) {
		this.ageOfRoof = ageOfRoof;
	}
	public boolean isElectrictSystemRenovated() {
		return electrictSystemRenovated;
	}
	public void setElectrictSystemRenovated(boolean electrictSystemRenovated) {
		this.electrictSystemRenovated = electrictSystemRenovated;
	}
	public boolean isHomeSafetyDeviceInstalled() {
		return homeSafetyDeviceInstalled;
	}
	public void setHomeSafetyDeviceInstalled(boolean homeSafetyDeviceInstalled) {
		this.homeSafetyDeviceInstalled = homeSafetyDeviceInstalled;
	}
	public List<String> getHomeSafetyDevices() {
		return homeSafetyDevices;
	}
	public void setHomeSafetyDevices(List<String> homeSafetyDevices) {
		this.homeSafetyDevices = homeSafetyDevices;
	}
	public boolean isPreviousClaims() {
		return previousClaims;
	}
	public void setPreviousClaims(boolean previousClaims) {
		this.previousClaims = previousClaims;
	}
	public List getClaims() {
		return claims;
	}
	public void setClaims(List claims) {
		this.claims = claims;
	}
	public boolean isDogExists() {
		return dogExists;
	}
	public void setDogExists(boolean dogExists) {
		this.dogExists = dogExists;
	}
	public Map<Integer, String> getDogs() {
		return dogs;
	}
	public void setDogs(Map<Integer, String> dogs) {
		this.dogs = dogs;
	}
	public boolean isChildCareBusinessExists() {
		return childCareBusinessExists;
	}
	public void setChildCareBusinessExists(boolean childCareBusinessExists) {
		this.childCareBusinessExists = childCareBusinessExists;
	}
	public boolean isChildCareLiabilityCoverageRequired() {
		return childCareLiabilityCoverageRequired;
	}
	public void setChildCareLiabilityCoverageRequired(
			boolean childCareLiabilityCoverageRequired) {
		this.childCareLiabilityCoverageRequired = childCareLiabilityCoverageRequired;
	}
	public boolean isChildCareLiabilityAlreadyExists() {
		return childCareLiabilityAlreadyExists;
	}
	public void setChildCareLiabilityAlreadyExists(
			boolean childCareLiabilityAlreadyExists) {
		this.childCareLiabilityAlreadyExists = childCareLiabilityAlreadyExists;
	}
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
	public Integer getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}
	public Integer getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(Integer quoteId) {
		this.quoteId = quoteId;
	}
	@Override
	public String toString() {
		return "Property [address=" + address + ", policyBeginDate=" + policyBeginDate + ", purchaseDate=" + purchaseDate + ", yearBuilt=" + yearBuilt + ", livingArea=" + livingArea + ", ageOfRoof="
				+ ageOfRoof + ", electrictSystemRenovated=" + electrictSystemRenovated + ", homeSafetyDeviceInstalled=" + homeSafetyDeviceInstalled + ", homeSafetyDevices=" + homeSafetyDevices
				+ ", previousClaims=" + previousClaims + ", claims=" + claims + ", dogExists=" + dogExists + ", dogs=" + dogs + ", childCareBusinessExists=" + childCareBusinessExists
				+ ", childCareLiabilityCoverageRequired=" + childCareLiabilityCoverageRequired + ", childCareLiabilityAlreadyExists=" + childCareLiabilityAlreadyExists + ", applicantId="
				+ applicantId + ", policyId=" + policyId + ", quoteId=" + quoteId + "]";
	}
	
	
	
}
