package com.example.yjtodobe.repository;

import com.example.yjtodobe.model.ApprovalDto;

import java.util.List;

public interface ApprovalRepositorySupport {

    List<ApprovalDto.approvalList> approvalList();

    /**
     * 결재번호 채번 용도
     * - 가장 최근의 유효한 결재번호를 조회하여 가져온다
     * @return
     */
    Integer findMaxApprovalNumber();

    /**
     * 결재 상세조회
     */
    ApprovalDto.approvalDetail approvalDetail(Long approvalId);
}
