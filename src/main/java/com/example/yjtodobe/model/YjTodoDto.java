package com.example.yjtodobe.model;

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

        // private LocalDateTime createDateTime;

        private LocalDateTime updateDateTime;

        private Character completedYn;

        public list(Long id,
                    String todoContent,
                    // LocalDateTime createDateTime,
                    LocalDateTime updateDateTime,
                    Character completedYn
                    ){
            this.id = id;
            this.todoContent = todoContent;
            // this.createDateTime = createDateTime;
            this.updateDateTime = updateDateTime;
            this.completedYn = completedYn;
        }
    }

    @Getter
    public static class todoDeleteParam {
        private Long yjTodoId;
    }

    @Getter
    @Setter
    public static class todoCheckParam {
        private long yjTodoId;
        // private char completedYn;
    }

    @Getter
    public static class todoEditParam {
        private Long todoId;

        private String todoContent;
    }
}
