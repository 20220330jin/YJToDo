package com.example.yjtodobe.exception;

import com.example.yjtodobe.domain.CustomCode;
import lombok.Getter;

public abstract class YJException extends RuntimeException {

    @Getter
    private final CustomCode customCode;

    public YJException(CustomCode customCode){
        this.customCode = customCode;
    }

    public YJException(CustomCode customCode, String message){
        this.customCode = customCode;
    }
}
