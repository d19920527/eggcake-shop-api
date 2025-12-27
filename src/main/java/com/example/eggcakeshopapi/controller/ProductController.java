package com.example.eggcakeshopapi.controller;


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
/*
    Read查詢Product整筆的資料

//    @GetMapping("/products")
//    public ResponseEntity<List<Product>> getAllProducts() {
//        List<Product> products = productService.getAllProducts();
//        return ResponseEntity.status(HttpStatus.OK).body(products);//200
//    }
//    Read查詢Product整筆的資料有條件
//@GetMapping("/searchProducts")
//public ResponseEntity<List<Product>> searchProducts(
//        @RequestParam(required = false) String name,
//        @RequestParam(required = false) Integer min,
//        @RequestParam(required = false)Integer max
//) {
//    List<Product> products = productService.searchProducts(name,min,max);
//    return ResponseEntity.status(HttpStatus.OK).body(products);//200
//}
 */

@GetMapping("/products")
public ResponseEntity<List<Product>> getProducts(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Integer min,
        @RequestParam(required = false) Integer max
) {
    List<Product> products;

    // 如果有帶參數，執行搜尋邏輯；沒帶參數，執行獲取全部邏輯
    if (name == null && min == null && max == null) {
        //TODO-Read查詢Product整筆的資料
        products = productService.getAllProducts();
    } else {
        //TODO-Read查詢Product整筆的資料有條件
        products = productService.searchProducts(name, min, max);
    }

    return ResponseEntity.status(HttpStatus.OK).body(products);
}

//    TODO-Read查詢Product單筆資料
    @GetMapping("/products/{productsId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productsId) {
        Product product = productService.getProductById(productsId);
        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);//200
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//404
        }
    }
// TODO-POST-Creat新增一筆新口味雞蛋糕
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest  productRequest) {
        Long productId = productService.createProduct(productRequest);
        Product product  = productService.getProductById(productId);
        System.out.println("新增一筆商品=>"+productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);//201
    }
//    TODO-PUT-查詢編號並更新口味
    @PutMapping("/products/{productsId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productsId,@RequestBody ProductRequest productRequest){
//        檢查productsId是否存在
            Product product = productService.getProductById(productsId);
            if(product==null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//404
            }
//         修改productsId的數據
            productService.updateProduct(productsId,productRequest);
            Product updaateProduct = productService.getProductById(productsId);
            return ResponseEntity.status(HttpStatus.OK).body(updaateProduct);//200
    }
//    TODO-DELETE-刪除一筆資料
    @DeleteMapping("/products/{productsId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable  Long productsId){
        Product product = productService.getProductById(productsId);
        if(product==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//404
        }
        productService.deleteProduct(productsId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();//204
    }

}
