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
    
    List<MemberDto.list> search(MemberDto.searchParam param);

    MemberDto.detailRead detailRead(MemberDto.detailReadParam param);

    MemberDto.signupCheck signupCheck(MemberDto.signupCheckParam param);

    List<MemberDto.idFind> idFind(MemberDto.idFindParam param);

    // 비밀번호 찾기 -> 비밀번호 초기화
    void pwFind(MemberDto.pwFindParam param);
}
