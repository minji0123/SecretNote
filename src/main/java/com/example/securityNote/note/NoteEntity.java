package com.example.securityNote.note;

import com.example.securityNote.member.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private UserEntity userEntity;

    @CreatedDate
    private LocalDateTime cratedTime;

    @LastModifiedDate
    private LocalDateTime updatedTime;

    // 생성자를 이용해서 controller 와 service 를 구현해보자
    public NoteEntity(String title, String content, UserEntity userEntity) {
        this.title = title;
        this.content = content;
        this.userEntity = userEntity;
    }
}
