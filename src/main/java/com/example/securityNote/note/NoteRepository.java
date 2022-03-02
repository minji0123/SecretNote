package com.example.securityNote.note;

import com.example.securityNote.member.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository <NoteEntity, Long> {

    // 유저가 작성한 노트 전체 목록을 불러와서 list 에 담음 (id 내림차순)
    List<NoteEntity> findByUserOrderByIdDesc(UserEntity userEntity);

    // 유저가 작성한 노트 삭제할 때 db 에서 찾을 데이터
    NoteEntity findByIdAndUser(Long id, UserEntity userEntity);
}
