package com.rad.ecommerceapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "shoppingcarts")
public class Shoppingcart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //foreign keys
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "shoppingcart")
    private Set<ShoppingcartProduct> shoppingcartProducts;

}
