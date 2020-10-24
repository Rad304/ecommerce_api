package com.rad.ecommerceapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data @AllArgsConstructor @NoArgsConstructor
public class ShoppingcartProductKey implements Serializable {
    @Column(name = "shoppingcart_id")
    private Long shoppingcardId;
    @Column(name = "product_id")
    private Long productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingcartProductKey that = (ShoppingcartProductKey) o;
        return Objects.equals(shoppingcardId, that.shoppingcardId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingcardId, productId);
    }
}
