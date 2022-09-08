package com.example.yjtodobe.repository;

import com.example.yjtodobe.domain.YjTodo;
import com.example.yjtodobe.domain.QYjTodo;
import com.example.yjtodobe.model.YjTodoDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class YjTodoRepositorySupportImpl extends QuerydslRepositorySupport implements YjTodoRepositorySupport {

    final JPAQueryFactory jpaQueryFactory;

    public YjTodoRepositorySupportImpl(EntityManager entityManager) {
        super(YjTodo.class);
        setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<YjTodoDto.list> list() {
        // Domain(Table)에 접근하기 위해 QDomain 형식으로 선언
        QYjTodo yjTodo = QYjTodo.yjTodo;

        // flag 조건
        final BooleanExpression isUseYn = yjTodo.useYn.eq('Y');
        final BooleanExpression isDelYn = yjTodo.delYn.eq('N');
        final BooleanExpression isCompletedYn = yjTodo.completedYn.eq('N');

        return jpaQueryFactory.select(Projections.constructor(YjTodoDto.list.class,
                yjTodo.id,
                yjTodo.todoContent,
                yjTodo.updateDateTime,
                yjTodo.completedYn,
                yjTodo.yjTodoType
                )).from(yjTodo)
                .where(isDelYn
                        .and(isUseYn)
                )
                // .where(isCompletedYn)
                .orderBy(yjTodo.completedYn.asc(), yjTodo.updateDateTime.desc())
                .fetch();
    }

    @Override
    public char checkTodo(Long todoId) {
        // TODO Auto-generated method stub
        QYjTodo yjTodo = QYjTodo.yjTodo;

        // 조회 조건
        final BooleanExpression isTodoId = yjTodo.id.eq(todoId);

        // flag 조건
        final BooleanExpression isUseYn = yjTodo.useYn.eq('Y');
        final BooleanExpression isDelYn = yjTodo.delYn.eq('N');

        return jpaQueryFactory.select(yjTodo.completedYn)
            .from(yjTodo)
            .where(isTodoId
            .and(isUseYn)
            .and(isDelYn)
            )
            .fetchFirst();
            
        
    }

    @Override
    public List<YjTodoDto.completedList> completedList() {

        QYjTodo yjTodo = QYjTodo.yjTodo;

        final BooleanExpression isUseYn = yjTodo.useYn.eq('N');
        final BooleanExpression isDelYn = yjTodo.delYn.eq('Y');
        final BooleanExpression isCompleted = yjTodo.completedYn.eq('Y');

        return jpaQueryFactory.select(Projections.constructor(YjTodoDto.completedList.class, 
                                    yjTodo.id,
                                    yjTodo.todoContent,
                                    yjTodo.updateDateTime,
                                    yjTodo.completedYn
        )) 
                                .from(yjTodo)
                                .where(isUseYn
                                    .and(isDelYn)
                                    .and(isCompleted)
                                )
                                .orderBy(yjTodo.updateDateTime.desc())
                                .fetch();
    }
    
}