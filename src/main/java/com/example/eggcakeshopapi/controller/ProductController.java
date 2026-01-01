package com.example.eggcakeshopapi.controller;


import com.example.eggcakeshopapi.dto.ApiResponse;
import com.example.eggcakeshopapi.entity.Product;
import com.example.eggcakeshopapi.dto.ProductRequest;
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

    //    TODO-Read查詢Product整筆的資料有條件(無參數&有參數皆可查詢)
    @GetMapping("/products")
    public ApiResponse<List<Product>> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer min,
            @RequestParam(required = false) Integer max
    ) {
        List<Product> products;
        // 如果有帶參數，執行搜尋邏輯；沒帶參數，執行獲取全部邏輯
        products = productService.searchProducts(name, min, max);
        return ApiResponse.success(products);

    }

    //    TODO-Read查詢Product單筆資料
    @GetMapping("/products/{productsId}")
    public ApiResponse<Product> getProductById(@PathVariable Long productsId) {
        Product product = productService.getProductById(productsId);
        if (product == null) {
            return ApiResponse.fail("Product not found");
        } else {
            return ApiResponse.success(product);
        }
    }

    // TODO-POST-Creat新增一筆新口味雞蛋糕
    @PostMapping("/products")
    public ApiResponse<Product> createProduct(@RequestBody ProductRequest productRequest) {
        Long productId = productService.createProduct(productRequest);
        Product product = productService.getProductById(productId);
        return ApiResponse.success(product);
    }

    //    TODO-PUT-查詢編號並更新口味
    @PutMapping("/products/{productsId}")
    public ApiResponse<Product> updateProduct(@PathVariable Long productsId, @RequestBody ProductRequest productRequest) {
//        檢查productsId是否存在
        Product product = productService.getProductById(productsId);
        if (product == null) {
                return ApiResponse.fail("Product not found");
        }
//         修改productsId的數據
        productService.updateProduct(productsId, productRequest);
        Product updaateProduct = productService.getProductById(productsId);
        return ApiResponse.success(updaateProduct);
    }

    //    TODO-DELETE-刪除一筆資料
    @DeleteMapping("/products/{productsId}")
    public ApiResponse<Product> deleteProduct(@PathVariable Long productsId) {
        Product product = productService.getProductById(productsId);
        if (product == null) {
                return ApiResponse.fail("Product not found");
        }
        productService.deleteProduct(productsId);
        return ApiResponse.success(product);
    }

}
