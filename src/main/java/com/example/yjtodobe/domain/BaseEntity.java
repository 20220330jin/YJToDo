package com.example.yjtodobe.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@NoArgsConstructor
public abstract class BaseEntity {

    @Column
    protected Long createUserId;

    @Column
    @CreationTimestamp
    protected LocalDateTime createDateTime;

    @Column
    @UpdateTimestamp
    protected LocalDateTime updateDateTime;

    @Column(nullable = false)
    @ColumnDefault("'Y'")
    protected char useYn = 'Y';

    @Column(nullable = false)
    @ColumnDefault("'N'")
    protected char delYn = 'N';

    protected BaseEntity(Long createUserId
            , LocalDateTime createDateTime
            , LocalDateTime updateDateTime
            , char useYn
            , char delYn
    ){
        this.createUserId = createUserId;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.useYn = useYn;
        this.delYn = delYn;
    }
}
