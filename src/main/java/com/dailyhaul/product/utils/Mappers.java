package com.dailyhaul.product.utils;

import com.dailyhaul.product.dto.ProductRequest;
import com.dailyhaul.product.dto.ProductResponse;
import com.dailyhaul.product.model.Product;

public class Mappers {

    public static ProductResponse getProductResponse(Product product) {
        return new ProductResponse(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategory(),
                product.getImageUrl(),
                product.getActive());
    }

    public static Product productReqToEnt(Product product, ProductRequest productRequest) {

        product.setName(productRequest.getName() != null ? productRequest.getName() : product.getName());
        product.setDescription(productRequest.getDescription() != null ? productRequest.getDescription() : product.getDescription());
        product.setPrice(productRequest.getPrice() != null ? productRequest.getPrice() : product.getPrice());
        product.setQuantity(productRequest.getQuantity() != null ? productRequest.getQuantity() : product.getQuantity());
        product.setCategory(productRequest.getCategory() != null ? productRequest.getCategory() : product.getCategory());
        product.setImageUrl(productRequest.getImageUrl() != null ? productRequest.getImageUrl() : product.getImageUrl());

        return product;
    }
}
