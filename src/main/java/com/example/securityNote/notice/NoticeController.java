package com.example.securityNote.notice;

import com.example.securityNote.note.NoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    // 공지사항 조회
    @GetMapping
    public String seeNoticeAll(Model model){
        List<NoticeEntity> noticeEntityList = noticeService.seeAll();
        model.addAttribute("notices",noticeEntityList);
        return "notice/index";
    }

    // 공지사항 등록
    // 등록 시 view 전달용으로 noteDto 를 사용한다.
    @PostMapping
    public String createNotice(@ModelAttribute NoteDto noteDto){
        // @ModelAttribute 는 view 페이지에서 noteDto 에 저장된 데이터를 사용할 수 있게 해준다.

        noticeService.save(noteDto.getTitle(),noteDto.getContent());
        return "redirect:notice";
    }

    // 공지사항 수정

    // 공지사항 삭제
    @DeleteMapping
    public String deleteNotice(@RequestParam Long id){
        noticeService.delete(id);
        return "redirect:notice";
    }





}
