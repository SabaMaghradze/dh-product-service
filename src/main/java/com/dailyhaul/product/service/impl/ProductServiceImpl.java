package com.dailyhaul.product.service.impl;

import com.dailyhaul.product.exception.ProductNotFoundException;
import com.dailyhaul.product.utils.Mappers;
import com.dailyhaul.product.dto.ProductRequest;
import com.dailyhaul.product.dto.ProductResponse;
import com.dailyhaul.product.model.Product;
import com.dailyhaul.product.repository.ProductRepository;
import com.dailyhaul.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final Mappers mappers;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        mappers.productReqToEnt(product, productRequest);
        Product saved = productRepository.save(product);
        return mappers.getProductResponse(saved);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(prod -> mappers.getProductResponse(prod))
                .toList();
    }

    @Override
    public ProductResponse updateProduct(Long productId, ProductRequest productRequest) {
        return productRepository.findById(productId)
                .map(daProd -> {
                    mappers.productReqToEnt(daProd, productRequest);
                    productRepository.save(daProd);
                    return mappers.getProductResponse(daProd);
                }).orElse(null);
    }

    @Override
    public boolean deleteProduct(Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        if (ObjectUtils.isEmpty(product)) {
            return false;
        }

        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public List<ProductResponse> searchProducts(String keyword) {
        return productRepository.searchProducts(keyword).stream()
                .map(mappers::getProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        return mappers.getProductResponse(product);
    }
}
