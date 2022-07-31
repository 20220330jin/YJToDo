package com.example.yjtodobe.model;

import com.example.yjtodobe.domain.ApprovalStatusEnum;
import com.example.yjtodobe.domain.ApprovalTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
        private ApprovalTypeEnum approvalType;
        private LocalDateTime createDateTime;
        private Long id;

        public approvalList(String title,
                            String content,
                            ApprovalStatusEnum approvalStatus,
                            ApprovalTypeEnum approvalType,
                            LocalDateTime createDateTime,
                            Long id
                            ){
            this.title = title;
            this.content = content;
            this.approvalStatus = approvalStatus;
            this.approvalType = approvalType;
            this.createDateTime = createDateTime;
            this.id = id;
        }
    }
}
