package com.RequestBodyValidation.main.DTO;

public class NameDTO {

	private String name;

	@Override
	public String toString() {
		return "NameDTO [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
