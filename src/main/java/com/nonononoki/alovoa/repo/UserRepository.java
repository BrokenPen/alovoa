package com.nonononoki.alovoa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nonononoki.alovoa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);
	
	public List<User> findByDisabledFalseAndAdminFalseAndConfirmedTrueAndIntentionNotNullAndLastLocationNotNullAndAgeBetween(int minAge, int maxAge);
	
	public List<User> findByDisabledFalseAndAdminFalseAndConfirmedTrueAndIntentionNotNullAndLastLocationNotNullOrderByTotalDonationsDesc();
}

