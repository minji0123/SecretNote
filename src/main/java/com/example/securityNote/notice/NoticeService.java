package com.example.securityNote.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NoticeService {

    private final NoticeRepository noticeRepository;

    // 공지사항 조회
    @Transactional(readOnly = true)
    public List<NoticeEntity> seeAll(){
//        List<NoticeEntity> noticeEntityList = noticeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
//        return noticeEntityList;

        return noticeRepository.findAll(Sort.by(Direction.DESC, "id"));
    }

    // 공지사항 작성
    // title, content 를 파라미터로 넣어서 내용을 저장함
    public NoticeEntity save(String title, String content){

        return noticeRepository.save(new NoticeEntity (title, content));
    }

    // 공지사항 수정
    public NoticeEntity update(Long id, String title, String content){

        NoticeEntity noticeEntity = noticeRepository.findById(id).orElse(null);

        if(noticeEntity == null){
            return null;
        }
        noticeEntity.patch(noticeEntity);

        return noticeRepository.save(noticeEntity);
    }



    // 공지사항 삭제
    public void delete(Long id){
        noticeRepository.findById(id).ifPresent(noticeRepository::delete);

        //  :: -이미 존재하는 메소드와 동일한 기능이면, 메소드 레퍼런스로 람다식을 대체할 수 있다.
        // ifPresent -if 문

    }
}
