package com.backend.user.application;

import com.backend.domain.config.JwtAuthenticationProvider;
import com.backend.domain.domain.common.UserType;
import com.backend.user.domain.SignInForm;
import com.backend.user.domain.model.Customer;
import com.backend.user.exception.CustomException;
import com.backend.user.exception.ErrorCode;
import com.backend.user.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInApplication {

    private final CustomerService customerService;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    public String customerLoginToken(SignInForm form) {
        // 1. 로그인 가능 여부
        Customer customer = customerService.findValidCustomer(form.getEmail(), form.getPassword())
                .orElseThrow(() -> new CustomException(ErrorCode.LOGIN_CHECK_FAIL));
        // 2. 토큰을 발행
        // 3. 토큰을 response한다.
        return jwtAuthenticationProvider.createToken(customer.getEmail(), customer.getId(), UserType.CUSTOMER);
    }
}
