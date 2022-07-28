package com.example.yjtodobe.model;

import com.example.yjtodobe.domain.ApprovalStatusEnum;
import lombok.Getter;

public class ApprovalDto {

    @Getter
    public static class approvalRequestParam{

        private String title;

        private String content;

    }

    @Getter
    public static class approvalList {
        private String title;
        private String content;
        private ApprovalStatusEnum approvalStatus;

        public approvalList(String title,
                            String content,
                            ApprovalStatusEnum approvalStatus
                            ){
            this.title = title;
            this.content = content;
            this.approvalStatus = approvalStatus;
        }
    }
}
