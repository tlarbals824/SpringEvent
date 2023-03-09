package com.sim.springevent.domain.user.service.dto;

import com.sim.springevent.domain.user.entity.User;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {

	private String username;
	private String password;

	@Builder
	public UserResponse(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public static UserResponse of(User user){
		return UserResponse.builder()
			.username(user.getUsername())
			.password(user.getPassword())
			.build();
	}
}
