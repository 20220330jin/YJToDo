package com.example.yjtodobe.domain;

import lombok.Getter;

public enum YjTodoTypeEnum {
    // todo 생성시 대기중, (진행버튼 추가) 진행버튼 누를시 진행중, 체크시 확인중, 완료버튼시 완료
    STANDBY(0, "WAITING", "대기중"),
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
