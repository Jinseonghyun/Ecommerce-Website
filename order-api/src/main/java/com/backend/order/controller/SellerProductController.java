package com.backend.order.controller;

import com.backend.domain.config.JwtAuthenticationProvider;
import com.backend.order.domain.product.*;
import com.backend.order.service.ProductItemService;
import com.backend.order.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller/product")
@RequiredArgsConstructor
public class SellerProductController {

    private final ProductService productService;
    private final ProductItemService productItemService;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                                           @RequestBody AddProductForm form) {

        return ResponseEntity.ok(ProductDto.from(productService.addProduct(jwtAuthenticationProvider.getUserVo(token).getId(), form)));
    }

    @PostMapping("/item")
    public ResponseEntity<ProductDto> addProductItem(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                                                     @RequestBody AddProductItemForm form) {

        return ResponseEntity.ok(ProductDto.from(productItemService.addProductItem(jwtAuthenticationProvider.getUserVo(token).getId(), form)));
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                                                 @RequestBody UpdateProductForm form) {

        return ResponseEntity.ok(ProductDto.from(productService.updateProduct(jwtAuthenticationProvider.getUserVo(token).getId(), form)));
    }

    @PutMapping("/item")
    public ResponseEntity<ProductItemDto> updateProductItem(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                                                     @RequestBody UpdateProductItemForm form) {

        return ResponseEntity.ok(ProductItemDto.from(productItemService.updateProductItem(jwtAuthenticationProvider.getUserVo(token).getId(), form)));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                                                    @RequestParam Long id) {

        productService.deleteProduct(jwtAuthenticationProvider.getUserVo(token).getId(), id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/item")
    public ResponseEntity<Void> deleteProductItem(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                                                  @RequestParam Long id) {
        productItemService.deleteProductItem(jwtAuthenticationProvider.getUserVo(token).getId(), id);
        return ResponseEntity.ok().build();
    }
}
