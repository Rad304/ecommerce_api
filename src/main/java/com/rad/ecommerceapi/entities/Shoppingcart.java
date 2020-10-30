package com.rad.ecommerceapi.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "shoppingcarts")
public class Shoppingcart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //foreign keys
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "shoppingcart", cascade = CascadeType.ALL)
    private Set<ShoppingcartProduct> shoppingcartProducts;

}
