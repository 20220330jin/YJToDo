package com.example.yjtodobe.repository;

import com.example.yjtodobe.domain.Approval;
import com.example.yjtodobe.domain.QApproval;
import com.example.yjtodobe.model.ApprovalDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ApprovalRepositorySupportImpl extends QuerydslRepositorySupport implements ApprovalRepositorySupport {

    final JPAQueryFactory jpaQueryFactory;

    public ApprovalRepositorySupportImpl(EntityManager entityManager) {
        super(Approval.class);
        setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<ApprovalDto.approvalList> approvalList() {
        QApproval approval = QApproval.approval;

        // flag 조건
        final BooleanExpression isUseYn = approval.useYn.eq('Y');
        final BooleanExpression isDelYn = approval.delYn.eq('N');

        return jpaQueryFactory.select(Projections.constructor(ApprovalDto.approvalList.class,
                    approval.title,
                    approval.content,
                    approval.approvalStatus,
                    approval.approvalType,
                    approval.createDateTime,
                    approval.id
                ))
                .from(approval)
                .where(isUseYn
                        .and(isDelYn)
                )
                .orderBy(approval.createDateTime.desc())
                .fetch();
    }
}
