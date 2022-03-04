package com.example.securityNote.config;

import com.example.securityNote.member.UserEntity;
import com.example.securityNote.member.UserService;
import com.example.securityNote.note.NoteService;
import com.example.securityNote.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@RequiredArgsConstructor
@Profile(value = "!test") // test 에서는 제외
public class InitializeDefaultConfig {

    private final UserService userService;
    private final NoteService noteService;
    private final NoticeService noticeService;

    /*
     * 유저등록, note 4개 등록
     */
    @Bean
    public void initializeDefaultUser() {
        UserEntity user = userService.signup("user", "user");
        noteService.save(user, "첫 노트 작성", "처음 작성한 노트!");
        noteService.save(user, "이번년도 목표", "멋진 개발자 되기");
        noteService.save(user, "강아지", "강아지 키우고 싶당");
    }

    /*
     * 어드민등록, 공지사항 2개 등록
     */
    @Bean
    public void initializeDefaultAdmin() {
        userService.signupAdmin("admin", "admin");
        noticeService.save("공지사항!", "공지사항입니다");
        noticeService.save("작성한 노트는...", "작성자 외에는 볼 수 없습니다.");
    }

}
