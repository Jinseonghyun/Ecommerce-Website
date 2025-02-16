package com.backend.user.domain.customer;

import lombok.Getter;

@Getter
public class ChangeBalanceForm {

    // 출금과 입금을 같은 걸로 취급할 것
    private String from;
    private String message;
    private Integer money;
}
