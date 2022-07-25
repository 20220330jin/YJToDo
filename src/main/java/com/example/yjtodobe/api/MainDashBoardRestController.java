package com.example.yjtodobe.api;

import com.example.yjtodobe.model.MainDashBoardDto;
import com.example.yjtodobe.service.MainDashBoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mainDashBoard")
public class MainDashBoardRestController {

    MainDashBoardService mainDashBoardService;

    @PostMapping("/create")
    public void create(@RequestBody MainDashBoardDto.createParam createParam){
        mainDashBoardService.create(createParam);
    };
}
