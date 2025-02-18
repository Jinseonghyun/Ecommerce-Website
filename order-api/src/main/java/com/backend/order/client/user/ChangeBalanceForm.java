package com.backend.order.client.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeBalanceForm {

    // 출금과 입금을 같은 걸로 취급할 것
    private String from;
    private String message;
    private Integer money;
}
