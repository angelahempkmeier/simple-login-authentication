package com.theangietalks.loginauth.loginauth.repository;

import com.theangietalks.loginauth.loginauth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
