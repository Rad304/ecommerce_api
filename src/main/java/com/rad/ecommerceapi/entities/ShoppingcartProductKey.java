package com.rad.ecommerceapi.entities;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class ShoppingcartProductKey implements Serializable {

    private Shoppingcart shoppingcart;
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingcartProductKey that = (ShoppingcartProductKey) o;
        return Objects.equals(shoppingcart, that.shoppingcart) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingcart, product);
    }
}
