package com.example.yjtodobe.repository;

import java.lang.reflect.Member;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.yjtodobe.domain.QUser;
import com.example.yjtodobe.domain.User;
import com.example.yjtodobe.model.MemberDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class MemberRepositorySupportImpl extends QuerydslRepositorySupport implements MemberRepositorySupport{

    final JPAQueryFactory jpaQueryFactory;
    
    public MemberRepositorySupportImpl(EntityManager entityManager) {
        super(User.class);
        setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    

    @Override
    public List<MemberDto.list> list() {
        QUser user = QUser.user;

        final BooleanExpression isUseYn = user.useYn.eq('Y');
        final BooleanExpression isDelYn = user.delYn.eq('N');

        return jpaQueryFactory.select(Projections.constructor(MemberDto.list.class,
                user.id,
                user.createDateTime,
                user.username,
                user.name
                )).from(user)
                .where(isDelYn
                        .and(isUseYn))
                .fetch();
    }
    
}
