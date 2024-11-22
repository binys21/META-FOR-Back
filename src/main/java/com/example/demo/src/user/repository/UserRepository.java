package com.example.demo.src.user.repository;

import com.example.demo.src.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByUsernameAndPassword(String username, String password);
}
