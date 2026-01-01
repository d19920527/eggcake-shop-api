package com.example.eggcakeshopapi.rowmapper;

import com.example.eggcakeshopapi.entity.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getLong("id"));
        order.setOrderNo(resultSet.getLong("order_no"));
        order.setProductName(resultSet.getString("product_name"));
        order.setQuantity(resultSet.getInt("quantity"));
        order.setPrice(resultSet.getBigDecimal("price"));
        order.setTotalAmount(resultSet.getBigDecimal("total_amount"));
        // 使用 getObject 並指定型別為 LocalDateTime.class
        order.setCreatedAt(resultSet.getObject("created_at", LocalDateTime.class));
        return null;
    }
}
