package com.rad.ecommerceapi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
	@Size(max = 20)
    private String firstname;

    @NotBlank
	@Size(max = 20)
    private String lastname;

    @NotBlank
	@Size(max = 50)
    private String address;

    @NotBlank
	@Size(max = 10)
    private String tel;

    @NotBlank
    private String gender;

    @NotBlank
	@Size(max = 20)
    private String username;

    @NotBlank
	@Size(max = 120)
    private String password;

    @NotBlank
	@Size(max = 50)
	@Email
    private String email;

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

    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
}
