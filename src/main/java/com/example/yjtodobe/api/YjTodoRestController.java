package com.example.yjtodobe.api;

import com.example.yjtodobe.model.YjTodoDto;
import com.example.yjtodobe.model.YjTodoDto.listAll;
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
    public YjTodoDto.listAll list(){
        return yjTodoService.list();
    }

    @GetMapping("/completedList")
    public List<YjTodoDto.completedList> completedList(){
        return yjTodoService.completedList();
    }

    @PutMapping("/complete")
    public void delete(@RequestBody YjTodoDto.todoDeleteParam param){
        yjTodoService.completeTodo(param);
    }
    @PutMapping("/todoDelete")
    public void todoDelete(@RequestBody YjTodoDto.todoDeleteParam param){
        yjTodoService.todoDelete(param);
    }

    @PutMapping("/check")
    public void update(@RequestBody YjTodoDto.todoCheckParam param){
        yjTodoService.checkTodo(param);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody YjTodoDto.todoEditParam param){
        yjTodoService.editTodo(param);
    }

    @PutMapping("/return")
    public void todoReturn(@RequestBody YjTodoDto.todoReturnParam param){
        yjTodoService.returnTodo(param);
    }
    
}