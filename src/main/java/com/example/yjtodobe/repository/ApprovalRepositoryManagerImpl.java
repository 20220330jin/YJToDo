package com.example.yjtodobe.repository;

import com.example.yjtodobe.domain.Approval;
import com.example.yjtodobe.domain.ApprovalTypeEnum;
import com.example.yjtodobe.model.ApprovalDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ApprovalRepositoryManagerImpl extends QuerydslRepositorySupport implements ApprovalRepositoryManager {

    final JPAQueryFactory jpaQueryFactory;

    public ApprovalRepositoryManagerImpl(EntityManager entityManager) {
        super(Approval.class);
        setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public void approvalRequest(ApprovalDto.approvalRequestParam param) {
        final EntityManager entityManager = super.getEntityManager();

        final Approval approval = Approval.approvalRequest(param).get();
        entityManager.persist(approval);

    }
}
