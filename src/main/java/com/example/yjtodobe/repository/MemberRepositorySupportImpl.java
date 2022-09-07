package com.example.yjtodobe.repository;

import java.lang.reflect.Member;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.yjtodobe.domain.MemberTypeEnum;
import com.example.yjtodobe.domain.QUser;
import com.example.yjtodobe.domain.User;
import com.example.yjtodobe.model.MemberDto;
import com.example.yjtodobe.model.MemberDto.detailReadParam;
import com.example.yjtodobe.model.MemberDto.idFindParam;
import com.example.yjtodobe.model.MemberDto.signupCheckParam;
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
                        user.name,
                        user.username,
                        user.createDateTime
                )).from(user)
                .where(isDelYn
                        .and(isUseYn))
                .fetch();
    }



    @Override
    public MemberDto.detailRead detailRead(detailReadParam param) {
        QUser user = QUser.user;

        final BooleanExpression isUserId = user.id.eq(param.getDetailParamsId());

        return jpaQueryFactory.select(Projections.constructor(MemberDto.detailRead.class,
                                    user.id,
                                    user.name,
                                    user.username,
                                    user.createDateTime,
                                    user.delYn,
                                    user.useYn,
                                    user.memberType,
                                    user.email
        ))
                                .from(user)
                                .where(isUserId
                                )
        .fetchFirst();
    
    }

    @Override
    public MemberDto.idFind idFind(idFindParam param) {
        QUser user = QUser.user;

        final BooleanExpression isName = user.name.eq(param.getName());
        final BooleanExpression isEmail = user.email.eq(param.getEmail());

        return jpaQueryFactory.select(Projections.constructor(MemberDto.idFind.class,
                                    user.name,
                                    user.username,
                                    user.createDateTime,
                                    user.email
        ))
                                .from(user)
                                .where(isName
                                .and(isEmail)
                                )
        .fetchFirst();
    }

     @Override
    public MemberDto.signupCheck signupCheck(signupCheckParam param) {
        QUser user = QUser.user;

        BooleanExpression isUserName = user.username.eq(param.getSignupCheckParam());

        return jpaQueryFactory.select(Projections.constructor(MemberDto.signupCheck.class,
                                    user.username,
                                    user.name
        ))
                                .from(user)
                                .where(isUserName)
        .fetchFirst();     
    }

    @Override
    public List<MemberDto.list> search(String keyword, String type) {
        QUser user = QUser.user;

        final BooleanExpression isUseYn = user.useYn.eq('Y');
        final BooleanExpression isDelYn = user.delYn.eq('N');

        BooleanExpression isName = null;
        BooleanExpression isUserName = null;

        if(type.equals("NAME")){
            isName = user.name.contains(keyword);
        }else if(type.equals("UserName")){
            isUserName = user.username.contains(keyword);
        }

        return jpaQueryFactory.select(Projections.constructor(MemberDto.list.class,
                        user.id,
                        user.name,
                        user.username,
                        user.createDateTime
                )).from(user)
                .where(isDelYn
                        .and(isUseYn)
                        .and(isName)
                        .and(isUserName))
                .fetch();
    }



    
    
}
