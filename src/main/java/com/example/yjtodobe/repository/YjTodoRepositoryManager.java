package com.example.yjtodobe.repository;

import com.example.yjtodobe.model.YjTodoDto;

public interface YjTodoRepositoryManager {
    
    YjTodoDto.create create(YjTodoDto.createParam createParam);

    void deleteYjTodo(Long yjTodoId);
     
}