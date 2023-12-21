package com.UserRegistrationAndLogin.dto;

import org.springframework.stereotype.Component;

@Component
public class ResponseDto {

	private int statuscode;
	private String status;
	private Data data;
	
	public ResponseDto() {
		
	}
	
	public ResponseDto(int statuscode, String status, Data data) {
		this.statuscode = statuscode;
		this.status = status;
		this.data = data;
	}
	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public static class Data {
		private Long id;
		private String name;
		private long mobileNo;
		private String email;
		private String password;
		
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
		public long getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(long mobileNo) {
			this.mobileNo = mobileNo;
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
		
		
	}
}
