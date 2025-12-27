package com.example.eggcakeshopapi.service;

import com.example.eggcakeshopapi.entity.Product;
import com.example.eggcakeshopapi.dto.ProductRequest;

import java.util.List;

public interface ProductService {
    //  TODO-Read查詢Product(所有)
    List<Product> getAllProducts();
    //   TODO-Read查詢Product整筆的資料有條件
    List<Product> searchProducts(String name,Integer min,Integer max);
    //  TODO-Read查詢Product=>ID
    Product getProductById(Long productId) ;
    //  TODO-creat新增Product=>ID
    Long createProduct(ProductRequest productRequest);
   //  TODO-PUT-查詢編號並更新口味
    void updateProduct(Long productId,ProductRequest productRequest);
    //   TODO-刪除Product=>ID
    void deleteProduct(Long productId);
}
