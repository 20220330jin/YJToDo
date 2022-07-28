package com.example.yjtodobe.service;

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
        approvalRepositoryManager.approvalRequest(param);
    }

    @Override
    public List<ApprovalDto.approvalList> approvalList() {
        return approvalRepositorySupport.approvalList();
    }
}
