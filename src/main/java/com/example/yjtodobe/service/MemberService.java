package com.example.yjtodobe.service;

import java.util.List;

import com.example.yjtodobe.model.MemberDto;

public interface MemberService {

    /**
     * 회원가입
     * @param param
     * @return
     */
    Long signup(MemberDto.signupParam param);

    // 유저정보 리스트 조회

    List<MemberDto.list> list();

    MemberDto.detailRead detailRead(MemberDto.detailReadParam param);
}
