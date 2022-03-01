package com.example.securityNote.note;

import com.example.securityNote.user.UserEntity;
import com.example.securityNote.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    // 노트 저장
    public NoteEntity save(UserEntity userEntity, String title, String content){
        // dto 에 선언해준 변수 두개 땡겨옴 (노트 작성에는 제목이랑 내용만 필요함)

        // 유저 없을 때 exception
        if (userEntity == null){
            throw new UserNotFoundException();
        }

        // noteRepository 에 저장할 반환값은
        // NoteEntity 의 생성자이다.
        return noteRepository.save(new NoteEntity(title, content, userEntity));
    }
}
