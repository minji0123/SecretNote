package com.example.securityNote.member;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.*;
// 회원가입 할 때 사용할 dto!
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto {

    private String username;
    private String password;

//    public UserEntity toEntity(PasswordEncoder passwordEncoder){
//        return new UserEntity(username, passwordEncoder.encode(password));
//    }

}
