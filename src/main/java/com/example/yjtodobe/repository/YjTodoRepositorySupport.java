package com.example.yjtodobe.repository;

import com.example.yjtodobe.model.YjTodoDto;

import java.util.List;

public interface YjTodoRepositorySupport {
    List<YjTodoDto.list> list();

    /**
     * TODO 완료여부 조회
     */
    char checkTodo(Long todoId);
    
}
