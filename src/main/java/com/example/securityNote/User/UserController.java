package com.example.securityNote.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 회원가입 Controller
@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class UserController {

    private final UserService userService;

    // 회원가입 view 페이지
    @GetMapping
    public String signupPage(){
        return "signup";
    }

    // 회원가입 post
    @PostMapping
    public String signupPost(UserDto userDto){
        return "";
    }
}
