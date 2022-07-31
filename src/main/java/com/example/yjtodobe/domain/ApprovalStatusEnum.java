package com.example.yjtodobe.domain;

import lombok.Getter;

public enum ApprovalStatusEnum {
    NONE(0, "NONE", "빈 데이터"),
    REQUEST(10, "REQUEST", "결재요청"),
    REJECT(20, "REJECT", "결재반려");

    private int code;

    @Getter
    private String name;

    @Getter
    private String description;
    
    private ApprovalStatusEnum(int code, String name, String description){
        this.code = code;
        this.name = name;
        this.description = description;
    }
}
