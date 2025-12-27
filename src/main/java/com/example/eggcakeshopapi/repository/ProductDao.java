package com.example.eggcakeshopapi.repository;

import com.example.eggcakeshopapi.dto.ProductRequest;
import com.example.eggcakeshopapi.entity.Product;

import java.util.List;


public interface ProductDao {
//  TODO-查詢Product(所有)
    List<Product> getAllProducts();
//  TODO-Read查詢Product整筆的資料有條件
    List<Product> getProducts(String name, Integer minProduct, Integer maxProduct);
//  TODO-查詢Product=>ID
    Product getProductById(Long productId) ;
//  TODO-creat新增Product=>ID
    Long createProduct(ProductRequest productRequest);
//  TODO-PUT-查詢編號並更新口味
    void updateProduct(Long productId,ProductRequest productRequest);
//  TODO-刪除Product=>ID
    void deleteProduct(Long productId);
}
