package com.example.securityNote.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // 비번 암호화를 위한 클래스

    // user 이름이랑 비번으로 회원 등록!
    public UserEntity signup(String username, String password){

        UserEntity target = userRepository.findByUsername(username);

        if (target != null){
            throw null;
        }
        return null;
    }



}
