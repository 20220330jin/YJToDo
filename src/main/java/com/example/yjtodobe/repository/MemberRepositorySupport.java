package com.example.yjtodobe.repository;

import java.util.List;

import com.example.yjtodobe.model.MemberDto;

public interface MemberRepositorySupport {
    List<MemberDto.list> list();

    List<MemberDto.list> search(String keyword, String type);

    MemberDto.detailRead detailRead(MemberDto.detailReadParam param);

    MemberDto.signupCheck signupCheck(MemberDto.signupCheckParam param);

    MemberDto.idFind idFind(MemberDto.idFindParam param);
}
