package com.example.yjtodobe.domain;

import com.example.yjtodobe.model.YjTodoDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import java.util.function.Supplier;

@Entity
@NoArgsConstructor
@Getter
public class YjTodo extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "YjTodoId")
    public Long id;

    public String todoContent;

    @Column(nullable = false)
    @ColumnDefault("'N'")
    protected char completedYn = 'N';
   
    public YjTodo(YjTodoDto.createParam createParam){
        this.todoContent = createParam.getTodoContent();
    }


    public static Supplier<YjTodo> create(YjTodoDto.createParam param){

        return () -> new YjTodo(param);
    }
}