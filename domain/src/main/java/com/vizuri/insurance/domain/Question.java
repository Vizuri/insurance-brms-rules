package com.vizuri.insurance.domain;

public class Question {

	private String description;
    private String answerType;
    private String group;
    private String boundProperty;
    private boolean required;
    
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAnswerType() {
		return answerType;
	}
	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getBoundProperty() {
		return boundProperty;
	}
	public void setBoundProperty(String boundProperty) {
		this.boundProperty = boundProperty;
	}
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}

    
}
