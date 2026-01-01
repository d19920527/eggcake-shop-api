package com.example.eggcakeshopapi.dao;

import com.example.eggcakeshopapi.dto.ProductRequest;
import com.example.eggcakeshopapi.entity.Order;
import com.example.eggcakeshopapi.entity.Product;

import java.util.List;

public interface OrderDao {
    //  TODO-Read查詢OrderDao整筆的資料有條件(無參數&有參數皆可查詢)
    List<Order> getOrders(String name, Integer minOrder, Integer maxOrder);
    //  TODO-查詢OrderDao=>ID
    Order getOrderById(Long orderNo) ;
    //  TODO-creat新增OrderDao=>ID
    Long createOrder(ProductRequest productRequest);
    //  TODO-PUT-查詢OrderDao=>ID並更新口味
    void updateOrder(Long orderNo,ProductRequest productRequest);
    //  TODO-刪除OrderDao=>ID
    void deleteOrderDao(Long orderNo);
}
