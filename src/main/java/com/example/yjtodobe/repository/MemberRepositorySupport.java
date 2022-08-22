package com.example.yjtodobe.repository;

import java.util.List;

import com.example.yjtodobe.model.MemberDto;

public interface MemberRepositorySupport {
    List<MemberDto.list> list();

    MemberDto.detailRead detailRead(MemberDto.detailReadParam param);
}
