package com.example.eggcakeshopapi.controller;


import com.example.eggcakeshopapi.entity.Product;
import com.example.eggcakeshopapi.repository.ProductRequest;
import com.example.eggcakeshopapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
//    Read查詢Product整筆的資料
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
//    Read查詢Product單筆資料
    @GetMapping("/products/{productsId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productsId) {
        Product product = productService.getProductById(productsId);
        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
//POST creat新增一筆新口味雞蛋糕
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest  productRequest) {
        Long productId = productService.createProduct(productRequest);
        Product product  = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
