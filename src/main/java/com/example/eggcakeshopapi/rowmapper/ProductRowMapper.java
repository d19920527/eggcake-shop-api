package com.example.eggcakeshopapi.rowmapper;

import com.example.eggcakeshopapi.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
//負責將MySQL database資料表轉成Object
public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Product  product = new Product();
        product.setId((long) resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getInt("price"));
        return product;
    }
}
