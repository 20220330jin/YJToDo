package com.example.yjtodobe.domain;

import com.example.yjtodobe.model.ApprovalDto;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.function.Supplier;

@Entity
@NoArgsConstructor
public class Approval extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "approvalId")
    private Long id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private ApprovalTypeEnum approvalType;

    @Enumerated(EnumType.STRING)
    private ApprovalStatusEnum approvalStatus;

    private Integer approvalNumber;

    private String requestUserName;

    private LocalDateTime confirmDate;

    public Approval(String title, String content, ApprovalStatusEnum approvalStatus, ApprovalTypeEnum approvalType,
                    Integer approvalNumber, LocalDateTime confirmDate
                    ){
        this.title = title;
        this.content = content;
        this.approvalStatus = approvalStatus;
        this.approvalType = approvalType;
        this.approvalNumber = approvalNumber;
        this.confirmDate = confirmDate;
    }

    // 결재요청
    public Approval(ApprovalDto.approvalRequestParam param){
        this.title = param.getTitle();
        this.content = param.getContent();
        this.approvalStatus = ApprovalStatusEnum.REQUEST;
        this.approvalType = param.getApprovalType().equals(ApprovalTypeEnum.VACATION.name()) ? ApprovalTypeEnum.VACATION : ApprovalTypeEnum.PAYMENT;
        this.approvalNumber = param.getApprovalNumber();
        this.requestUserName = param.getUserName();
    }

    public static Supplier<Approval> approvalRequest(ApprovalDto.approvalRequestParam param){

        return () -> new Approval(param);

    }

}
