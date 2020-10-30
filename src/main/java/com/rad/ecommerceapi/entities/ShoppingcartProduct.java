package com.rad.ecommerceapi.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "shoppingcart_product")
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@IdClass(ShoppingcartProductKey.class)
public class ShoppingcartProduct {

    @Id
    @ManyToOne
    @JoinColumn(name = "shoppingcart_id")
    Shoppingcart shoppingcart;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    int quantity;
}
