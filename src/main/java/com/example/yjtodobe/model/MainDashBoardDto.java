package com.example.yjtodobe.model;

import lombok.Getter;

import java.time.LocalDateTime;


public class MainDashBoardDto {

    @Getter
    public static class createParam {
        private String content;
    }

    public static class create {
        private long id;

        private String content;
    }

    @Getter
    public static class list {
        private Long id;

        private String content;

        private LocalDateTime createDateTime;

        public list(Long id,
                    String content,
                    LocalDateTime createDateTime
                    ){
            this.id = id;
            this.content = content;
            this.createDateTime = createDateTime;
        }
    }


}
