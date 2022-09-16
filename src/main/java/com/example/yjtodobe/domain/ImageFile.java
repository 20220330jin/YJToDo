package com.example.yjtodobe.domain;

import lombok.*;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

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

    @Column
    @CreationTimestamp
    protected LocalDateTime createDateTime;
}
