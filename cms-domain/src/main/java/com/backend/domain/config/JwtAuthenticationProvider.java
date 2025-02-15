//package com.backend.domain.config;
//
//import com.backend.domain.domain.common.UserType;
//import com.backend.domain.util.Aes256Util;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//
//public class JwtAuthenticationProvider {
//    private String secretKey = "secretKey";
//
//    private long tokenValidTime = 1000L * 60 * 60 * 24;
//
//    private String createToken(String userPk, Long id, UserType userType) {
//        Claims claims = Jwts.claims().setSubject(Aes256Util);
//    }
//}
