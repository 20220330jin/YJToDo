package com.example.yjtodobe.repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.yjtodobe.domain.QUser;
import com.example.yjtodobe.domain.User;
import com.example.yjtodobe.model.MemberDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class MemberRepositoryManagerImpl extends QuerydslRepositorySupport implements MemberRepositoryManager{

    final JPAQueryFactory jpaQueryFactory;

    public MemberRepositoryManagerImpl(EntityManager entityManager){
        super(User.class);
        super.setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);

    }
    
    @Override
    public void pwFind(MemberDto.pwFindParam param) {
        QUser user = QUser.user;

        final BooleanExpression isName = user.name.eq(param.getName());
        final BooleanExpression isUserName = user.username.eq(param.getUsername());

        jpaQueryFactory.update(user)
                .set(user.password, "1111")
                .set(user.updateDateTime, LocalDateTime.now() )
                .where(isName
                .and(isUserName))
                .execute();
    } 
    
}
