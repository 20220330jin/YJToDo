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

        // 결재 번호 체크
        // 제일 최근의 결재번호르 가져온 뒤 1을 더하여 새로운 결재 번호로 박음
        Integer maxApprovalNumber = approvalRepositorySupport.findMaxApprovalNumber();
        Integer approvalNumber = maxApprovalNumber + 1;
        param.setApprovalNumber(approvalNumber);

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

    @Override
    public ApprovalDto.approvalDetail approvalDetail(ApprovalDto.approvalDetailParam param) {
        Long approvalId = param.getApprovalId();
        return approvalRepositorySupport.approvalDetail(approvalId);
    }

    @Override
    public void approvalConfirm(ApprovalDto.approvalConfirmParam param) {
//        if(param.getApprovalId() == 0){
//            System.out.println("approvalID가 존재하지 않습니다");
//        }
        Long approvalId = param.getApprovalId();
        approvalRepositoryManager.approvalConfirm(approvalId);
    }
}
