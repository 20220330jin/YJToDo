package com.example.yjtodobe.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

public class YjBoardDto {

    @Getter
    public static class createParam{
        String title;
        String author;
        String content;
        
    }
    
     public static class create {
        private long id;

        private String title;

        private String content;

        private String author;
    }
    @Getter 
    public static class read {
        private long id;

        private String title;

        private String content;

        private String author;

        private LocalDateTime createDateTime;

        private long viewsCount;

        public read(long id, String title, String content, String author, LocalDateTime createDateTime, long viewsCount){
            this.id = id;
            this.title = title;
            this.content = content;
            this.author = author;
            this.createDateTime = createDateTime;
            this.viewsCount = viewsCount;
        }
    }

    @Getter
    @Setter
    public static class searchParam {

        // 검색어
        private String searchKeyword;

        // 검색타입 : TITLE / AUTHOR
        private String searchType;
        
    }

    @Getter 
    public static class search {
        private long id;

        private String title;

        private String content;

        private String author;

        private LocalDateTime createDateTime;

        private long viewsCount;

        public search(long id, String title, String content, String author, LocalDateTime createDateTime, long viewsCount){
            this.id = id;
            this.title = title;
            this.content = content;
            this.author = author;
            this.createDateTime = createDateTime;
            this.viewsCount = viewsCount;
            // this.search = search;
        }
    }

    @Getter
    public static class detailRead {
        private String title;

        private String content;

        private String author;

        private LocalDateTime createDateTime;

        private long id;

        private long viewsCount;
        

        public detailRead(String title, String content, String author, LocalDateTime createDateTime, long id, long viewsCount) {
            this.title = title;
            this.content = content;
            this.author = author;
            this.createDateTime = createDateTime;
            this.id = id;
            this.viewsCount = viewsCount;
            
        }
    }
    @Getter
    public static class countcount {
        private Long viewsCount;

    }
    @Getter
    @Setter
    public static class boardAddCountParam {
        private long detailParamsId;
    }

    @Getter
    @Setter
    public static class detailReadParam {
        private long detailParamsId;
        
    }
    @Getter
    @Setter
    public static class boardDeleteParam {
        private long detailParamId;
    }

    @Getter
    @Setter
    public static class boardUpdateParam {
        private long id;
        private String title;
        private String content;
        private String author;
    }

    
}
