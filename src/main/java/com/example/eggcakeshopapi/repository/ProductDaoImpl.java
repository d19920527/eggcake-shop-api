package com.example.eggcakeshopapi.repository;

import com.example.eggcakeshopapi.entity.Product;
import com.example.eggcakeshopapi.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao{
//ProductDaoImpl 撰寫 資料庫SQL 語法的地方
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<Product> getAllProducts() {
        String sql = "select * from product ";
        Map<String,Object> map = new HashMap<>();
        List<Product> productsList =namedParameterJdbcTemplate.query(sql,map,new ProductRowMapper());
        if(productsList.size()>0){
            return productsList;
        }else {
            return null;
        }

    }


    @Override
    public Product getProductById(Integer productId) {
        return null;
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
