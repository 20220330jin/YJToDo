package com.example.yjtodobe.api;

import com.example.yjtodobe.model.MainDashBoardDto;
import com.example.yjtodobe.service.MainDashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mainDashBoard")
@CrossOrigin("http://localhost:3002") // front와 back의 origin이 달라 해당 어노테이션을 추가하여 origin 에러 해결
@RequiredArgsConstructor
public class MainDashBoardRestController {

    final MainDashBoardService mainDashBoardService;

    @PostMapping("/create")
    public void create(@RequestBody MainDashBoardDto.createParam createParam){
        mainDashBoardService.create(createParam);
    };

}
