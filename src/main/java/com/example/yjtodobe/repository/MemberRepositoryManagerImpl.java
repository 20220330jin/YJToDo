package com.example.yjtodobe.repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.yjtodobe.domain.QUser;
import com.example.yjtodobe.domain.User;
import com.example.yjtodobe.model.MemberDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class MemberRepositoryManagerImpl extends QuerydslRepositorySupport implements MemberRepositoryManager{

    final JPAQueryFactory jpaQueryFactory;
    PasswordEncoder passwordEncoder;

    public MemberRepositoryManagerImpl(EntityManager entityManager){
        super(User.class);
        super.setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);

    }
    
    @Override
    public void pwFind(String isName, String isUserName, String password) {
        QUser user = QUser.user;

        final BooleanExpression Name = user.name.eq(isName);
        final BooleanExpression UserName = user.username.eq(isUserName);

        jpaQueryFactory.update(user)
                .set(user.password, password)
                .set(user.updateDateTime, LocalDateTime.now() )
                .where(Name
                .and(UserName))
                .execute();
    } 
    
}
