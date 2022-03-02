package com.example.securityNote.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserDto createUser(){
        UserDto userDto = new UserDto("하츄핑", "1234");
        return userDto;
    }

    @Test
    void signupTest() {
//        UserDto userDto = createUser();
////        UserEntity userEntity = userService.signup(userDto);
//        UserEntity userEntity = userService.signup(userDto);
//
//
//        assertEquals(userDto.getUsername(), userEntity.getUsername());
//        assertEquals("하츄핑", userEntity.getUsername());
//
//        String rawPassword = "password";
//        String encodedPassword = passwordEncoder.encode(rawPassword);
//        assertEquals(passwordEncoder.matches(rawPassword, encodedPassword), true);
//        // assertEquals(passwordEncoder.encode(userDto.getPassword()), userEntity.getPassword());
//
    }
}