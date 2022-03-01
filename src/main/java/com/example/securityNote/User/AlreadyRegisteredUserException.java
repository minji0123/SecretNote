package com.example.securityNote.user;

// 이미 등록된 유저를 재등록할 때 발생하는 exception
public class AlreadyRegisteredUserException extends RuntimeException {

    public AlreadyRegisteredUserException (String message) {
        super(message);
    }

    public AlreadyRegisteredUserException () {
        super("이미 등록된 유저입니다.");
    }

}
