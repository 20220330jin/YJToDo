package com.example.yjtodobe.repository;

import com.example.yjtodobe.domain.QYjTodo;
import com.example.yjtodobe.domain.YjTodo;
import com.example.yjtodobe.model.YjTodoDto;
import com.example.yjtodobe.model.YjTodoDto.todoCheckParam;
import com.example.yjtodobe.model.YjTodoDto.todoDeleteParam;
import com.example.yjtodobe.service.YjTodoServiceImpl;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;


@Repository
public class YjTodoRepositoryManagerImpl extends QuerydslRepositorySupport implements YjTodoRepositoryManager {

    final JPAQueryFactory jpaQueryFactory;

    public YjTodoRepositoryManagerImpl(EntityManager entityManager){
        super(YjTodo.class);
        super.setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);

    }

    @Override
    public YjTodoDto.create create(YjTodoDto.createParam createParam) {
        final EntityManager entityManager = super.getEntityManager();
        // data를 db에 저장하기 위해 entity 변수에 전달받은 변수를 저장
        final YjTodo yjTodo = YjTodo.create(createParam).get();
        
        // 저장한 entity를 가져와서 직접 db에 저장하는 위치
        entityManager.persist(yjTodo);

        return new YjTodoDto.create(yjTodo);
    }

    @Override
    public void deleteYjTodo(Long yjTodoId) {
        QYjTodo yjTodo = QYjTodo.yjTodo;

        final BooleanExpression isYjTodoId = yjTodo.id.eq(yjTodoId);

        update(yjTodo)
                .set(yjTodo.updateDateTime, LocalDateTime.now())
                .set(yjTodo.useYn, 'N')
                .set(yjTodo.delYn, 'Y')
                .where(isYjTodoId)
                .execute();
    }

    @Override
    public void checkTodo(Long todoId, char completedYn) {
        QYjTodo yjTodo = QYjTodo.yjTodo;
        
        final  BooleanExpression isYjTodoId = yjTodo.id.eq(todoId);

        jpaQueryFactory.update(yjTodo)
                .set(yjTodo.updateDateTime, LocalDateTime.now() )
                .set(yjTodo.completedYn, completedYn)
                .where(isYjTodoId)
                .execute();
    }


    // todoList 모달 수정 api
    @Override
    public void editTodo(YjTodoDto.todoEditParam param) {
       QYjTodo yjTodo = QYjTodo.yjTodo;
       
       final BooleanExpression isYjTodoId = yjTodo.id.eq(param.getTodoId());

       jpaQueryFactory.update(yjTodo)
               .set(yjTodo.updateDateTime, LocalDateTime.now())
               .set(yjTodo.todoContent, param.getTodoContent())
               .where(isYjTodoId)
               .execute();


    }

    
}
