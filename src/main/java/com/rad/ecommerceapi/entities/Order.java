package com.rad.ecommerceapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String status;
    private double total;
    private boolean shipment;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "order")
    private Set<OrderProduct> orderProducts;
}
