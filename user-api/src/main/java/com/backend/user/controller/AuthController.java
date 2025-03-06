package com.backend.user.controller;

import com.backend.user.domain.jwt.JwtTokenProvider;
import com.backend.user.domain.token.TokenRefreshRequest;
import com.backend.user.domain.token.TokenResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtTokenProvider tokenProvider;

    @PostMapping("/token/refresh")
    public ResponseEntity<TokenResponse> refreshToken(@RequestBody TokenRefreshRequest request) {
        // 리프레시 토큰 유효성 검사
        if (!tokenProvider.validateToken(request.getRefreshToken())) {
            return ResponseEntity.badRequest().build();
        }

        // 리프레시 토큰에서 사용자 ID 추출
        String userId = tokenProvider.getUserIdFromToken(request.getRefreshToken());

        // Redis에 저장된 리프레시 토큰과 비교
        String savedRefreshToken = tokenProvider.getRefreshToken(userId);

        if (savedRefreshToken == null || !savedRefreshToken.equals(request.getRefreshToken())) {
            return ResponseEntity.badRequest().build();
        }

        // 현재 인증된 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 새 액세스 토큰 발급
        String newAccessToken = tokenProvider.generateAccessToken(authentication);

        TokenResponse response = TokenResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(request.getRefreshToken())
                .tokenType("Bearer")
                .expiresIn(3600L) // 1 hour in seconds
                .build();

        return ResponseEntity.ok(response);
    }
}
