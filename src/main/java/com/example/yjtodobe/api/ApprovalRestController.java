package com.example.yjtodobe.api;

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
    void approvalRequest(@RequestBody ApprovalDto.approvalRequestParam param){
        approvalService.approvalRequest(param);
    }

    @GetMapping("/approvalList")
    List<ApprovalDto.approvalList> approvalList(){
        return approvalService.approvalList();
    }
}
