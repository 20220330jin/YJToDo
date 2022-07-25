package com.example.yjtodobe.domain;

import com.example.yjtodobe.model.MainDashBoardDto;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.function.Supplier;

@Entity
@NoArgsConstructor
public class MainDashBoard {

    @Id
    @GeneratedValue
    @Column(name = "MainDashBoard_id")
    public Long id;

    public String content;

    public MainDashBoard(MainDashBoardDto.createParam createParam){
        this.content = createParam.getContent();
    }


    public static Supplier<MainDashBoard> create(MainDashBoardDto.createParam param){

        return () -> new MainDashBoard(param);
    }
}
