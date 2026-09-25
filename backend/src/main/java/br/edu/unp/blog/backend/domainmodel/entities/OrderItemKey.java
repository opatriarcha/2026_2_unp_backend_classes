package br.edu.unp.blog.backend.domainmodel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;


@Embeddable
@NoArgsConstructor
public class OrderItemKey {
    @Getter
    @Setter
    @Column(name = "order_id")
    private UUID orderId;

    @Getter @Setter
    @Column(name = "item_id")
    private UUID itemId;

    public OrderItemKey(UUID orderId, UUID itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemKey that = (OrderItemKey) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, itemId);
    }
}
