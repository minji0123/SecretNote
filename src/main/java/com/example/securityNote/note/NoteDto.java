package com.example.securityNote.note;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// 노트 등록을 위한 dto
@Getter
@Setter
@AllArgsConstructor
public class NoteDto {

    // 노트 등록에는 title 과 content 만 필요한가?
    private String title;
    private String content;

//    public NoteEntity toEntity(){
//        return new NoteEntity(title, content);
//    }

    // 이번엔 toEntity 말고 entity 클래스의 생성자로 접근해서
    // controller 와 service 를 구현해보자

}
