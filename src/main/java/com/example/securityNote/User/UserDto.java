package com.example.securityNote.User;

import lombok.*;
// 회원가입 할 때 사용할 dto!
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class UserDto {
    // view 에 출력할 변수는 두개만!
    // 나머지 두개

    private String username;
    private String password;
}
