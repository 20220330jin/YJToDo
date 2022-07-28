package com.example.yjtodobe.domain;

import com.example.yjtodobe.model.ApprovalDto;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private ApprovalStatusEnum approvalStatus;

    public Approval(String title, String content, ApprovalStatusEnum approvalStatus){
        this.title = title;
        this.content = content;
        this.approvalStatus = approvalStatus;
    }

    // 결재요청
    public Approval(ApprovalDto.approvalRequestParam param){
        this.title = param.getTitle();
        this.content = param.getContent();
        this.approvalStatus = ApprovalStatusEnum.REQUEST;
    }

    public static Supplier<Approval> approvalRequest(ApprovalDto.approvalRequestParam param){

        return () -> new Approval(param);

    }

}
