package com.sim.springevent.domain.useraction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sim.springevent.domain.useraction.entity.UserAction;

public interface UserActionRepository extends JpaRepository<UserAction, Long> {
}
