package org.zerock.api01.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.api01.dto.MemberDTO;
import org.zerock.api01.service.MemberService;
import org.zerock.api01.util.JWTUtil;

import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/sample/member")
public class SampleMemberController {

    private final MemberService memberService;

    private final JWTUtil jwtUtil;


    @PostMapping("/login")
    public Map<String, String> login(@RequestBody MemberDTO memberDTO){

        log.info("===========================");
        log.info(memberDTO);

        MemberDTO result = memberService.getMember(memberDTO.getMid(), memberDTO.getMpw());

        log.info(result);

        String accessToken = jwtUtil.generateToken(Map.of("mid", result.getMid()), 1);
        String refreshToken = jwtUtil.generateToken(Map.of("mid", result.getMid()), 30);

        return Map.of("accessToken", accessToken, "refreshToken", refreshToken);

    }

    @PostMapping("/refresh")
    public Map<String, String> refresh(@RequestBody Map<String, String> tokenMap){

        String refreshToken = tokenMap.get("refreshToken");

        Map<String, Object> claims = jwtUtil.validateToken(refreshToken);

        log.info(claims);

        String mid = (String)claims.get("mid");

        log.info("MID " + mid);

        String accessToken = jwtUtil.generateToken(Map.of("mid", mid), 1);
        //String newRefreshToken = jwtUtil.generateToken(Map.of("mid", mid), 30);

        return Map.of("accessToken", accessToken, "refreshToken", refreshToken);

    }



}
