package com.example.yjtodobe.api;

import com.example.yjtodobe.config.JwtTokenProvider;
import com.example.yjtodobe.domain.User;
import com.example.yjtodobe.model.MemberDto;
import com.example.yjtodobe.repository.UserRepository;
import com.example.yjtodobe.service.MemberService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3002")
public class UserRestController {

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;

    private final MemberService memberService;
    
    @PostMapping("/signup")
    public Long signup(@RequestBody MemberDto.signupParam param){
        return memberService.signup(param);
    }

    @PostMapping("/login")
    public MemberDto.login login(@RequestBody @NotNull MemberDto.loginParam loginMember) {
        User user = userRepository.findByUsername(loginMember.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID 입니다."));
        if (!passwordEncoder.matches(loginMember.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return new MemberDto.login(user.getUsername(), user.getName(),"true",jwtTokenProvider.createToken(user.getUsername(), user.getRoles()));
    }
}
