package com.backend.user.domain.model;

import com.backend.user.domain.auth.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;  // ID는 social login에 따라 다르게 설정됩니다 (ex: google_123456)

    private String nickname;

    private String email;

    private String password;

    private String provider;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
