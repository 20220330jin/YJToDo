package com.example.yjtodobe.domain;

public enum MemberTypeEnum {
    NORMAL(0, "NORMAL", "일반회원"),
    ADMIN(10, "ADMIN", "운영진"),
    MASTER(20, "MASTER", "마스터");

    private int code;

    private String name;

    private String description;

    private MemberTypeEnum(int code, String name, String description){
        this.code = code;
        this.name = name;
        this.description = description;
    }
}
