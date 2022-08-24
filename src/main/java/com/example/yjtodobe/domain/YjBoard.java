package com.example.yjtodobe.domain;

import java.util.function.Supplier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.yjtodobe.model.YjBoardDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class YjBoard extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "YjBoardId")
    public Long id;

    public String title;

    public String content;

    public String author;

    public Long viewsCount;

    public YjBoard(YjBoardDto.createParam createParam){
        this.title = createParam.getTitle();
        this.content = createParam.getContent();
        this.author = createParam.getAuthor();
    }


    public static Supplier<YjBoard> create(YjBoardDto.createParam param){

        return () -> new YjBoard(param);
    }
}
