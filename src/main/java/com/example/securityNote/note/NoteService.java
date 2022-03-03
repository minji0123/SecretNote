package com.example.securityNote.note;

import com.example.securityNote.member.UserEntity;
import com.example.securityNote.member.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    // 노트 조회
    @Transactional(readOnly = true) // 조회만 하기 때문에 readonly
    public List<NoteEntity> find(UserEntity userEntity){

        // 유저 없을 때 exception
        if (userEntity == null){
            throw new UserNotFoundException();
        }
        // 유저가 관리자면은 id 값으로 모든 게시글 조회 (모든 유저들의 노트를 볼 수 있음)
        // 이때 id 내림차순으로 정렬됨
        if (userEntity.isAdmin()){
            return noteRepository.findAll(Sort.by(Direction.DESC,"id"));
        }

        // 리턴값: 유저 자신이 쓴 노트_id 내림차순
        return noteRepository.findByUserOrderByIdDesc(userEntity);
    }

    // 노트 저장
    public NoteEntity save(UserEntity userEntity, String title, String content){
        // 노트 작성에는 제목이랑 내용만 필요함

        // 유저 없을 때 exception
        if (userEntity == null){
            throw new UserNotFoundException();
        }

        // noteRepository 에 저장할 반환값은
        // NoteEntity 의 생성자이다.
        return noteRepository.save(new NoteEntity(title, content, userEntity));
    }

    // 노트 수정
    public NoteEntity update(UserEntity userEntity, Long id, String title, String content){

        // 유저 없을 때 exception
        if (userEntity == null){
            throw new UserNotFoundException();
        }

        NoteEntity noteEntity = noteRepository.findByIdAndUser(id, userEntity);

        if (noteEntity == null || id != userEntity.getId()){
            return null;
        }

        noteEntity.patch(new NoteEntity(title,content,userEntity));
        return noteRepository.save(noteEntity);
    }
    // 노트 삭제
    public void delete(UserEntity userEntity, Long id){
        // 노트 삭제에는 id 값만 필요함

        // 유저 없을 때 exception
        if (userEntity == null){
            throw new UserNotFoundException();
        }

        NoteEntity noteEntity = noteRepository.findByIdAndUser(id, userEntity);

        // noteRepository 가 db 에서 값 찾았으면
        if (noteEntity != null){
            noteRepository.delete(noteEntity);
            // 그거 지워버리셈
        }
    }
}
