package com.example.yjtodobe.service;

import com.example.yjtodobe.model.YjTodoDto;

import java.util.List;


public interface YjTodoService {
   
    YjTodoDto.create create(YjTodoDto.createParam createParam);

   /**
    * 전체 조회 용도
    * @param param
    */
    YjTodoDto.listAll list();

    List<YjTodoDto.completedList> completedList();

    void deleteTodo(YjTodoDto.todoDeleteParam param);

    void checkTodo(YjTodoDto.todoCheckParam param);

    void editTodo(YjTodoDto.todoEditParam param);
}
