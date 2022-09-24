package com.example.yjtodobe.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.yjtodobe.domain.ImageFile;
import com.example.yjtodobe.domain.QImageFile;
import com.example.yjtodobe.model.ImageFileDto;
import com.example.yjtodobe.model.ImageFileDto.detailReadParam;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class ImageFileRepositorySupportImpl extends QuerydslRepositorySupport implements ImageFileRepositorySupport {

    final JPAQueryFactory jpaQueryFactory;

    public ImageFileRepositorySupportImpl(EntityManager entityManager) {
        super(ImageFile.class);
        setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);
            }

    @Override
    public ImageFileDto.detailRead detailRead(detailReadParam param) {
        QImageFile imageFile = QImageFile.imageFile;

        final BooleanExpression isUseYn = imageFile.useYn.eq('Y');
        final BooleanExpression isDelYn = imageFile.delYn.eq('N');

        final BooleanExpression isImageId = imageFile.imageId.eq(param.getDetailParamsId());

        return jpaQueryFactory.select(Projections.constructor(ImageFileDto.detailRead.class,
                                    imageFile.createDateTime,
                                    imageFile.imageId,
                                    imageFile.imageFilename
        
        ))
                                
                                .from(imageFile)
                                .where(isImageId
                                    .and(isUseYn)
                                    .and(isDelYn)
                                    )
        .fetchFirst();
    }

    @Override
    public List<com.example.yjtodobe.model.ImageFileDto.read> read() {

        QImageFile imageFile = QImageFile.imageFile;

        final BooleanExpression isUseYn = imageFile.useYn.eq('Y');
        final BooleanExpression isDelYn = imageFile.delYn.eq('N');

        return jpaQueryFactory.select(Projections.constructor(ImageFileDto.read.class, 
                                    imageFile.imageId,
                                    imageFile.createDateTime,
                                    imageFile.imageFilename
        )) 
                                .from(imageFile)
                                .where(isUseYn
                                    .and(isDelYn)
                                )
                                .orderBy(imageFile.createDateTime.desc())
                                .fetch();
    }
}
