package com.rad.ecommerceapi.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shoppingcart_product")
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@IdClass(ShoppingcartProductKey.class)
public class ShoppingcartProduct implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "shoppingcart_id")
    private Shoppingcart shoppingcart;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    int quantity;
}
