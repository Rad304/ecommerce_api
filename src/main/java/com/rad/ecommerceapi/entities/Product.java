package com.rad.ecommerceapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private double discount_price;
    @Temporal(TemporalType.TIMESTAMP)
    private Date discount_price_expiration_date;
    private String details;
    private String image;
    //foreign keys
    @ManyToOne
    private Category category;
    @ManyToMany(mappedBy = "favorites")
    private Set<User> favorites;
    @OneToMany(mappedBy = "product")
    private Set<ShoppingcartProduct> shoppingcartProducts;
    @OneToMany(mappedBy = "order")
    private Set<OrderProduct> orderProducts;
}
