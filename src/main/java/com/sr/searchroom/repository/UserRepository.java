package com.sr.searchroom.repository;

import com.sr.searchroom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
