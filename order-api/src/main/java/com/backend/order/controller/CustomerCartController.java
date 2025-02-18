package com.backend.order.controller;

import com.backend.domain.config.JwtAuthenticationProvider;
import com.backend.order.application.CartApplication;
import com.backend.order.domain.product.AddProductCartForm;
import com.backend.order.domain.redis.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer/cart")
public class CustomerCartController {

    private final CartApplication cartApplication;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    @PostMapping
    public ResponseEntity<Cart> addCart(
            @RequestHeader(name = "X-AUTH-TOKEN") String token,
            @RequestBody AddProductCartForm form) {
        return ResponseEntity.ok(cartApplication.addCart(jwtAuthenticationProvider.getUserVo(token).getId(), form));
    }

    @GetMapping
    public ResponseEntity<Cart> showCart(
            @RequestHeader(name = "X-AUTH-TOKEN") String token) {
        return ResponseEntity.ok(cartApplication.getCart(jwtAuthenticationProvider.getUserVo(token).getId()));
    }

    @PutMapping
    public ResponseEntity<Cart> updateCart(
            @RequestHeader(name = "X-AUTH-TOKEN") String token,
            @RequestBody Cart cart) {
        return ResponseEntity.ok(cartApplication.updateCart(jwtAuthenticationProvider.getUserVo(token).getId(), cart));
    }


}
