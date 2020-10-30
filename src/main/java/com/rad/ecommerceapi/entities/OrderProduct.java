package com.rad.ecommerceapi.entities;

import lombok.*;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "order_product")
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@IdClass(OrderProductKey.class)
public class OrderProduct implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    int quantity;

}
