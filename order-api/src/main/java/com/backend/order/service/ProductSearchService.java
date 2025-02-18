package com.backend.order.service;

import com.backend.order.domain.model.Product;
import com.backend.order.exception.CustomException;
import com.backend.order.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.backend.order.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class ProductSearchService {

    private final ProductRepository productRepository;

    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }

    public Product getByProductId(Long productId) {
        return productRepository.findWithProductItemsById(productId)
                .orElseThrow(() -> new CustomException(NOT_FOUND_PRODUCT));
    }

    public List<Product> getListByProductIds(List<Long> productIds) {
        return productRepository.findAllByIdIn(productIds);
    }
}
