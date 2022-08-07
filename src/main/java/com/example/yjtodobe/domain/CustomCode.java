package com.example.yjtodobe.domain;

public enum CustomCode {

    NOID(0, "ID 존재하지 않음");

    int code;

    String description;

    CustomCode(int code, String description){
        this.code = code;
        this.description = description;
    }
}
