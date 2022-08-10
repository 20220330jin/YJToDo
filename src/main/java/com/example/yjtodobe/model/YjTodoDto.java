package com.example.yjtodobe.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.yjtodobe.domain.YjTodo;

import lombok.Getter;
import lombok.Setter;


public class YjTodoDto {

    @Getter
    public static class createParam {
        private String todoContent;
    }

    @Setter
    @Getter
    public static class create {
        private long id;

        private String todoContent;

        public create(YjTodo todo){
            this.id = todo.id;
        }
    }

    @Getter
    public static class list {
        private Long id;

        private String todoContent;

        private LocalDateTime createDateTime;

        private char completedYn;


        public list(Long id,
                    String todoContent,
                    LocalDateTime createDateTime,
                    char completedYn
                    ){
            this.id = id;
            this.todoContent = todoContent;
            this.createDateTime = createDateTime;
            this.completedYn = completedYn;
        }
    }

    @Getter
    public static class todoDeleteParam {
        private Long yjTodoId;
    }

}
