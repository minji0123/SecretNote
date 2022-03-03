package com.example.securityNote.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /*
     * WebMVC
     * /home => index.html
     * / => index.html
     * /login => login.html
     */

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");

        //시작페이지 url을 '/'가 아닌 home으로
//  registry.addRedirectViewController("/", "home");
    }

//    WebMvcConfigurer를 사용하면
//    @EnableWebMvc가 자동적으로 세팅해주는 설정에
//    개발자가 원하는 설정을 추가할 수 있게 된다.
//    즉 Override가 가능하다.

}
