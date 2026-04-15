package com.qma.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qma.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}