package com.example.yjtodobe.model;

import java.time.LocalDateTime;
import java.util.List;

import com.example.yjtodobe.domain.YjTodo;
import com.example.yjtodobe.domain.YjTodoTypeEnum;

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
    @Setter
    public static class listAll {
        private Integer totalCount;

        private Integer checkedCount;

        private List<YjTodoDto.list> list;
    }

    @Getter
    public static class list {
        private Long id;

        private String todoContent;

        private LocalDateTime updateDateTime;

        private Character completedYn;

        private String yjTodoType;

        public list(Long id,
                    String todoContent,
                    LocalDateTime updateDateTime,
                    Character completedYn,
                    YjTodoTypeEnum yjTodoType
                    ){
            this.id = id;
            this.todoContent = todoContent;
            this.updateDateTime = updateDateTime;
            this.completedYn = completedYn;
            this.yjTodoType = yjTodoType.getDescription();
        }
    }

    // completed 된 todoItem List Read
    @Getter
    public static class completedList {
        private Long id;

        private String todoContent;

        private LocalDateTime updateDateTime;

        private Character completedYn;

        public completedList(Long id,
                    String todoContent,
                    LocalDateTime updateDateTime,
                    Character completedYn
                    ){
            this.id = id;
            this.todoContent = todoContent;
            this.updateDateTime = updateDateTime;
            this.completedYn = completedYn;
        }
    }


    // YjTodo delete
    @Getter
    public static class todoDeleteParam {
        private Long yjTodoId;
    }

    // YjTodo completed하는 체크 기능
    @Getter
    @Setter
    public static class todoCheckParam {
        private long yjTodoId;
        // private char completedYn;
    }

    // YjTodo edit
    @Getter
    public static class todoEditParam {
        private Long todoId;

        private String todoContent;
    }

    @Getter
    public static class todoReturnParam {
        private Long yjTodoId;
    }

}
