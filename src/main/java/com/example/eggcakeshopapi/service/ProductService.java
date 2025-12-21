package com.example.eggcakeshopapi.service;

import com.example.eggcakeshopapi.entity.Product;
import com.example.eggcakeshopapi.repository.ProductRequest;

import java.util.List;

public interface ProductService {
    //  查詢Product(所有)
    List<Product> getAllProducts();
    //  查詢Product=>ID
    Product getProductById(Long productId) ;
    //   新增Product=>ID
    Integer createProduct(ProductRequest productRequest);
    //   更新Product=>ID
    void updateProduct(Long productId,ProductRequest productRequest);
    //   刪除Product=>ID
    void deleteProduct(Long productId);
}
