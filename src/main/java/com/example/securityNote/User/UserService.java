package com.example.securityNote.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // 비번 암호화를 위한 클래스

    // user 이름이랑 비번으로 회원 등록!
    public UserEntity signup(UserDto userDto){

        UserEntity userEntity = userDto.toEntity(passwordEncoder);
        UserEntity target = userRepository.findByUsername(userDto.getUsername());

        if (target != null){
            throw new AlreadyRegisteredUserException();
        }
        return userRepository.save(userEntity);

    }

}
