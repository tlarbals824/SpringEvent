package com.sim.springevent.domain.user.entity;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;

import com.sim.springevent.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "USERS")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;

	private String username;
	private String password;

	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	private LocalDate lastLoginDate;

	private Duration lastLoginDuration;

	@Builder
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.lastLoginDuration = Duration.ZERO;
		this.userRole = UserRole.ROLE_USER;
	}

	public void updateLastLoginDate(){
		if(!Objects.equals(lastLoginDate, LocalDate.now())) {
			calculateLastLoginDuration();
			this.lastLoginDate = LocalDate.now();
		}
	}

	public void calculateLastLoginDuration(){
		if(Objects.nonNull(lastLoginDate))
			lastLoginDuration = Duration.between(lastLoginDate, LocalDate.now());
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", username='" + username + '\'' +
			", password='" + password + '\'' +
			", userRole=" + userRole +
			", lastLoginDate=" + lastLoginDate +
			", lastLoginDuration=" + lastLoginDuration +
			'}';
	}
}
