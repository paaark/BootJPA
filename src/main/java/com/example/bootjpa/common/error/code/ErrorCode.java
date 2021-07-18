package com.example.bootjpa.common.error.code;

import lombok.Getter;

@Getter
public enum ErrorCode {

    NOT_FOUND_EMAIL(400, "A004001", "이메일을 찾을 수 없습니다."),
    DUPLICATE_EMAIL(400,"A004002","중복된 이메일입니다."),
    NOT_EQUAL_PASSWORD(400,"A004003","비밀번호가 일치하지 않습니다.");


    private int status;
    private String code;
    private String message;

    ErrorCode(int status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }

}
