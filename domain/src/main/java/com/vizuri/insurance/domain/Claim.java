package com.vizuri.insurance.domain;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.vizuri.insurance.domain.xmladapter.CalendarXmlAdapter;


@SuppressWarnings("restriction")
@XmlRootElement
public class Claim {

	private Integer id;
	@XmlJavaTypeAdapter(value = CalendarXmlAdapter.class)
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
	@Override
	public String toString() {
		return "Claim [id=" + id + ", claimDate=" + claimDate + ", claimAmount=" + claimAmount + "]";
	}
	
	
}
