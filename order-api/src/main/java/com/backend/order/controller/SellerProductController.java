package com.backend.order.controller;

import com.backend.domain.config.JwtAuthenticationProvider;
import com.backend.order.domain.product.AddProductForm;
import com.backend.order.domain.product.ProductDto;
import com.backend.order.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller/product")
@RequiredArgsConstructor
public class SellerProductController {

    private final ProductService productService;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                                           @RequestBody AddProductForm form) {

        return ResponseEntity.ok(ProductDto.from(productService.addProduct(jwtAuthenticationProvider.getUserVo(token).getId(), form)));
    }
}
