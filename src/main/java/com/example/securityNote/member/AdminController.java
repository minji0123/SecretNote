package com.example.securityNote.member;

import com.example.securityNote.note.NoteEntity;
import com.example.securityNote.note.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// admin 은 모든 유저의 노트 조회 가능!!
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final NoteService noteService;

    @GetMapping
    public String getNoteForAdmin(Authentication authentication, Model model){

        // 인증받은 유저를 담음
        UserEntity userEntity = (UserEntity) authentication.getPrincipal();

        // user 엔티티로 노트들을 조회
        // noteService 의 if 문에 의해서 모든 노트가 id 내림차순으로 정렬되어서 찾아짐
        List<NoteEntity> noteEntityList = noteService.find(userEntity);

        // 뷰에 넣어줌!
        model.addAttribute("noteEntityList", noteEntityList);
        return "admin/index";
    }
}
