package com.vcr.dscommerce.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_order_item")
public class OrderItemModel {
    
    @EmbeddedId
    private OrderItemPKModel id = new OrderItemPKModel();

    private Integer quantity;

    private Double price;
}
