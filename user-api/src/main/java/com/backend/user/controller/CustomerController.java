package com.backend.user.controller;

import com.backend.domain.config.JwtAuthenticationProvider;
import com.backend.domain.domain.common.UserVo;
import com.backend.user.domain.customer.CustomerDto;
import com.backend.user.domain.model.Customer;
import com.backend.user.exception.CustomException;
import com.backend.user.exception.ErrorCode;
import com.backend.user.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final CustomerService customerService;

    @GetMapping("/getInfo")
    public ResponseEntity<CustomerDto> getInfo(@RequestHeader(name = "X-AUTH-TOKEN") String token) {
        UserVo userVo = jwtAuthenticationProvider.getUserVo(token);
        Customer customer = customerService.findByIdAndEmail(userVo.getId(), userVo.getEmail()).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_USER));

        return ResponseEntity.ok(CustomerDto.from(customer));
    }

}
