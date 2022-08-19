package com.example.yjtodobe.domain;

import lombok.Getter;

public enum YjTodoTypeEnum {
    NONE(0, "NONE", "빈 데이터"),
    VACATION(10, "VACATION", "휴가"),
    PAYMENT(20, "PAYMENT", "청구");

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
