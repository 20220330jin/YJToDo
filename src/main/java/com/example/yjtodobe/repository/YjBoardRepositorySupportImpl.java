package com.example.yjtodobe.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.yjtodobe.domain.QYjBoard;
import com.example.yjtodobe.domain.YjBoard;
import com.example.yjtodobe.model.YjBoardDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class YjBoardRepositorySupportImpl extends QuerydslRepositorySupport implements YjBoardRepositorySupport {

    final JPAQueryFactory jpaQueryFactory;

    public YjBoardRepositorySupportImpl(EntityManager entityManager) {
        super(YjBoard.class);
        setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);
            }

    @Override
    public List<YjBoardDto.read> read() {
        
        QYjBoard yjBoard = QYjBoard.yjBoard;

        final BooleanExpression isUseYn = yjBoard.useYn.eq('Y');
        final BooleanExpression isDelYn = yjBoard.delYn.eq('N');
        return jpaQueryFactory.select(Projections.constructor(YjBoardDto.read.class, 
            yjBoard.id,
            yjBoard.title
        )) 
        .from(yjBoard)
        .where(isUseYn
        .and(isDelYn)
        )
        .fetch();
    }
    
}
