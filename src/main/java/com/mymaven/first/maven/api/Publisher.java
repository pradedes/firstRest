package com.mymaven.first.maven.api;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Publisher {
	@Id
	private String name;
	private String phone;

	public Publisher() {
		super();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
