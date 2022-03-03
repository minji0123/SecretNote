package com.example.securityNote.note;

import com.example.securityNote.member.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    // 노트 조회
    @GetMapping
    public String seeNote(Authentication authentication, Model model){

        // 인증받은 유저를 담음
        UserEntity userEntity = (UserEntity) authentication.getPrincipal();

        // 유저가 쓴 노트를 list 로 담아온다.
        List<NoteEntity> noteEntities = noteService.find(userEntity);

        model.addAttribute("notes",noteEntities);

        return "note/index";
    }


    // 노트 저장 post
    @PostMapping
    public String saveNote(Authentication authentication, @ModelAttribute NoteDto noteDto){
        // @ModelAttribute 는 view 페이지에서 noteDto 에 저장된 데이터를 사용할 수 있게 해준다.

        // 인증받은 유저를 담음
        UserEntity userEntity = (UserEntity) authentication.getPrincipal();

        // service 의 메소드 save 에 값을 넣어준다.
        // 넣어주는 값은 dto 의 getter 를 이용한다.
        noteService.save(userEntity, noteDto.getTitle(),noteDto.getContent());

        return "redirect:note";
    }

    // 노트 수정 patch
    @PatchMapping
    public String updateNote(Authentication authentication, @RequestParam Long id, @ModelAttribute NoteDto noteDto){

        // 인증받은 유저를 담음
        UserEntity userEntity = (UserEntity) authentication.getPrincipal();

        noteService.update(userEntity, id, noteDto.getTitle(),noteDto.getContent());

        return "redirect:note";
    }

    // 노트 삭제 delete
    @DeleteMapping
    public String deleteNote(Authentication authentication, @RequestParam Long id){
        // RequestParam 는 요청 매개변수에 들어있는 기본 타입 데이터를 메서드 인자로 받아올 수 있다.

        // 인증받은 유저를 담음
        UserEntity userEntity = (UserEntity) authentication.getPrincipal();

        // service 의 메소드 delete 에 값을 넣어준다.
        // 단순히 지워주기만 할 것이다.
        noteService.delete(userEntity,id);

        return "redirect:note";

    }

}
