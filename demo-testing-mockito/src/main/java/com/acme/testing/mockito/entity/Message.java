package com.acme.testing.mockito.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Message implements Serializable {

	private static final long serialVersionUID = -3410357878357799270L;

	private Long id;
	
	private String value;
	
	private String user;
	
	private Date createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Message)) {
			return false;
		}
		
		final Message other = (Message)object;

		return new EqualsBuilder().append(getId(), other.getId())
				.append(getValue(), other.getValue())
				.append(getUser(), other.getUser())
				.append(getCreateDate(), other.getCreateDate())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getValue())
				.append(getUser()).append(getCreateDate()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", getId())
				.append("value", getValue())
				.append("user", getUser())
				.append("createDate", getCreateDate())
				.toString();
	}
	
}
