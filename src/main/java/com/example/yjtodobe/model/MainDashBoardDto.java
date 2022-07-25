package com.example.yjtodobe.model;

import lombok.Getter;


public class MainDashBoardDto {

    @Getter
    public static class createParam {
        private String content;
    }

    public static class create {
        private long id;

        private String content;
    }


}
