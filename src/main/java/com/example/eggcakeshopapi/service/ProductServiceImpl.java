package com.example.eggcakeshopapi.service;

import com.example.eggcakeshopapi.entity.Product;
import com.example.eggcakeshopapi.repository.ProductDao;
import com.example.eggcakeshopapi.repository.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
//ProductServiceImpl 饌寫伺服器回應的Http 協定代碼
@Component
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;


    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return 0;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {

    }

    @Override
    public void deleteProduct(Integer productId) {

    }
}
