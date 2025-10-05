package com.dailyhaul.product.service;

import com.dailyhaul.product.dto.ProductRequest;
import com.dailyhaul.product.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();

    ProductResponse updateProduct(Long productId, ProductRequest productRequest);

    boolean deleteProduct(Long productId);

    List<ProductResponse> searchProducts(String keyword);

    ProductResponse getProductById(Long id);
}
