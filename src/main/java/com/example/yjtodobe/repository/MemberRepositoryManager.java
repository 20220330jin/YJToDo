package com.example.yjtodobe.repository;

import com.example.yjtodobe.model.MemberDto;

public interface MemberRepositoryManager {
    void pwFind(MemberDto.pwFindParam param);
}
