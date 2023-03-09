package com.sim.springevent.common.event.UserActionEvent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sim.springevent.common.event.UserActionEvent.entity.UserAction;

public interface UserActionRepository extends JpaRepository<UserAction, Long> {
}
