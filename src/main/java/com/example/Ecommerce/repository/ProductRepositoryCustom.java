package com.example.Ecommerce.repository;

import com.example.Ecommerce.model.Product;
import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findByAttributes(String key, Object value);
}