package com.example.securityNote.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserEntity,Long> {

    UserEntity findByUsername (String name);
}
