package com.example.securityNote.notice;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

// admin 이 작성하는 공지 entity
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class) // 데이터 변경 알림, 해당 클래스에 Auditing 기능을 포함
public class NoticeEntity {

    // 어떤 유저가 썼는지 별로 안중요해서, user 는 빼버림

    @Id
    @GeneratedValue
    private Long id;

    // 공지사항 제목
    private String title;

    // 공지사항 내용
    @Lob
    private String content;

    // 등록일자
    @CreatedDate
    private LocalDateTime createdAt;

    // 수정일자
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public NoticeEntity( String title, String content) {
        this.title = title;
        this.content = content;
    }
}
