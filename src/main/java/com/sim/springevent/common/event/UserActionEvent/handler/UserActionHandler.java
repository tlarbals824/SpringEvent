package com.sim.springevent.common.event.UserActionEvent.handler;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sim.springevent.common.config.CustomUserDetails;
import com.sim.springevent.common.event.UserActionEvent.entity.UserAction;
import com.sim.springevent.common.event.UserActionEvent.entity.UserActionType;
import com.sim.springevent.common.event.UserActionEvent.repository.UserActionRepository;
import com.sim.springevent.domain.user.entity.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserActionHandler {

	private final UserActionRepository userActionRepository;

	@EventListener
	public void userAction(UserAction userAction){
		log.info("UserActionHandler.userAction");
		UserAction action = userActionRepository.save(userAction);
		log.info("action: {}", action);
	}

	@EventListener
	public void userActionAuthentication(AuthenticationSuccessEvent event) {
		User user = getUser(event.getAuthentication());
		user.updateLastLoginDate();

		UserAction action = UserAction.builder()
			.user(user)
			.userActionType(UserActionType.USER_LOGIN)
			.build();
		userActionRepository.save(action);
		log.info("action: {}", action);
	}

	private User getUser(Authentication authentication){
		CustomUserDetails principal = (CustomUserDetails)authentication.getPrincipal();
		return principal.getUser();
	}
}
