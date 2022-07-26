package com.example.yjtodobe.api;

// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.example.yjtodobe.model.YjBoardDto;
import com.example.yjtodobe.service.YjBoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("yjBoard")
@CrossOrigin("http://localhost:3002")
@RequiredArgsConstructor

public class YjBoardRestController {

    final YjBoardService yjBoardService;
    
    @PostMapping("/write")
    public void create(@RequestBody YjBoardDto.createParam createParam){
        yjBoardService.create(createParam);
        
    };

}