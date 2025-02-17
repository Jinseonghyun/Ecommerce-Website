package com.backend.order.repository;

import com.backend.order.domain.model.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> searchByName(String name);
}
