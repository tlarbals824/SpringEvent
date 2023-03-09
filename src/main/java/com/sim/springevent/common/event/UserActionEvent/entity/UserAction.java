package com.sim.springevent.common.event.UserActionEvent.entity;

import com.sim.springevent.common.entity.BaseEntity;
import com.sim.springevent.domain.user.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "USERS_ACTION")
public class UserAction extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "user_action_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private User user;

	@Enumerated(EnumType.STRING)
	private UserActionType userActionType;

	@Builder
	public UserAction(User user, UserActionType userActionType) {
		this.user = user;
		this.userActionType = userActionType;
	}

	@Override
	public String toString() {
		return "UserAction{" +
			"id=" + id +
			", user=" + user +
			", userActionType=" + userActionType +
			'}';
	}
}
