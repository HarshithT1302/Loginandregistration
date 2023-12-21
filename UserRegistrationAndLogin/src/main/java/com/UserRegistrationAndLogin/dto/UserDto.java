package com.UserRegistrationAndLogin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserDto {

	private Long id;

	@NotBlank(message = "name shouldn't be null or empty")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "username must contain only letter")
	private String name;

	@Pattern(message= "invalid mobile number", regexp = "^[0-9]+$" )
	private long mobileNo;
	
	@Email(message = "invalid email format")
	private String email;

	@NotBlank(message = "password shouldn't be null or empty")
	private String password;

	
	public UserDto()
	{
		
	}
	
	
	public UserDto(Long id,
			@NotBlank(message = "name shouldn't be null or empty") @Pattern(regexp = "^[a-zA-Z]+$", message = "username must contain only letter") String name,
			@Email(message = "invalid email format") String email,
			@NotBlank(message = "password shouldn't be null or empty") String password,
			@Pattern(message = "invalid mobile number", regexp = "^[0-9]+$") long mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
}
