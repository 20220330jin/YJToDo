package com.example.yjtodobe.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.annotations.OrderBy;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.yjtodobe.domain.QYjBoard;
import com.example.yjtodobe.domain.YjBoard;
import com.example.yjtodobe.model.YjBoardDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class YjBoardRepositorySupportImpl extends QuerydslRepositorySupport implements YjBoardRepositorySupport {

    final JPAQueryFactory jpaQueryFactory;

    public YjBoardRepositorySupportImpl(EntityManager entityManager) {
        super(YjBoard.class);
        setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);
            }

    @Override
    public List<YjBoardDto.read> read() {
        
        QYjBoard yjBoard = QYjBoard.yjBoard;

        final BooleanExpression isUseYn = yjBoard.useYn.eq('Y');
        final BooleanExpression isDelYn = yjBoard.delYn.eq('N');
      
        return jpaQueryFactory.select(Projections.constructor(YjBoardDto.read.class, 
                                    yjBoard.id,
                                    yjBoard.title,
                                    yjBoard.content,
                                    yjBoard.author,
                                    yjBoard.createDateTime
        )) 
                                .from(yjBoard)
                                .where(isUseYn
                                    .and(isDelYn)
                                )
                                .orderBy(yjBoard.createDateTime.desc())
                                .fetch();
    }
    @Override
    public List<YjBoardDto.read> search(String keyword, String type) {
        
        QYjBoard yjBoard = QYjBoard.yjBoard;

        final BooleanExpression isUseYn = yjBoard.useYn.eq('Y');
        final BooleanExpression isDelYn = yjBoard.delYn.eq('N');
        
        BooleanExpression isTitle = null;
        BooleanExpression isAuthor = null;

        if(type.equals("TITLE")){
            isTitle = yjBoard.title.contains(keyword);
        }else if(type.equals("AUTHOR")){
            isAuthor = yjBoard.author.contains(keyword);
        }
      
        return jpaQueryFactory.select(Projections.constructor(YjBoardDto.read.class, 
                                    yjBoard.id,
                                    yjBoard.title,
                                    yjBoard.content,
                                    yjBoard.author,
                                    yjBoard.createDateTime
        )) 
                                .from(yjBoard)
                                .where(isUseYn
                                    .and(isDelYn)
                                    .and(isTitle)
                                    .and(isAuthor)
                                )
                                .fetch();
    }


    // detail read
    @Override
    public YjBoardDto.detailRead detailRead(YjBoardDto.detailReadParam param) {
        QYjBoard yjBoard = QYjBoard.yjBoard;

          // flag 조건
        final BooleanExpression isUseYn = yjBoard.useYn.eq('Y');
        final BooleanExpression isDelYn = yjBoard.delYn.eq('N');
        // id -> getId()
        // detailParamsId -> 
        final BooleanExpression isYjboardId = yjBoard.id.eq(param.getDetailParamsId());

        return jpaQueryFactory.select(Projections.constructor(YjBoardDto.detailRead.class,
                                    yjBoard.title,
                                    yjBoard.content,
                                    yjBoard.author,                                    
                                    yjBoard.createDateTime,
                                    yjBoard.id
                                   
        
        ))
                                .from(yjBoard)
                                .where(isYjboardId
                                    .and(isDelYn)
                                    .and(isUseYn)
                                )
        .fetchFirst();
    }

}
