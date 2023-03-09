package com.sim.springevent.domain.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sim.springevent.domain.user.service.UserQueryService;
import com.sim.springevent.domain.user.service.dto.CreateUserRequest;
import com.sim.springevent.domain.user.service.dto.UserResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final UserQueryService userQueryService;

	@PostMapping("/user/create")
	public UserResponse approveUser(@RequestBody CreateUserRequest request){
		log.info("request : {}", request);
		return userQueryService.save(request);
	}

	// @PostMapping("/login")
	// public UserResponse login(@RequestBody LoginRequest loginRequest){
	// 	log.info("request : {}", loginRequest);
	// 	return userQueryService.login(loginRequest);
	// }
}
