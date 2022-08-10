package com.example.yjtodobe.service;

import com.example.yjtodobe.model.YjTodoDto;

import java.util.List;


public interface YjTodoService {
   
    YjTodoDto.create create(YjTodoDto.createParam createParam);

   
    List<YjTodoDto.list> list();

    
    void deleteTodo(YjTodoDto.todoDeleteParam param);
}
