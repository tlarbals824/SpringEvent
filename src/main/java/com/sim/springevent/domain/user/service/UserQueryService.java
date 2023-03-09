package com.sim.springevent.domain.user.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sim.springevent.common.event.UserActionEvent.entity.UserAction;
import com.sim.springevent.common.event.UserActionEvent.entity.UserActionType;
import com.sim.springevent.common.exception.BusinessException;
import com.sim.springevent.domain.user.entity.User;
import com.sim.springevent.domain.user.repository.UserRepository;
import com.sim.springevent.domain.user.service.dto.CreateUserRequest;
import com.sim.springevent.domain.user.service.dto.UserResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final ApplicationEventPublisher publisher;

	@Transactional
	public UserResponse save(CreateUserRequest request){
		User user = userRepository.save(request.toEntity(passwordEncoder));

		publisher.publishEvent(UserAction.builder()
				.user(user)
			.userActionType(UserActionType.USER_CREATE)
			.build());

		return UserResponse.of(user);
	}

	public User findByUsername(String username){
		return userRepository.findByUsername(username)
			.orElseThrow(() -> new BusinessException("not found user"));
	}
}
