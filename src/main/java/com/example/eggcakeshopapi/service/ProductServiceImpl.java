package com.example.eggcakeshopapi.service;

import com.example.eggcakeshopapi.entity.Product;
import com.example.eggcakeshopapi.repository.ProductDao;
import com.example.eggcakeshopapi.dto.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
//ProductServiceImpl 饌寫伺服器回應的Http 協定代碼
@Component
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;

    //  TODO-Read查詢Product(所有)
    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
    //    Read查詢Product整筆的資料有條件
    @Override
    public List<Product> searchProducts(String name, Integer min, Integer max) {
        return productDao.getProducts(name,min,max);
    }

    //  TODO-Read查詢Product=>ID
    @Override
    public Product getProductById(Long productId) {
        return productDao.getProductById(productId);
    }
    //   creat新增Product=>ID
    @Override
    public Long createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

//    TODO-PUT-查詢編號並更新口味
    @Override
    public void updateProduct(Long productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }
    //   TODO-刪除Product=>ID
    @Override
    public void deleteProduct(Long productId) {
        productDao.deleteProduct(productId);
    }
}
