package com.example.securityNote.note;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository <NoteEntity, Long> {


}
