package com.example.yjtodobe.domain;

import lombok.Getter;

public enum YjTodoTypeEnum {
    STANDBY(0, "STANDBY", "대기"),
    ONGOING(10, "ONGOING", "진행중"),
    CHECKING(20, "CHECKING", "확인중"),
    COMPLETE(30, "COMPLETE", "완료");

    private int code;

    @Getter
    private String name;

    @Getter
    private String description;

    private YjTodoTypeEnum(int code, String name, String description){
        this.code = code;
        this.name = name;
        this.description = description;
    }

}
