package com.example.yjtodobe.api;

import java.util.List;

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
    

    // write 페이지 insert 기능 
    @PostMapping("/write")
    public void create(@RequestBody YjBoardDto.createParam createParam){
        yjBoardService.create(createParam);
        
    };
    
    // read
    @GetMapping("/read")
    public List<YjBoardDto.read> read() {
        return yjBoardService.read();
    };

    // detail 
    @GetMapping("/detail")
    public YjBoardDto.detailRead detailRead(@ModelAttribute YjBoardDto.detailReadParam param) {
        return yjBoardService.detailRead(param);
    }
    
    // delete
    @PutMapping("/delete")
    public void delete(@RequestBody YjBoardDto.boardDeleteParam param){
        yjBoardService.boardDelete(param);
    }
    // update
    @PutMapping("/update")
    public void update(@RequestBody YjBoardDto.boardUpdateParam param){
        yjBoardService.boardUpdate(param);
    }
}