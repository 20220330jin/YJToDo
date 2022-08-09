package com.example.yjtodobe.service;

import com.example.yjtodobe.model.MemberDto;

public interface MemberService {

    /**
     * 회원가입
     * @param param
     * @return
     */
    Long signup(MemberDto.signupParam param);
}
