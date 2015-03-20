package com.vizuri.insurance.domain;

public class Question {

	private int id;
	private String description;
    private String answerType;
    private String group;
    private String mappedObject;
    private String mappedProperty;
    private boolean required;
    private boolean enabled;
    private int parentId;
    
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
	
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public String getMappedObject() {
		return mappedObject;
	}
	public void setMappedObject(String mappedObject) {
		this.mappedObject = mappedObject;
	}
	public String getMappedProperty() {
		return mappedProperty;
	}
	public void setMappedProperty(String mappedProperty) {
		this.mappedProperty = mappedProperty;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description + ", answerType=" + answerType + ", group=" + group + ", mappedObject=" + mappedObject + ", mappedProperty=" + mappedProperty
				+ ", required=" + required + ", enabled=" + enabled + ", parentId=" + parentId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((answerType == null) ? 0 : answerType.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((mappedObject == null) ? 0 : mappedObject.hashCode());
		result = prime * result
				+ ((mappedProperty == null) ? 0 : mappedProperty.hashCode());
		result = prime * result + parentId;
		result = prime * result + (required ? 1231 : 1237);
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
		Question other = (Question) obj;
		if (answerType == null) {
			if (other.answerType != null)
				return false;
		} else if (!answerType.equals(other.answerType))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enabled != other.enabled)
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (id != other.id)
			return false;
		if (mappedObject == null) {
			if (other.mappedObject != null)
				return false;
		} else if (!mappedObject.equals(other.mappedObject))
			return false;
		if (mappedProperty == null) {
			if (other.mappedProperty != null)
				return false;
		} else if (!mappedProperty.equals(other.mappedProperty))
			return false;
		if (parentId != other.parentId)
			return false;
		if (required != other.required)
			return false;
		return true;
	}
	
	
    
}
