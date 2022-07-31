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

        private String userName;

        private Integer approvalNumber;

    }

    @Getter
    public static class approvalList {
        private String title;
        private String content;
        private String approvalStatus;
        private String approvalType;
        private LocalDateTime createDateTime;
        private Long id;
        private String requestUsername;

        public approvalList(String title,
                            String content,
                            ApprovalStatusEnum approvalStatus,
                            ApprovalTypeEnum approvalType,
                            LocalDateTime createDateTime,
                            Long id,
                            String requestUsername
                            ){
            this.title = title;
            this.content = content;
            this.approvalStatus = approvalStatus.getDescription();
            this.approvalType = approvalType.getDescription();
            this.createDateTime = createDateTime;
            this.id = id;
            this.requestUsername = requestUsername;
        }
    }

    @Getter
    @Setter
    public static class approvalDetailParam{

        private Long approvalId;

    }

    @Getter
    public static class approvalDetail {

        private String title;
        private String content;
        private String approvalStatus;
        private String approvalType;
        private Integer approvalNumber;
        private LocalDateTime createDateTime;
        private String requestUserName;

        public approvalDetail(String title,
                              String content,
                              ApprovalStatusEnum approvalStatus,
                              ApprovalTypeEnum approvalType,
                              Integer approvalNumber,
                              LocalDateTime createDateTime,
                              String requestUserName
        ){
            this.title = title;
            this.content = content;
            this.approvalStatus = approvalStatus.getDescription();
            this.approvalType = approvalType.getDescription();
            this.approvalNumber= approvalNumber;
            this.createDateTime = createDateTime;
            this.requestUserName = requestUserName;

        }
    }
}
