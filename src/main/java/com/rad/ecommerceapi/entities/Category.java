package com.rad.ecommerceapi.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "categories")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //Foreign keys
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private Category parent;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")
    private Collection<Category> children;
    @OneToMany(mappedBy = "category")
    private Collection<Product> products;
}
