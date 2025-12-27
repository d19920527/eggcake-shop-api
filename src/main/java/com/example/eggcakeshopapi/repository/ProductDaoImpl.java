package com.example.eggcakeshopapi.repository;

import com.example.eggcakeshopapi.dto.ProductRequest;
import com.example.eggcakeshopapi.entity.Product;
import com.example.eggcakeshopapi.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    //  TODO-Read查詢Product(所有)
    @Override
    public List<Product> getAllProducts() {
        String sql = "select * from product ";
        Map<String, Object> map = new HashMap<>();
        List<Product> productsList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        return productsList;
    }
//    TODO-Read查詢Product整筆的資料有條件
    @Override
    public List<Product> getProducts(String name, Integer min, Integer max) {
        // 1. 在 1=1 後面加上一個空格
        StringBuffer sql = new StringBuffer("SELECT * FROM Product WHERE 1=1 ");
        Map<String, Object> map = new HashMap<>();

        if (name != null && !name.isEmpty()) {
            // 2. 確保 AND 前面有空格 (您截圖中已有，這很好)
            sql.append("AND name LIKE :name ");
            map.put("name", "%" + name + "%");
        }

        if (min != null) {
            sql.append("AND price >= :minProduct ");
            map.put("minProduct", min);
        }

        if (max != null) {
            // 3. 這裡通常應該是「小於等於」最大值
            sql.append("AND price <= :maxProduct ");
            map.put("maxProduct", max);
        }

        return namedParameterJdbcTemplate.query(sql.toString(), map, new ProductRowMapper());
    }
    //  TODO-Read查詢Product=>ID
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
    //  TODO-PUT-查詢編號並更新口味
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

//    TODO-刪除一筆資料
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
