package com.sim.springevent.domain.user.service.dto;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.sim.springevent.domain.user.entity.User;

import lombok.Getter;

@Getter
public class CreateUserRequest {

	private String username;
	private String password;

	public CreateUserRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User toEntity(PasswordEncoder passwordEncoder){
		return User.builder()
			.username(username)
			.password(passwordEncoder.encode(password))
			.build();
	}

	@Override
	public String toString() {
		return "CreateUserRequest{" +
			"username='" + username + '\'' +
			", password='" + password + '\'' +
			'}';
	}
}
