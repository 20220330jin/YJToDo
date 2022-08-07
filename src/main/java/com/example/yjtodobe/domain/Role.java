package com.example.yjtodobe.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "roleId")
    private Long id;

    private String name;

}
