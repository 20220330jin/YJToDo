package com.example.yjtodobe.model;

import lombok.Getter;

public class YjBoardDto {

    @Getter
    public static class createParam{
        String title;
    }
    
     public static class create {
        private long id;

        private String title;
    }
}
