package com.example.yjtodobe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ApprovalHistory {

    @Id
    @GeneratedValue
    @Column(name = "approvalHistoryId")
    private Long id;
}
