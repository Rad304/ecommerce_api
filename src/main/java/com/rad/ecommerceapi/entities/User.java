package com.rad.ecommerceapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String tel;
    private String gender;
    private String username;
    private String password;
    private String email;
    private String role;
    //foreign keys
    @OneToOne(mappedBy = "user")
    private Shoppingcart shoppingCart;
    @OneToMany(mappedBy = "user")
    private Collection<Order> orders;
    @ManyToMany
    @JoinTable(
	  name = "favorites",
	  joinColumns = @JoinColumn(name = "user_id"),
	  inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> favorites;
}
