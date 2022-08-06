package com.example.yjtodobe.model;

import com.example.yjtodobe.domain.MainDashBoard;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


public class MainDashBoardDto {

    @Getter
    public static class createParam {
        private String content;
    }

    @Setter
    @Getter
    public static class create {
        private long id;

        private String content;

        public create(MainDashBoard board){
            this.id = board.id;
        }
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

    @Getter
    public static class deleteParam {
        private Long mainDashboardId;
    }


}
