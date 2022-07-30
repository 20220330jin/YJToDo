package com.example.yjtodobe.service;

import com.example.yjtodobe.domain.ApprovalTypeEnum;
import com.example.yjtodobe.model.ApprovalDto;
import com.example.yjtodobe.repository.ApprovalRepositoryManager;
import com.example.yjtodobe.repository.ApprovalRepositorySupport;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {

    final ApprovalRepositoryManager approvalRepositoryManager;

    @NonNull
    final ApprovalRepositorySupport approvalRepositorySupport;

    @Override
    public void approvalRequest(ApprovalDto.approvalRequestParam param) {

        // 결재 타입 체크
//        ApprovalTypeEnum approvalType = ApprovalTypeEnum.NONE;
//        if(param.getApprovalType().equals(ApprovalTypeEnum.VACATION.name())){
//            approvalType = ApprovalTypeEnum.VACATION;
//        }else if(param.getApprovalType().equals(ApprovalTypeEnum.PAYMENT.name())){
//            approvalType = ApprovalTypeEnum.PAYMENT;
//        }

//        approvalRepositoryManager.approvalRequest(param, approvalType);
        approvalRepositoryManager.approvalRequest(param);
    }

    @Override
    public List<ApprovalDto.approvalList> approvalList() {
        return approvalRepositorySupport.approvalList();
    }
}
