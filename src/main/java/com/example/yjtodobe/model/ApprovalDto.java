package com.example.yjtodobe.model;

import com.example.yjtodobe.domain.ApprovalStatusEnum;
import com.example.yjtodobe.domain.ApprovalTypeEnum;
import lombok.Getter;
import lombok.Setter;

public class ApprovalDto {

    @Getter
    @Setter
    public static class approvalRequestParam{

        private String title;

        private String content;

        private String approvalType;

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
