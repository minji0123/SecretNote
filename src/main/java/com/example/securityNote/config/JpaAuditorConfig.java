package com.example.securityNote.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaAuditorConfig {
    //  Audit은 감시하다, 감사하다라는 뜻으로 Spring Data JPA 에서 시간을 자동으로 값을 넣어주는 기능
    // 데이터베이스에서 누가, 언제하였는지 기록을 잘 남겨놓아야 합니다. 그렇기 때문에 생성일, 수정일 컬럼은 대단히 중요한 데이터 입니다.
}
