package com.example.yjtodobe.repository;

import com.example.yjtodobe.domain.MainDashBoard;
import com.example.yjtodobe.model.MainDashBoardDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class MainDashBoardRepositoryManagerImpl extends QuerydslRepositorySupport implements MainDashBoardRepositoryManager {

    final JPAQueryFactory jpaQueryFactory;

    public MainDashBoardRepositoryManagerImpl(EntityManager entityManager) {
        super(MainDashBoard.class);
        super.setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }



    @Override
    public void create(MainDashBoardDto.createParam createParam) {
    }
}
