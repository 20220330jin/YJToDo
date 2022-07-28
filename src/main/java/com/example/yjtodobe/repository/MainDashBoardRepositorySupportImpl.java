package com.example.yjtodobe.repository;

import com.example.yjtodobe.domain.MainDashBoard;
import com.example.yjtodobe.domain.QMainDashBoard;
import com.example.yjtodobe.model.MainDashBoardDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MainDashBoardRepositorySupportImpl extends QuerydslRepositorySupport implements MainDashBoardRepositorySupport {

    final JPAQueryFactory jpaQueryFactory;

    public MainDashBoardRepositorySupportImpl(EntityManager entityManager) {
        super(MainDashBoard.class);
        setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<MainDashBoardDto.list> list() {
        // Domain(Table)에 접근하기 위해 QDomain 형식으로 선언
        QMainDashBoard mainDashBoard = QMainDashBoard.mainDashBoard;

        // flag 조건
        final BooleanExpression isUseYn = mainDashBoard.useYn.eq('Y');
        final BooleanExpression isDelYn = mainDashBoard.delYn.eq('N');

        return jpaQueryFactory.select(Projections.constructor(MainDashBoardDto.list.class,
                mainDashBoard.id,
                mainDashBoard.content,
                mainDashBoard.createDateTime
                )).from(mainDashBoard)
                .where(isDelYn
                        .and(isDelYn)
                )
                .orderBy(mainDashBoard.createDateTime.desc())
                .fetch();
    }
}
