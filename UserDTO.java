package com.RequestBodyValidation.main.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	@NotBlank
	private String emailId;

	@NotBlank
	private String name;

	@NotBlank
	private String qualification;

	private long mobileNumber;

	@NotBlank
	private String password;

	private int age;

	@NotBlank
	private String city;

	@NotBlank
	private String geneder;

	@NotBlank
	private String country;

}
