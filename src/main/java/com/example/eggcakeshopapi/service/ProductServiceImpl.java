package com.example.eggcakeshopapi.service;

import com.example.eggcakeshopapi.entity.Product;
import com.example.eggcakeshopapi.repository.ProductDao;
import com.example.eggcakeshopapi.dto.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;
//ProductServiceImpl 饌寫伺服器回應的Http 協定代碼
@Component
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;

    //  TODO-Read查詢Product整筆的資料有條件(無參數&有參數皆可查詢)
    @Override
    public List<Product> searchProducts(String name, Integer min, Integer max) {
            return productDao.getProducts(name, min, max);
    }

    //    TODO-Read查詢Product單筆資料
    @Override
    public Product getProductById(Long productId) {
        return productDao.getProductById(productId);
    }
    // TODO-POST-Creat新增一筆新口味雞蛋糕
    @Override
    public Long createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    //    TODO-PUT-查詢編號並更新口味
    @Override
    public void updateProduct(Long productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }
    //    TODO-DELETE-刪除一筆資料
    @Override
    public void deleteProduct(Long productId) {
        productDao.deleteProduct(productId);
    }
}
