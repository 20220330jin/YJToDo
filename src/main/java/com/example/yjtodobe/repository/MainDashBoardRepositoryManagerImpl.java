package com.example.yjtodobe.repository;

import com.example.yjtodobe.domain.MainDashBoard;
import com.example.yjtodobe.domain.QMainDashBoard;
import com.example.yjtodobe.model.MainDashBoardDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;


@Repository
public class MainDashBoardRepositoryManagerImpl extends QuerydslRepositorySupport implements MainDashBoardRepositoryManager {

    final JPAQueryFactory jpaQueryFactory;

    public MainDashBoardRepositoryManagerImpl(EntityManager entityManager){
        super(MainDashBoard.class);
        super.setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);

    }

    @Override
    public MainDashBoardDto.create create(MainDashBoardDto.createParam createParam) {
        final EntityManager entityManager = super.getEntityManager();
        // data를 db에 저장하기 위해 entity 변수에 전달받은 변수를 저장
        final MainDashBoard mainDashBoard = MainDashBoard.create(createParam).get();
        
        // 저장한 entity를 가져와서 직접 db에 저장하는 위치
        entityManager.persist(mainDashBoard);

        return new MainDashBoardDto.create(mainDashBoard);
    }

    @Override
    public void deleteMainDashboard(Long mainDashboardId) {
        QMainDashBoard mainDashBoard = QMainDashBoard.mainDashBoard;

        // 삭제조건
        final BooleanExpression isMainDashboardId = mainDashBoard.id.eq(mainDashboardId);

        update(mainDashBoard)
                .set(mainDashBoard.updateDateTime, LocalDateTime.now())
                .set(mainDashBoard.useYn, 'N')
                .set(mainDashBoard.delYn, 'Y')
                .where(isMainDashboardId)
                .execute();
    }

    @Override
    public void updateMainDashboard(MainDashBoardDto.updateParam param) {
        QMainDashBoard mainDashBoard = QMainDashBoard.mainDashBoard;

        // 수정 조건
        final BooleanExpression isMainDashboadId = mainDashBoard.id.eq(param.getMainDashboardId());

        // flag 조건
        final BooleanExpression isUseYn = mainDashBoard.useYn.eq('Y');
        final BooleanExpression isDelYn = mainDashBoard.delYn.eq('N');

        jpaQueryFactory.update(mainDashBoard)
                .set(mainDashBoard.updateDateTime, LocalDateTime.now())
                .set(mainDashBoard.content, param.getContent())
                .where(isUseYn
                        .and(isDelYn)
                        .and(isMainDashboadId)
                )
                .execute();
    }
}
