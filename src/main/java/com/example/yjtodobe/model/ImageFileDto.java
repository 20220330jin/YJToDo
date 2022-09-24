package com.example.yjtodobe.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

public class ImageFileDto {

    @Getter
    public static class read {
        private long imageId;

        private LocalDateTime createDateTime;

        private String imageFilename;

        public read(long imageId, LocalDateTime createDateTime, String imageFilename) {
            this.imageId = imageId;
            this.createDateTime = createDateTime;
            this.imageFilename = imageFilename;
        }
    }
    
    @Getter
    public static class detailRead {

        private LocalDateTime createDateTime;

        private long imageId;

        private String imageFilename;

        public detailRead(LocalDateTime createDateTime, long imageId, String imageFilename) {
            this.createDateTime = createDateTime;
            this.imageId = imageId;
            this.imageFilename = imageFilename;
        }
    }
    @Getter
    @Setter
    public static class boardDeleteParam {
        private long detailParamId;
    }

    @Getter
    @Setter
    public static class detailReadParam {
        private long detailParamsId;
        
    }
}
