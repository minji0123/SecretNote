package com.example.securityNote.config;

import com.example.securityNote.member.UserEntity;
import com.example.securityNote.member.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    /*
    * WebMVC
    * /home => index.html
    * / => index.html
    * /login => login.html
    */

    // security 설정
    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.httpBasic().disable(); // basic authentication filter 비활성화 (form 인증이 아닐 때 인증을 시도하는 필터)
        http.csrf(); // post 방식의 csrf
        http.rememberMe(); // 로그인 지속

        // 요청에 대한 권한을 지정
        http.authorizeRequests() // 시큐리티 처리에 HttpServletRequest 를 이용
                .antMatchers("/","/home","/signup").permitAll() // 모두에게 허용
                .antMatchers("/admin").hasRole("ADMIN") // admin 페이지는 admin 에게 허용
                .antMatchers(HttpMethod.POST,"/notice").hasRole("ADMIN") // notice 페이지 생성 권한은 admin
                .antMatchers(HttpMethod.DELETE,"/notice").hasRole("ADMIN") // notice 페이지 삭제 권한은 admin
                .antMatchers("/note").hasRole("USER") // note 페이지는 user 에게 허용
                .anyRequest().authenticated(); // 그 외의는 다 인증이 되어야 한다.

        // 로그인
        http.formLogin()
                .loginPage("/login") // 페이지는 login.html
                .defaultSuccessUrl("/") // 요청성공하면 / url 로 이동
                .permitAll(); // 모두 허용!

        // 로그아웃
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/"); // 요청성공하면 / url 로 이동
    }

    // resources 하위 파일들에 대한 설정
    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/images/**","/css/**"); // 정적 리소스들은 spring security 대상에서 제외
//        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations()); 와 같은 코드
    }

    // userDetailsService
    // spring security 는 user 정보를 어떤 방식으로 가져와야 하는지 모른다. 그래서 알려줘야함
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return username -> {

            // userService 에서 username 을 가져오라고 알려줌 (service 는 repository 를 또 시킴)
            UserEntity userEntity = userService.findByUsername(username);

            if (userEntity == null) {
                throw new UsernameNotFoundException(username);
            }

            return userEntity; // user 를 반환함
        };
    }
}
