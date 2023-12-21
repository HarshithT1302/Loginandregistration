package com.UserRegistrationAndLogin.service;

import java.util.List;

import com.UserRegistrationAndLogin.dto.LoginDto;
import com.UserRegistrationAndLogin.dto.UserDto;
import com.UserRegistrationAndLogin.entity.User;
import com.UserRegistrationAndLogin.loginResponse.LoginResponse;

public interface UserService {

	User addUser(UserDto userDto);
    LoginResponse loginUser(LoginDto loginDto);
	List<User> listAll();
	User getUser(Long id);
	void delete(Long id);
	
}
