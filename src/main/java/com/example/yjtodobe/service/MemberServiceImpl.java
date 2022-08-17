package com.example.yjtodobe.service;

import com.example.yjtodobe.domain.MemberTypeEnum;
import com.example.yjtodobe.domain.User;
import com.example.yjtodobe.model.MemberDto;
import com.example.yjtodobe.repository.MemberRepository;
import com.example.yjtodobe.repository.MemberRepositorySupport;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    final MemberRepository memberRepository;

    final PasswordEncoder passwordEncoder;

    final MemberRepositorySupport memberRepositorySupport;


    @Override
    public Long signup(MemberDto.signupParam param) {
        return memberRepository.save(User.builder()
                .username(param.getUsername())
                .name(param.getName())
                .password(passwordEncoder.encode(param.getPassword()))
                .memberType(MemberTypeEnum.NORMAL)
                .roles(Collections.singletonList("ROLE_USER"))
                .build()).getId();
    }


    @Override
    public List<MemberDto.list> list() {
        List<MemberDto.list> members = memberRepositorySupport.list();
        return members;
    }
}
