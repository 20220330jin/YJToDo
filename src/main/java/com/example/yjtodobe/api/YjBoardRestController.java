package com.example.yjtodobe.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yjtodobe.model.YjBoardDto;
import com.example.yjtodobe.service.YjBoardService;

@RestController
@RequestMapping("yjBoard")
public class YjBoardRestController {

    YjBoardService yjBoardService;
    
    @PostMapping("/write")
    void create(YjBoardDto.createTitle createTitle){
        yjBoardService.create(createTitle);
        
    }

}