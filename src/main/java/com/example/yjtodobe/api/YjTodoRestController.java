package com.example.yjtodobe.api;

import com.example.yjtodobe.model.YjTodoDto;
import com.example.yjtodobe.service.YjTodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("yjTodo")
@CrossOrigin("http://localhost:3002")
@RequiredArgsConstructor
public class YjTodoRestController {

    final YjTodoService yjTodoService;

    @PostMapping("/create")
    public YjTodoDto.create create(@RequestBody YjTodoDto.createParam createParam){
        return yjTodoService.create(createParam);
    };

    @GetMapping("/list")
    public List<YjTodoDto.list> list(){
        return yjTodoService.list();
    }

     @PutMapping("/delete")
    public void delete(@RequestBody YjTodoDto.todoDeleteParam param){
        yjTodoService.deleteTodo(param);
    }

    @PutMapping("/check")
    public void update(@RequestBody YjTodoDto.todoCheckParam param){
        yjTodoService.checkTodo(param);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody YjTodoDto.todoEditParam param){
        yjTodoService.editTodo(param);
    }
    
}