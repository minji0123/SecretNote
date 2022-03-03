package com.example.securityNote.note;

import com.example.securityNote.member.UserEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class) // 데이터 변경 알림, 해당 클래스에 Auditing 기능을 포함
public class NoteEntity {
    // id, 제목, 내용, 작성자(user), 생성시간, 수정시간

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Lob // Large Object 4GB
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private UserEntity user;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    // 생성자를 이용해서 controller 와 service 를 구현해보자
    public NoteEntity(String title, String content, UserEntity user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public void patch(NoteEntity noteEntity){
        if(noteEntity.title != null){
            this.title = noteEntity.title;
        }
        if(noteEntity.content != null){
            this.content = noteEntity.content;
        }
        if(noteEntity.user != null){
            this.user = noteEntity.user;
        }
    }
}
