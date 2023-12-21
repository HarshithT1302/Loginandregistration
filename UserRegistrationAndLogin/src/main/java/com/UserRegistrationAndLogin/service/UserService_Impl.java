package com.UserRegistrationAndLogin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.UserRegistrationAndLogin.dto.LoginDto;
import com.UserRegistrationAndLogin.dto.UserDto;
import com.UserRegistrationAndLogin.entity.User;
import com.UserRegistrationAndLogin.loginResponse.LoginResponse;
import com.UserRegistrationAndLogin.repository.UserRepository;

@Service
public class UserService_Impl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User addUser(UserDto  userDto) 
	{
		User user = new User(
				userDto.getId(),
				userDto.getName(),
				userDto.getMobileNo(),
				userDto.getEmail(),
				userDto.getPassword() );
		User u=userRepo.save(user);
		return u;
	}
	
	UserDto userDTO;

	public LoginResponse  loginUser(LoginDto logindto) {
		User user = userRepo.findByEmail(logindto.getEmail());
		if (user != null) {
			String password = logindto.getPassword();
			String encodedPassword = user.getPassword();
			Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
			if (isPwdRight) {
				java.util.Optional<User> user1 = userRepo.findOneByEmailAndPassword(logindto.getEmail(), encodedPassword);
				
				if (user1.isPresent()) {
					
					return new LoginResponse("Login Success", true);
				} else {
					return new LoginResponse("Login Failed",false);
				}
				
			} 
			else {
				return new LoginResponse("password incorrect",false);
			}
			
		}else {
			return new LoginResponse("Email does not exits",false);
		}
		
	}

	public List<User> listAll() {
		
		return userRepo.findAll();
		
	}

	public User getUser(Long id) {
		return userRepo.findById(id).get();
	}

	public void delete(Long id) {
		userRepo.deleteById(id);
		
	}
}
