package com.UserRegistrationAndLogin.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.UserRegistrationAndLogin.dto.LoginDto;
import com.UserRegistrationAndLogin.dto.ResponseDto;
import com.UserRegistrationAndLogin.dto.UserDto;
import com.UserRegistrationAndLogin.entity.User;
import com.UserRegistrationAndLogin.loginResponse.LoginResponse;
import com.UserRegistrationAndLogin.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getUsers")
	public List<User> list() {
		return userService.listAll();
	}

	 @PostMapping("/login")
	    public ResponseEntity<?> loginUser(@RequestBody LoginDto logindto)
	    {
	        LoginResponse loginResponse = userService.loginUser(logindto);
	        return ResponseEntity.ok(loginResponse);
	    }
	
	 
	 
	 @PostMapping("/SaveUser")
	    public ResponseEntity<ResponseDto> saveEmployee( @RequestBody UserDto userDTO) {
	        ResponseDto responseDTO = new ResponseDto();  
	        try {
	            User user = userService.addUser(userDTO);
	            ResponseDto.Data responseData = new ResponseDto.Data();
	            responseData.setId(user.getId());
	            responseData.setName(user.getName());
	            responseData.setMobileNo(user.getMobileNo());
	            responseData.setEmail(user.getEmail());
	            responseData.setPassword(user.getPassword());

	            responseDTO.setStatuscode(201);
	            responseDTO.setStatus("SUCCESS");
	            responseDTO.setData(responseData);
	        } catch (Exception e) {
	            responseDTO.setStatuscode(500);
	            responseDTO.setStatus("FAILURE");
	            responseDTO.setData(null);
	        }
	        return ResponseEntity.ok(responseDTO);
	    }
	 
	 
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		try {
			User user = userService.getUser(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	

	@DeleteMapping("/deleteUser/{id}")
	public void delete(@PathVariable Long id) {
		
			userService.delete(id);
		
	}
}





/*@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		try {
			userService.saveUser(user);
			return new ResponseEntity<User>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		
	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Long id) {
		try {
			User exist_user = userService.getUser(id);
			userService.saveUser(user);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}*/