package com.backend.user.service.portone;

import com.backend.user.domain.portone.Member;
import com.backend.user.domain.portone.Order;

public interface OrderService {
    Order autoOrder(Member member); // 자동 주문
}
