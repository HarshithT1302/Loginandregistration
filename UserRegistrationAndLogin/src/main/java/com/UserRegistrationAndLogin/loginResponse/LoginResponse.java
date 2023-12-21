package com.UserRegistrationAndLogin.loginResponse;

import lombok.Data;

@Data
public class LoginResponse {

    String message;
    Boolean status;
	public LoginResponse(String message, Boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	public LoginResponse() {
		
	}
    
    

}
