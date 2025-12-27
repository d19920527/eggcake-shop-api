package com.example.eggcakeshopapi.repository;

import com.example.eggcakeshopapi.entity.Product;
import com.example.eggcakeshopapi.rowmapper.ProductRowMapper;
import com.example.eggcakeshopapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {
    //ProductDaoImpl 撰寫 資料庫SQL 語法的地方
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //  Read查詢Product(所有)
    @Override
    public List<Product> getAllProducts() {
        String sql = "select * from product ";
        Map<String, Object> map = new HashMap<>();
        List<Product> productsList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        return productsList;
    }

    //  Read查詢Product=>ID
    @Override
    public Product getProductById(Long productId) {
        String sql = "select * from product where id = :productId";
        Map<String,Object> map = new HashMap<>();
        map.put("productId",productId);
        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        if(productList.size()>0){
            return productList.get(0);
        }else {
            return null;
        }

    }
    //   creat新增Product=>ID
    @Override
    public Long createProduct(ProductRequest productRequest) {
        String sql="INSERT INTO product (name,price)"+
                "VALUES(:name,:price)";
        Map<String,Object> map = new HashMap<>();
        map.put("name",productRequest.getName());
        map.put("price",productRequest.getPrice());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);
        Long productId = keyHolder.getKey().longValue();
        return productId;
    }


    @Override
    public void updateProduct(Long productId, ProductRequest productRequest) {
        String sql = "UPDATE product SET name = :name," +
                     "price  = :price WHERE id = :productId ";
        Map<String,Object> map = new HashMap<>();
        map.put("productId",productId);

        map.put("name",productRequest.getName());
        map.put("price",productRequest.getPrice());
        namedParameterJdbcTemplate.update(sql,map);

    }

    @Override
    public void deleteProduct(Long productId) {
        String sql = "DELETE FROM product WHERE ID = :productId";
        Map<String,Object> map = new HashMap<>();
        map.put("productId",productId);
        namedParameterJdbcTemplate.update(sql,map);
    }
}
