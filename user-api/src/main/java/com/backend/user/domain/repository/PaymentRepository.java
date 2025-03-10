package com.backend.user.domain.repository;

import com.backend.user.domain.portone.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
