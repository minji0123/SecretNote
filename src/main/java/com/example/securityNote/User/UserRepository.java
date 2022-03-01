package com.example.securityNote.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserEntity,Long> {

    UserEntity findByUsername (String name);
}