package com.example.yjtodobe.service;

import com.example.yjtodobe.domain.MemberTypeEnum;
import com.example.yjtodobe.domain.QUser;
import com.example.yjtodobe.domain.User;
import com.example.yjtodobe.model.MemberDto;
import com.example.yjtodobe.model.MemberDto.detailReadParam;
import com.example.yjtodobe.model.MemberDto.idFindParam;
import com.example.yjtodobe.model.MemberDto.pwFindParam;
import com.example.yjtodobe.model.MemberDto.searchParam;
import com.example.yjtodobe.model.MemberDto.signupCheckParam;
import com.example.yjtodobe.repository.MemberRepository;
import com.example.yjtodobe.repository.MemberRepositoryManager;
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

    final MemberRepositoryManager memberRepositoryManager;

    final PasswordEncoder passwordEncoder;

    final MemberRepositorySupport memberRepositorySupport;

    @Override
    public Long signup(MemberDto.signupParam param) {
        return memberRepository.save(User.builder()
                .username(param.getUsername())
                .name(param.getName())
                .password(passwordEncoder.encode(param.getPassword()))
                .email(param.getEmail())
                .memberType(MemberTypeEnum.NORMAL)
                .roles(Collections.singletonList("ROLE_USER"))
                .build()).getId();
    }

    @Override
    public List<MemberDto.list> list() {
        List<MemberDto.list> members = memberRepositorySupport.list();
        return members;
    }

    @Override
    public List<MemberDto.list> search(MemberDto.searchParam param) {

        String searchKeyword = param.getSearchKeyword();
        String searchType = param.getSearchType();
     
        return memberRepositorySupport.search(searchKeyword, searchType);
    }


    @Override
    public MemberDto.detailRead detailRead(detailReadParam param) {
        return memberRepositorySupport.detailRead(param);
    }
    @Override
    public MemberDto.signupCheck signupCheck(signupCheckParam param) {

        // if(param.getSignupCheckParam() == null){
            
        // }
        return memberRepositorySupport.signupCheck(param);
    
    }

    @Override
    public List<MemberDto.idFind> idFind(idFindParam param) {
        return memberRepositorySupport.idFind(param);
    }

    @Override
    public void pwFind(pwFindParam param) {
        String isName = param.getName();
        String isUserName = param.getUsername();
        String password = passwordEncoder.encode("1111");
        

        memberRepositoryManager.pwFind(isName, isUserName, password);
    }
}
