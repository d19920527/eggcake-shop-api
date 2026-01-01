package com.example.eggcakeshopapi.repository;

import com.example.eggcakeshopapi.dao.OrderDao;
import com.example.eggcakeshopapi.dto.ProductRequest;
import com.example.eggcakeshopapi.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDaoImpl implements OrderDao {
    //OrderDaoImpl 撰寫 資料庫SQL 語法的地方
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Order> getOrders(String name, Integer minOrder, Integer maxOrder) {
        return List.of();
    }

    @Override
    public Order getOrderById(Long orderNo) {
        return null;
    }

    @Override
    public Long createOrder(ProductRequest productRequest) {
        return 0L;
    }

    @Override
    public void updateOrder(Long orderNo, ProductRequest productRequest) {

    }

    @Override
    public void deleteOrderDao(Long orderNo) {

    }
}
