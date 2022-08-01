package com.example.yjtodobe.repository;

import com.example.yjtodobe.domain.Approval;
import com.example.yjtodobe.domain.ApprovalStatusEnum;
import com.example.yjtodobe.domain.ApprovalTypeEnum;
import com.example.yjtodobe.domain.QApproval;
import com.example.yjtodobe.model.ApprovalDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

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

    @Override
    public void approvalConfirm(Long approvalId) {
        QApproval approval = QApproval.approval;

        final BooleanExpression isApprovalId = approval.id.eq(approvalId);

        jpaQueryFactory.update(approval)
                .set(approval.approvalStatus, ApprovalStatusEnum.CONFIRM)
                .set(approval.updateDateTime, LocalDateTime.now())
                .set(approval.confirmDate, LocalDateTime.now())
                .where(isApprovalId)
                .execute();
    }
}
