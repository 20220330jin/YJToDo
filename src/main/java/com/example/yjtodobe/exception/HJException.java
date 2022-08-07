package com.example.yjtodobe.exception;

import com.example.yjtodobe.domain.CustomCode;

public class HJException extends YJException {
    public HJException(CustomCode customCode) {
        super(customCode);
    }

    public HJException(CustomCode customCode, String message) {
        super(customCode, message);
    }
}
