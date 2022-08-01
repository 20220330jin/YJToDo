package com.example.yjtodobe.service;

import com.example.yjtodobe.model.ApprovalDto;

import java.util.List;

public interface ApprovalService {

    /**
     *
     */
    void approvalRequest(ApprovalDto.approvalRequestParam param);

    /**
     *
     */
    List<ApprovalDto.approvalList> approvalList();

    /**
     *
     */
    ApprovalDto.approvalDetail approvalDetail(ApprovalDto.approvalDetailParam param);

    /**
     * 결재 승인
     */
    void approvalConfirm(ApprovalDto.approvalConfirmParam param);
}
