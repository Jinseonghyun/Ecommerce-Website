package com.backend.user.service.portone;

import com.backend.user.domain.portone.Payment;
import com.backend.user.domain.portone.PaymentCallbackRequest;
import com.backend.user.domain.portone.RequestPayDto;
import com.siot.IamportRestClient.response.IamportResponse;

public interface PaymentService {
    // 결제 요청 데이터 조회
    RequestPayDto findRequestDto(String orderUid);
    // 결제(콜백)
    IamportResponse<Payment> paymentByCallback(PaymentCallbackRequest request);
}
