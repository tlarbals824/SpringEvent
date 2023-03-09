package com.sim.springevent.domain.user.service.dto;

import lombok.Getter;

@Getter
public class LoginRequest {

	private String username;
	private String password;

	public LoginRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequest{" +
			"username='" + username + '\'' +
			", password='" + password + '\'' +
			'}';
	}
}
