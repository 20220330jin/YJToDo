package com.example.yjtodobe.repository;

import com.example.yjtodobe.domain.ApprovalTypeEnum;
import com.example.yjtodobe.model.ApprovalDto;

public interface ApprovalRepositoryManager {

//    void approvalRequest(ApprovalDto.approvalRequestParam param, ApprovalTypeEnum approvalType);
    void approvalRequest(ApprovalDto.approvalRequestParam param);

    /**
     * 결재 승인
     */
    void approvalConfirm(Long approvalId);
}
