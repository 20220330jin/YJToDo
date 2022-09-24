package com.example.yjtodobe.domain;

import lombok.*;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter 
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="imageFile") // 테이블 명
public class ImageFile {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long imageId;

    @Column(nullable = false, unique = true, length = 1000)
    private String imageFilename;

    @Column(nullable = false)
    @ColumnDefault("'Y'")
    protected char useYn = 'Y';

    @Column(nullable = false)
    @ColumnDefault("'N'")
    protected char delYn = 'N';

    @Column
    @CreationTimestamp
    protected LocalDateTime createDateTime;
}
