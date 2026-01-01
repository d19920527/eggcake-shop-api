package com.example.eggcakeshopapi.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
    private Long id;            // 對應 id (INT)
    private Long orderNo;       // 對應 order_no (VARCHAR)
    private String productName;   // 對應 product_name (VARCHAR)
    private Integer quantity;     // 對應 quantity (INT)
    private BigDecimal price;     // 對應 price (DECIMAL)
    private BigDecimal totalAmount; // 對應 total_amount (DECIMAL)
    private LocalDateTime createdAt; // 對應 created_at (TIMESTAMP)

    public Order() {
    }

    // 全參數建構子 (方便快速建立物件)
    public Order(Long orderNo, String productName, Integer quantity, BigDecimal price, BigDecimal totalAmount) {
        this.orderNo = orderNo;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = totalAmount;
    }

    // Getter and Setter (這裡省略，建議使用 IDE 生成或 Lombok)


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
