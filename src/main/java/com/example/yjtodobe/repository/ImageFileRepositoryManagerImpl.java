package com.example.yjtodobe.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.yjtodobe.domain.ImageFile;
import com.example.yjtodobe.domain.QImageFile;
import com.example.yjtodobe.model.ImageFileDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class ImageFileRepositoryManagerImpl extends QuerydslRepositorySupport implements ImageFileRepositoryManager{

    final JPAQueryFactory jpaQueryFactory;

    public ImageFileRepositoryManagerImpl(EntityManager entityManager){
        super(ImageFile.class);
        super.setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);

    }

    @Override
    public void boardDelete(ImageFileDto.boardDeleteParam param) {
        QImageFile imageFile = QImageFile.imageFile;

        final BooleanExpression isImageId = imageFile.imageId.eq(param.getDetailParamId());

        jpaQueryFactory.update(imageFile)
                .set(imageFile.delYn, 'Y')
                .set(imageFile.useYn, 'N')
                .where(isImageId)
                .execute();
    }
    
}
