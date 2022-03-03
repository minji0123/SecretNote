package com.example.securityNote.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // 비번 암호화를 위한 클래스


//    public UserEntity signup(UserDto userDto){
//
//        UserEntity userEntity = userDto.toEntity(passwordEncoder);
//        UserEntity target = userRepository.findByUsername(userDto.getUsername());
//
//        if (target != null){
//            throw new AlreadyRegisteredUserException();
//        }
//        return userRepository.save(userEntity);
//    }

    // user 회원가입
    // user 이름이랑 비번으로 회원 등록!
    public UserEntity signup(String username, String password){

        // username 으로 유저 찾고 nameEntity 에 저장
        UserEntity nameEntity = userRepository.findByUsername(username);

        // 유저가 이미 있으면 exception
        if (nameEntity != null){
            throw new AlreadyRegisteredUserException();
        }

        // save 메소드 발동
        return userRepository.save(new UserEntity(username, passwordEncoder.encode(password),"ROLE_USER"));
    }


    // admin 회원가입
    // admin 이름이랑 비번으로 관리자 등록!
    public UserEntity signupAdmin(String username, String password){

        // username 으로 유저 찾고 nameEntity 에 저장
        UserEntity nameEntity = userRepository.findByUsername(username);
        // 유저가 이미 있으면 exception

        if (nameEntity != null){
            throw new AlreadyRegisteredUserException();
        }
        // save 메소드 발동
        return userRepository.save(new UserEntity(username,passwordEncoder.encode(password),"ROLE_ADMIN"));
    }

    // SpringSecurityConfig 에서 사용할 메소드
    // security 에게 user 를 어떻게 가져오는지 알려줌
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
