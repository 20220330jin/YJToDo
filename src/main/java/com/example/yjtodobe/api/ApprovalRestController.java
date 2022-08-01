package com.example.yjtodobe.api;

import com.example.yjtodobe.domain.Approval;
import com.example.yjtodobe.model.ApprovalDto;
import com.example.yjtodobe.service.ApprovalService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("approval")
@CrossOrigin("http://localhost:3002") // front와 back의 origin이 달라 해당 어노테이션을 추가하여 origin 에러 해결
@RequiredArgsConstructor
public class ApprovalRestController {

    @NonNull
    final ApprovalService approvalService;

    @PostMapping("/approvalRequest")
    public void approvalRequest(@RequestBody ApprovalDto.approvalRequestParam param){
        approvalService.approvalRequest(param);
    }

    /**
     * 결재 전체 리스트 조회
     * @return
     */
    @GetMapping("/approvalList")
    public List<ApprovalDto.approvalList> approvalList(){
        return approvalService.approvalList();
    }

    /**
     * 결재 상세조회
     */
    // {params:{key: key}}
    //Model Attribute
    @GetMapping("/approvalDetail")
    public ApprovalDto.approvalDetail approvalDetail(@ModelAttribute ApprovalDto.approvalDetailParam param){
        return approvalService.approvalDetail(param);
    }

    /**
     * 결재 승인
     */
    @PutMapping("/approvalConfirm")
    public void approvalConfirm(@RequestBody ApprovalDto.approvalConfirmParam param){
        approvalService.approvalConfirm(param);
    }
}
