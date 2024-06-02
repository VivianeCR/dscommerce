package com.vcr.dscommerce.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
 
@Data
@Entity
@Table(name = "tb_order")
public class OrderModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    private OrderStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserModel client;

    @OneToOne(mappedBy = "order", cascade =  CascadeType.ALL)
     private PaymentModel payment;

     @OneToMany(mappedBy = "id.order")
     private Set<OrderItemModel> items = new HashSet<>();

}
