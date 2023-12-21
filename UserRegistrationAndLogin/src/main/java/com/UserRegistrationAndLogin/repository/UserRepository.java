package com.UserRegistrationAndLogin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserRegistrationAndLogin.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findOneByEmailAndPassword(String email, String password);
	User findByEmail(String email);
}