package com.example.securityNote.note;

import com.example.securityNote.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;

@Controller
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    // 노트 저장 post
    @PostMapping
    public String saveNote(Authentication authentication, @ModelAttribute NoteDto noteDto){
        // @ModelAttribute 는 view 페이지에서 noteDto 에 저장된 데이터를 사용할 수 있게 해준다.

        // 인증받은 유저를 담음
        UserEntity userEntity = (UserEntity) authentication.getPrincipal();

        // service 의 메소드 save 에 값을 넣어준다.
        // 넣어주는 값은 dto 의 getter 를 이용한다. (그래야 repository 가 dto 로 db 에 접근할 수 있지)
        noteService.save(userEntity, noteDto.getTitle(),noteDto.getContent());

        return "redirect:/note";
    }



}
