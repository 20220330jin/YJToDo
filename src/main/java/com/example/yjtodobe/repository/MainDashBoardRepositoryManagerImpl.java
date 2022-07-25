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

    public MainDashBoardRepositoryManagerImpl(EntityManager entityManager){
        super(MainDashBoard.class);
        super.setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);

    }

//    public MainDashBoardRepositoryManagerImpl(EntityManager entityManager) {
//        super(MainDashBoard.class);
//        super.setEntityManager(entityManager);
//        jpaQueryFactory = new JPAQueryFactory(entityManager);
//    }

    @Override
    public void create(MainDashBoardDto.createParam createParam) {
        final EntityManager entityManager = super.getEntityManager();
        // data를 db에 저장하기 위해 entity 변수에 전달받은 변수를 저장
        final MainDashBoard mainDashBoard = MainDashBoard.create(createParam).get();
        
        // 저장한 entity를 가져와서 직접 db에 저장하는 위치
        entityManager.persist(mainDashBoard);
    }
}
