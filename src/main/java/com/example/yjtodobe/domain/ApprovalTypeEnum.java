package com.example.yjtodobe.domain;

public enum ApprovalTypeEnum {
    NONE(0, "NONE", "빈 데이터"),
    VACATION(10, "VACATION", "휴가"),
    PAYMENT(20, "PAYMENT", "청구");

    private int code;

    private String name;

    private String description;

    private ApprovalTypeEnum(int code, String name, String description){
        this.code = code;
        this.name = name;
        this.description = description;
    }

}
