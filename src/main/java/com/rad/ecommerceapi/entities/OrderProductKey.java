package com.rad.ecommerceapi.entities;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class OrderProductKey implements Serializable {

    private Order order;
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProductKey that = (OrderProductKey) o;
        return Objects.equals(order, that.order) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
