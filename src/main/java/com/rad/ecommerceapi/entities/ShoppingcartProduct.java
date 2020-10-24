package com.rad.ecommerceapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ShoppingcartProduct {
    @EmbeddedId
    ShoppingcartProductKey id;

    @ManyToOne
    @MapsId("shoppingcardId")
    @JoinColumn(name = "shoppingcart_id")
    Shoppingcart shoppingcart;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    int quantity;
}
